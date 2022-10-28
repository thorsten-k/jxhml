package de.kisner.jxhml.factory.json.rpc;

import org.jeesl.model.json.system.io.ssi.JsonSsiCredential;

import de.kisner.jxhml.model.json.rpc.request.JsonRpcLoginRequest;
import de.kisner.jxhml.model.json.rpc.request.JsonRpcRequest;

public class JsonRpcFactory
{

	public static JsonRpcLoginRequest login(JsonSsiCredential credential)
	{
		return JsonRpcFactory.login(credential.getUser(), credential.getPassword());
	}
	public static JsonRpcLoginRequest login(String username, String password)
	{
		JsonRpcLoginRequest json = new JsonRpcLoginRequest();
		json.setMethod("Session.login");
		
		JsonRpcLoginRequest.JsonRpcRequestLoginParams params = json.new JsonRpcRequestLoginParams();
		params.setUsername(username);
		params.setPassword(password);
		json.setParams(params);
		
		return json;
	}
	
	public static JsonRpcRequest versionCcu(String session){return sessionRequest("CCU.getVersion", session);}
	public static JsonRpcRequest versionAddon(String session){return sessionRequest("CCU.getAddonVersions", session);}
	public static JsonRpcRequest rooms(String session){return sessionRequest("Room.getAll", session);}
	private static JsonRpcRequest sessionRequest(String command, String session)
	{
		JsonRpcRequest json = new JsonRpcRequest();
		json.setMethod(command);
		
		JsonRpcRequest.JsonRpcRequestParams params = json.new JsonRpcRequestParams();
		params.setSession(session);
		json.setParams(params);
		
		return json;
	}
}