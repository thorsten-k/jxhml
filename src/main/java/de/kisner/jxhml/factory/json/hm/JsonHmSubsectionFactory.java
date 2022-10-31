package de.kisner.jxhml.factory.json.hm;

import java.util.ArrayList;
import java.util.Objects;

import de.kisner.jxhml.model.json.hm.JsonHmSubsection;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcSubsection;

public class JsonHmSubsectionFactory
{
	public static JsonHmSubsection build() {return new JsonHmSubsection();}
	
	public static JsonHmSubsection build(JsonRpcSubsection room)
	{
		JsonHmSubsection json = build();
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