package de.kisner.jxhml.api.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.kisner.jxhml.model.json.rpc.request.JsonRpcLoginRequest;
import de.kisner.jxhml.model.json.rpc.request.JsonRpcRequest;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcLoginResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcRoomResponse;

@Path("/api")
public interface HomematicJsonRest
{
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcLoginResponse login(JsonRpcLoginRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcRoomResponse rooms(JsonRpcRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	String test(JsonRpcRequest request);
}