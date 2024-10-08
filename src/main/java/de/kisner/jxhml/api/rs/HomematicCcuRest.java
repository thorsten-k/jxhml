package de.kisner.jxhml.api.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.kisner.jxhml.model.json.rpc.request.JsonRpcIdRequest;
import de.kisner.jxhml.model.json.rpc.request.JsonRpcInterfaceRequest;
import de.kisner.jxhml.model.json.rpc.request.JsonRpcLoginRequest;
import de.kisner.jxhml.model.json.rpc.request.JsonRpcRequest;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcAddonVersionResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcArrayResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcDeviceResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcInterfacesResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcRoomResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcRssiResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcStringResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcSubsectionResponse;
import de.kisner.jxhml.model.json.rpc.response.JsonRpcSysVarResponse;

@Path("/api")
public interface HomematicCcuRest
{
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcStringResponse login(JsonRpcLoginRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	String testRequest(JsonRpcRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	String testId(JsonRpcIdRequest request);
	
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.TEXT_PLAIN) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcStringResponse versionCcu(JsonRpcRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.TEXT_PLAIN) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcAddonVersionResponse versionAddon(JsonRpcRequest request);
	
	
	//Nicht vollständig
	@POST @Path("/homematic.cgi") @Produces(MediaType.TEXT_PLAIN) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcSysVarResponse sysVars(JsonRpcRequest request);
	
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcInterfacesResponse interfaces(JsonRpcRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcArrayResponse regaDatapoints(JsonRpcRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcRssiResponse rssiInfo(JsonRpcInterfaceRequest request);
	
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcArrayResponse devices(JsonRpcRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcDeviceResponse device(JsonRpcIdRequest request);
	
	

	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcRoomResponse rooms(JsonRpcRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcSubsectionResponse subsections(JsonRpcRequest request);
	
	
	//Liefert wenig infos
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	String channelValue(JsonRpcIdRequest request);
	
	@POST @Path("/homematic.cgi") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	JsonRpcStringResponse channelType(JsonRpcIdRequest request);
}