package de.kisner.jxhml.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import de.kisner.jxhml.model.xml.DeviceList;
import de.kisner.jxhml.model.xml.State;
import de.kisner.jxhml.model.xml.Version;

@Path("/addons/xmlapi")
public interface HomematicXmlRest
{
	@GET @Path("/version.cgi") @Produces(MediaType.APPLICATION_XML)
	Version version();
	
	@GET @Path("/devicelist.cgi") @Produces(MediaType.APPLICATION_XML)
	DeviceList deviceList();
	
	@GET @Path("/state.cgi") @Produces(MediaType.APPLICATION_XML)
	State stateDevice(@QueryParam("device_id") String deviceId);
}