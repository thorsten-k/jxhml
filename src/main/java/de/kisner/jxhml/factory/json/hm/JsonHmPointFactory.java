package de.kisner.jxhml.factory.json.hm;

import de.kisner.jxhml.model.json.hm.JsonHmPoint;

public class JsonHmPointFactory
{
	
	public static String toChannelKey(JsonHmPoint point)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(point.getChannel().getDevice().getAddress());
		sb.append(":");
		sb.append(point.getChannel().getPosition());
		
		return sb.toString();
	}
}