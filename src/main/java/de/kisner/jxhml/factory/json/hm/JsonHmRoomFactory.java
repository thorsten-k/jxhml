package de.kisner.jxhml.factory.json.hm;

import de.kisner.jxhml.model.json.hm.JsonHmRoom;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcRoom;

public class JsonHmRoomFactory
{
	public static JsonHmRoom build() {return new JsonHmRoom();}
	
	public static JsonHmRoom build(JsonRpcRoom room)
	{
		JsonHmRoom json = build();
		json.setCode(room.getId());
		json.setName(room.getName());
		
		return json;
	}
}