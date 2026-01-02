package de.kisner.jxhml.factory.json.hm;

import java.util.ArrayList;

import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcRoom;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcSubsection;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcSystemVariable;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcRoomResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcSubsectionResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcSysVarResponse;

public class JsonHmContainerFactory
{
	public static JsonHmContainer build() {return new JsonHmContainer();}
	
	public static JsonHmContainer build(JsonRpcRoomResponse response)
	{
		JsonHmContainer json = build();
		json.setRooms(new ArrayList<>());
		
		for(JsonRpcRoom rpc : response.getResult())
		{
			json.getRooms().add(JsonHmRoomFactory.build(rpc));
		}
		
		return json;
	}
	
	public static JsonHmContainer build(JsonRpcSubsectionResponse response)
	{
		JsonHmContainer json = build();
		json.setSubsections(new ArrayList<>());
		
		for(JsonRpcSubsection rpc : response.getResult())
		{
			json.getSubsections().add(JsonHmSubsectionFactory.build(rpc));
		}
		
		return json;
	}
	
	public static JsonHmContainer build(JsonRpcSysVarResponse response)
	{
		JsonHmContainer json = build();
		json.setVars(new ArrayList<>());
		
		for(JsonRpcSystemVariable rpc : response.getResult())
		{
			json.getVars().add(JsonHmVarFactory.build(rpc));
		}
		
		return json;
	}
	
}