package de.kisner.jxhml.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils;
import org.exlp.util.io.JsonUtil;
import org.jeesl.factory.json.system.status.JsonTypeFactory;
import org.jeesl.model.json.io.ssi.core.JsonSsiCredential;
import org.jeesl.model.json.system.status.JsonRadio;
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
import de.kisner.jxhml.interfaces.HmDataPointEnums;
import de.kisner.jxhml.model.json.hm.JsonHmChannel;
import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.json.hm.JsonHmDevice;
import de.kisner.jxhml.model.json.hm.JsonHmPoint;
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
	
	@Override public JsonHmContainer devices()
	{
		JsonHmContainer response = JsonHmContainerFactory.build();
		response.setDevices(new ArrayList<>());
		
		JsonRpcStringResponse login = restCcu.login(JsonRpcFactory.login(credential));
		
		JsonRpcArrayResponse hmResponse = restCcu.devices(JsonRpcFactory.devices(login.getResult()));
		logger.info("Downloaded "+hmResponse.getResult().length+" device codes");
		
//		String str = "4228"; String[] array = {str}; list.setResult(array);
		List<String> list = Arrays.asList(hmResponse.getResult());
		
		for(String code : list)
		{
			logger.info(list.indexOf(code)+"/"+list.size()+" "+code);
			JsonRpcDeviceResponse rcpDevice = restCcu.device(JsonRpcFactory.device(login.getResult(),code));
			if(Objects.nonNull(rcpDevice.getError()))
			{
				logger.warn("Error with code: "+code);
			}
			else
			{
				JsonHmDevice hmDevcie = JsonHmDeviceFactory.build(rcpDevice.getResult());
				
				JsonUtil.trace(rcpDevice);

				for(JsonHmChannel jChannel : hmDevcie.getChannels())
				{
					JsonRpcStringResponse rcpChannelType = restCcu.channelType(JsonRpcFactory.channelType(login.getResult(),jChannel.getCode()));
					logger.trace(jChannel.getPosition()+" "+rcpChannelType.getResult());
					jChannel.setType(JsonTypeFactory.build(rcpChannelType.getResult()));
				}
				JsonUtil.trace(hmDevcie);
				
				response.getDevices().add(hmDevcie);
			}
		}
		logger.info("Downloaded "+response.getDevices().size()+" "+JsonHmDevice.class.getSimpleName());
		return response;
	}
	
	@Override public JsonHmContainer points()
	{
		JsonRpcStringResponse login = restCcu.login(JsonRpcFactory.login(credential));
		JsonRpcArrayResponse response =  restCcu.regaDatapoints(JsonRpcFactory.regaDatapoints(login.getResult()));
		
		JsonHmContainer container = JsonHmContainerFactory.build();
		container.setPoints(new ArrayList<>());
		for(String dp : response.getResult())
		{
		
			JsonHmPoint json = new JsonHmPoint();
			json.setRaw(dp);
			String[] s = dp.split("--");
			
			if(s.length>0) {json.setId(s[0]);}
			if(s.length>1) {json.setType(s[1]);}
			
			if(s.length>2 && json.getType().equals(HmDataPointEnums.Type.HSSDP.toString()))
			{
				json.setCode(s[2]);
			}
			
			if(ObjectUtils.allNotNull(json.getId(),json.getType()))
			{
				if(json.getType().equals(HmDataPointEnums.Type.HSSDP.toString()))
				{
					
					String[] d = s[2].split("\\.");
					if(d.length!=3) {logger.warn(s[2]+" "+d.length);}
					else
					{
						json.setCode(d[2]);
						
						
						
						JsonRadio radio = new JsonRadio();
						radio.setCode(d[0]);
						
						String[] x = d[1].split(":");
						JsonHmChannel channel = new JsonHmChannel();
						channel.setPosition(Integer.valueOf(x[1]));
						
						JsonHmDevice device = JsonHmDeviceFactory.build();
						device.setAddress(x[0]);
						device.setRadio(radio);
						channel.setDevice(device);
						
						json.setChannel(channel);
						
						container.getPoints().add(json);
					}
					
					
				}
			}
			
		}
		
		return container;
	}
	
	@Override public de.kisner.jxhml.model.xml.jxhml.Device deviceWithChannels(String id)
	{
		for(Device d : restXml.deviceList().getDevice())
		{
			if(d.getIseId().equals(id)) {return XmlDeviceFactory.withChannels(d);}
		}
		return XmlDeviceFactory.build();
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

	
}