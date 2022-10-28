package de.kisner.jxhml.factory.json.hm;

import java.util.ArrayList;

import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcRoom;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcRoomResponse;

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
	
}