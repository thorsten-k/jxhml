package de.kisner.jxhml.factory.json.hm;

import java.util.ArrayList;
import java.util.Objects;

import org.jeesl.factory.json.system.status.JsonRadioFactory;
import org.jeesl.factory.json.system.status.JsonTypeFactory;

import de.kisner.jxhml.model.json.hm.JsonHmDevice;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcChannel;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcDevice;

public class JsonHmDeviceFactory
{
	public static JsonHmDevice build() {return new JsonHmDevice();}
	
	public static JsonHmDevice build(JsonRpcDevice device)
	{
		JsonHmDevice json = build();
		json.setCode(device.getId());
		json.setAddress(device.getAddress());
		json.setName(device.getName());
		
		json.setType(JsonTypeFactory.build(device.getType()));
		json.setRadio(JsonRadioFactory.build(device.getIface()));
		
		if(Objects.nonNull(device.getChannels()))
		{
			json.setChannels(new ArrayList<>());
			for(JsonRpcChannel rcp : device.getChannels())
			{
				json.getChannels().add(JsonHmChannelFactory.build(rcp));
			}
		}
		
		return json;
	}
}