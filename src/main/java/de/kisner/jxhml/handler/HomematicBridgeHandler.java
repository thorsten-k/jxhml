package de.kisner.jxhml.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.jeesl.model.json.io.ssi.core.JsonSsiCredential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.jxhml.api.HomematicJavaBridge;
import de.kisner.jxhml.api.rs.HomematicCcuRest;
import de.kisner.jxhml.api.rs.HomematicXmlRest;
import de.kisner.jxhml.factory.json.hm.JsonHmContainerFactory;
import de.kisner.jxhml.factory.json.hm.JsonHmDeviceFactory;
import de.kisner.jxhml.factory.json.hm.JsonHmVersionFactory;
import de.kisner.jxhml.factory.json.rpc.JsonRpcFactory;
import de.kisner.jxhml.factory.xml.XmlDeviceFactory;
import de.kisner.jxhml.factory.xml.XmlDevicesFactory;
import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.json.hm.JsonHmDevice;
import de.kisner.jxhml.model.json.hm.JsonHmVersion;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcVersionLocal;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcVersionOnline;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcAddonVersionResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcAddonVersionResponse.JsonRpcVersionResult;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcArrayResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcDeviceResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcRoomResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcStringResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcSubsectionResponse;
import de.kisner.jxhml.model.xml.api.Device;
import de.kisner.jxhml.model.xml.jxhml.Devices;
import net.sf.exlp.util.io.JsonUtil;

public class HomematicBridgeHandler implements HomematicJavaBridge
{
	final static Logger logger = LoggerFactory.getLogger(HomematicBridgeHandler.class);
	
	private final JsonSsiCredential credential;
	private final HomematicXmlRest restXml;
	private final HomematicCcuRest restCcu;
	
	public HomematicBridgeHandler(JsonSsiCredential credential, HomematicXmlRest restXml, HomematicCcuRest restJson)
	{
		this.credential=credential;
		this.restXml=restXml;
		this.restCcu=restJson;
	}

	@Override public Devices devicesId()
	{
		Devices xml = XmlDevicesFactory.build();
		for(Device d : restXml.deviceList().getDevice())
		{
			xml.getDevice().add(XmlDeviceFactory.id(d));
		}
		
		return xml;
	}
	
	@Override public Devices devicesDetail()
	{
		Devices xml = XmlDevicesFactory.build();
		for(Device d : restXml.deviceList().getDevice())
		{
			xml.getDevice().add(XmlDeviceFactory.withChannels(d));
		}
		
		return xml;
	}

	@Override public de.kisner.jxhml.model.xml.jxhml.Device deviceWithChannels(String id)
	{
		for(Device d : restXml.deviceList().getDevice())
		{
			if(d.getIseId().equals(id)) {return XmlDeviceFactory.withChannels(d);}
		}
		return XmlDeviceFactory.build();
	}

	@Override public JsonHmContainer versions()
	{
		JsonHmContainer response = JsonHmContainerFactory.build();
		response.setVersions(new ArrayList<>());
		Map<String,JsonHmVersion> map = new HashMap<>();
		
		JsonRpcStringResponse login = restCcu.login(JsonRpcFactory.login(credential));
		
		JsonRpcStringResponse vCcu = restCcu.versionCcu(JsonRpcFactory.versionCcu(login.getResult()));
		response.getVersions().add(JsonHmVersionFactory.buildLocal("CCU",vCcu.getResult()));
		
		JsonRpcAddonVersionResponse vAddonResponse = restCcu.versionAddon(JsonRpcFactory.versionAddon(login.getResult()));
		JsonRpcVersionResult vAddon = vAddonResponse.getResult();
		
		for(JsonRpcVersionLocal v : vAddon.getLocal())
		{
			if(!map.containsKey(v.getName())) {map.put(v.getName(),JsonHmVersionFactory.build(v));}
		}
		for(JsonRpcVersionOnline v : vAddon.getOnline())
		{
			if(!map.containsKey(v.getName())) {map.put(v.getName(),JsonHmVersionFactory.build(v));}
			map.get(v.getName()).setWeb(v.getWebversion());
		}
		response.getVersions().addAll(map.values());
		
		return response;
	}
	
	@Override public JsonHmContainer devices()
	{
		JsonHmContainer response = JsonHmContainerFactory.build();
		response.setDevices(new ArrayList<>());
		
		JsonRpcStringResponse login = restCcu.login(JsonRpcFactory.login(credential));
		
		JsonRpcArrayResponse list = restCcu.devices(JsonRpcFactory.devices(login.getResult()));
		for(String code : list.getResult())
		{
			logger.info(code);
			JsonRpcDeviceResponse rcpDevice = restCcu.device(JsonRpcFactory.device(login.getResult(),code));
			if(Objects.nonNull(rcpDevice.getError()))
			{
				logger.warn("Error with code: "+code);
			}
			else
			{
				JsonHmDevice hmDevcie = JsonHmDeviceFactory.build(rcpDevice.getResult());
				
				JsonUtil.trace(rcpDevice);
				JsonUtil.trace(hmDevcie);
				
				response.getDevices().add(hmDevcie);
			}
		}
		return response;
	}
	
	@Override public JsonHmContainer rooms()
	{
		JsonRpcStringResponse login = restCcu.login(JsonRpcFactory.login(credential));
		JsonRpcRoomResponse response = restCcu.rooms(JsonRpcFactory.rooms(login.getResult()));
		return JsonHmContainerFactory.build(response);
	}

	@Override public JsonHmContainer subsections()
	{
		JsonRpcStringResponse login = restCcu.login(JsonRpcFactory.login(credential));
		JsonRpcSubsectionResponse response = restCcu.subsections(JsonRpcFactory.subsections(login.getResult()));
		return JsonHmContainerFactory.build(response);
	}
}