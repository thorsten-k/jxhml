package de.kisner.jxhml.factory.json.rpc;

import org.jeesl.model.json.system.io.ssi.JsonSsiCredential;

import de.kisner.jxhml.model.json.rpc.request.JsonRpcIdRequest;
import de.kisner.jxhml.model.json.rpc.request.JsonRpcInterfaceRequest;
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
	
	public static JsonRpcIdRequest device(String session, String id)
	{
		JsonRpcIdRequest json = new JsonRpcIdRequest();
		json.setMethod("Device.get");
		
		JsonRpcIdRequest.JsonRpcIdRequestParams params = json.new JsonRpcIdRequestParams();
		params.setSession(session);
		params.setId(id);
		json.setParams(params);
		
		return json;
	}
	public static JsonRpcIdRequest channelId(String session, String id)
	{
		JsonRpcIdRequest json = new JsonRpcIdRequest();
		json.setMethod("Channel.getValue");
		
		JsonRpcIdRequest.JsonRpcIdRequestParams params = json.new JsonRpcIdRequestParams();
		params.setSession(session);
		params.setId(id);
		json.setParams(params);
		
		return json;
	}
	
	public static JsonRpcInterfaceRequest rssi(String session, String iface)
	{
		JsonRpcInterfaceRequest json = new JsonRpcInterfaceRequest();
		json.setMethod("Interface.rssiInfo");
		
		JsonRpcInterfaceRequest.JsonRpcIdRequestParams params = json.new JsonRpcIdRequestParams();
		params.setSession(session);
		params.setIface(iface);
		json.setParams(params);
		
		return json;
	}
	
	public static JsonRpcRequest versionCcu(String session){return sessionRequest("CCU.getVersion", session);}
	public static JsonRpcRequest versionAddon(String session){return sessionRequest("CCU.getAddonVersions", session);}
	public static JsonRpcRequest sysVars(String session){return sessionRequest("SysVar.getAll", session);}
	public static JsonRpcRequest devices(String session){return sessionRequest("Device.listAll", session);}
	public static JsonRpcRequest interfaces(String session){return sessionRequest("Interface.listInterfaces", session);}
	public static JsonRpcRequest rooms(String session){return sessionRequest("Room.getAll", session);}
	public static JsonRpcRequest subsections(String session){return sessionRequest("Subsection.getAll", session);}
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