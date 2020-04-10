package de.kisner.jxhml.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import de.kisner.jxhml.model.xml.jxhml.Devices;

@Path("/homematic")
public interface SmartCentralRest
{
	@POST @Path("/update/devices") @Consumes(MediaType.APPLICATION_XML)
	void updateDevices(Devices devices);
	
}