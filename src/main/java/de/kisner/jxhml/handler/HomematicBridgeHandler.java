package de.kisner.jxhml.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jeesl.model.json.system.io.ssi.JsonSsiCredential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.jxhml.api.HomematicJavaBridge;
import de.kisner.jxhml.api.rs.HomematicJsonRest;
import de.kisner.jxhml.api.rs.HomematicXmlRest;
import de.kisner.jxhml.factory.json.hm.JsonHmContainerFactory;
import de.kisner.jxhml.factory.json.rpc.JsonRpcFactory;
import de.kisner.jxhml.factory.xml.XmlDataFactory;
import de.kisner.jxhml.factory.xml.XmlDatasFactory;
import de.kisner.jxhml.factory.xml.XmlDeviceFactory;
import de.kisner.jxhml.factory.xml.XmlDevicesFactory;
import de.kisner.jxhml.factory.xml.XmlVersionFactory;
import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcLoginResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcRoomResponse;
import de.kisner.jxhml.model.xml.api.Device;
import de.kisner.jxhml.model.xml.api.Rssi;
import de.kisner.jxhml.model.xml.jxhml.Datas;
import de.kisner.jxhml.model.xml.jxhml.Devices;
import de.kisner.jxhml.model.xml.jxhml.Version;
import net.sf.exlp.util.io.JsonUtil;

public class HomematicBridgeHandler implements HomematicJavaBridge
{
	final static Logger logger = LoggerFactory.getLogger(HomematicBridgeHandler.class);
	
	private final JsonSsiCredential credential;
	private final HomematicXmlRest rest;
	private final HomematicJsonRest restJson;
	
	public HomematicBridgeHandler(JsonSsiCredential credential, HomematicXmlRest rest, HomematicJsonRest restJson)
	{
		this.credential=credential;
		this.rest=rest;
		this.restJson=restJson;
	}

	@Override public Version version() {return XmlVersionFactory.version(rest.version());}

	@Override public Devices devicesId()
	{
		Devices xml = XmlDevicesFactory.build();
		for(Device d : rest.deviceList().getDevice())
		{
			xml.getDevice().add(XmlDeviceFactory.id(d));
		}
		
		return xml;
	}
	
	@Override public Devices devicesDetail()
	{
		Devices xml = XmlDevicesFactory.build();
		for(Device d : rest.deviceList().getDevice())
		{
			xml.getDevice().add(XmlDeviceFactory.withChannels(d));
		}
		
		return xml;
	}

	@Override public de.kisner.jxhml.model.xml.jxhml.Device deviceWithChannels(String id)
	{
		for(Device d : rest.deviceList().getDevice())
		{
			if(d.getIseId().equals(id)) {return XmlDeviceFactory.withChannels(d);}
		}
		return XmlDeviceFactory.build();
	}

	@Override
	public Devices devicesRssi()
	{
		Date record = new Date();
		Map<String,de.kisner.jxhml.model.xml.jxhml.Device> map = new HashMap<>();
		for(de.kisner.jxhml.model.xml.jxhml.Device d : devicesDetail().getDevice())
		{
			logger.info(d.getAddress());
			map.put(d.getAddress(),d);
		}
		logger.info("Map: "+map.size());
		
		Devices xml = XmlDevicesFactory.build();
		for(Rssi rssi : rest.rssiList().getRssi())
		{
			if(map.containsKey(rssi.getDevice()))
			{
				de.kisner.jxhml.model.xml.jxhml.Device dMap = map.get(rssi.getDevice());
				de.kisner.jxhml.model.xml.jxhml.Device dRssi = XmlDeviceFactory.build();
				dRssi.setCode(dMap.getCode());
				dRssi.setAddress(dMap.getAddress());
				
				Datas datas = XmlDatasFactory.build(record);
				if(rssi.getRx()!=65536) {datas.getData().add(XmlDataFactory.build(rssi.getRx(),"rx"));}
				if(rssi.getTx()!=65536) {datas.getData().add(XmlDataFactory.build(rssi.getTx(),"tx"));}
				dRssi.setDatas(datas);
				
				xml.getDevice().add(dRssi);
			}
		}
		
		return xml;
	}

	@Override public JsonHmContainer rooms()
	{
		JsonRpcLoginResponse login = restJson.login(JsonRpcFactory.login("Admin","admin"));
		JsonRpcRoomResponse response = restJson.rooms(JsonRpcFactory.rooms(login.getResult()));
		JsonUtil.info(response);
		return JsonHmContainerFactory.build(response);
	}
}