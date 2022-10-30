package de.kisner.jxhml.factory.json.hm;

import org.jeesl.factory.json.system.status.JsonCategoryFactory;
import org.jeesl.factory.json.system.status.JsonModeFactory;

import de.kisner.jxhml.model.json.hm.JsonHmChannel;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcChannel;

public class JsonHmChannelFactory
{
	public static JsonHmChannel build() {return new JsonHmChannel();}
	
	public static JsonHmChannel build(String code) {JsonHmChannel json = build(); json.setCode(code); return json;}
	
	public static JsonHmChannel build(JsonRpcChannel channel)
	{
		JsonHmChannel json = build();
		json.setCode(channel.getId());
		json.setPosition(channel.getIndex());
		json.setAddress(channel.getAddress());
		json.setName(channel.getName());
		
		json.setCategory(JsonCategoryFactory.build(channel.getCategory()));
		json.setMode(JsonModeFactory.build(channel.getMode()));
		
		return json;
	}
}