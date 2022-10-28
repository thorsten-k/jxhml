package de.kisner.jxhml.factory.json.hm;

import de.kisner.jxhml.model.json.hm.JsonHmVersion;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcVersionLocal;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcVersionOnline;

public class JsonHmVersionFactory
{
	
	
	public static JsonHmVersion build(JsonRpcVersionLocal local)
	{
		return buildLocal(local.getName(),local.getLocalversion());
	}
	public static JsonHmVersion build(JsonRpcVersionOnline online)
	{
		return buildRemote(online.getName(),online.getWebversion());
	}
	
	public static JsonHmVersion build() {return new JsonHmVersion();}
	public static JsonHmVersion buildLocal(String name, String version)
	{
		JsonHmVersion json = build(name);
		json.setLocal(version);
		return json;
	}
	public static JsonHmVersion buildRemote(String name, String version)
	{
		JsonHmVersion json = build(name);
		json.setWeb(version);
		return json;
	}
	public static JsonHmVersion build(String name)
	{
		JsonHmVersion json = build();
		json.setName(name);
		return json;
	}
}