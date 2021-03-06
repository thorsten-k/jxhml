package de.kisner.jxhml.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import de.kisner.jxhml.model.xml.jxhml.Device;
import de.kisner.jxhml.model.xml.jxhml.Devices;

@Path("/homematic")
public interface SmartCentralRest
{

	
	@POST @Path("/devices/update") @Consumes(MediaType.APPLICATION_XML)
	void updateDevices(Devices devices);
	
	@POST @Path("/device/update/rssi") @Consumes(MediaType.APPLICATION_XML)
	void updateRssi(Devices devices);
	
	@POST @Path("/device/update/channels") @Consumes(MediaType.APPLICATION_XML)
	void updateChannels(Device device);
	
	@GET @Path("/device/update/{code}/{value}")
	void update(@PathParam("code") String code, @PathParam("value") String value);
	
}