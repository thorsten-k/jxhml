package de.kisner.jxhml.factory.json.hm;

import java.util.ArrayList;
import java.util.Objects;

import de.kisner.jxhml.model.json.hm.JsonHmRoom;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcRoom;

public class JsonHmRoomFactory
{
	public static JsonHmRoom build() {return new JsonHmRoom();}
	
	public static JsonHmRoom build(String name)
	{
		JsonHmRoom json = JsonHmRoomFactory.build();
		
		json.setName(name);
		
		return json;
	}
	
	public static JsonHmRoom build(JsonRpcRoom room)
	{
		JsonHmRoom json = build();
		json.setCode(room.getId());
		json.setName(room.getName());
		
		if(Objects.nonNull(room.getChannelIds()))
		{
			json.setChannels(new ArrayList<>());
			for(String code : room.getChannelIds())
			{
				json.getChannels().add(JsonHmChannelFactory.build(code));
			}
		}
		return json;
	}
}