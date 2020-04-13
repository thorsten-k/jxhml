package de.kisner.jxhml.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import de.kisner.jxhml.model.xml.api.DeviceList;
import de.kisner.jxhml.model.xml.api.RssiList;
import de.kisner.jxhml.model.xml.api.State;
import de.kisner.jxhml.model.xml.api.Version;

@Path("/addons/xmlapi")
public interface HomematicXmlApi
{
	@GET @Path("/version.cgi") @Produces(MediaType.APPLICATION_XML)
	Version version();
	
	@GET @Path("/devicelist.cgi") @Produces(MediaType.APPLICATION_XML)
	DeviceList deviceList();
	
	@GET @Path("/rssilist.cgi") @Produces(MediaType.APPLICATION_XML)
	RssiList rssiList();
	
	@GET @Path("/state.cgi") @Produces(MediaType.APPLICATION_XML)
	State stateDevice(@QueryParam("device_id") String deviceId);
	
	@GET @Path("/state.cgi") @Produces(MediaType.APPLICATION_XML)
	State stateChannel(@QueryParam("channel_id") String channelId);
	
	@GET @Path("/state.cgi") @Produces(MediaType.APPLICATION_XML)
	State stateDatapoint(@QueryParam("datapoint_id") String datapointId);
	
	
}