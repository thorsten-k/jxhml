package de.kisner.jxhml.api.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import de.kisner.jxhml.api.i.HomematicWebRestInterface;
import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.xml.jxhml.Devices;

@Path("/homematic")
public interface HomematicWebRest extends HomematicWebRestInterface
{
	@POST @Path("/devices/update") @Consumes(MediaType.APPLICATION_JSON)
	void updateDevices(JsonHmContainer devices);
	
	@POST @Path("/update/rooms") @Consumes(MediaType.APPLICATION_JSON)
	void updateRooms(JsonHmContainer rooms);
	
	@POST @Path("/update/subsections") @Consumes(MediaType.APPLICATION_JSON)
	void updateSubsections(JsonHmContainer subsections);
	
	
	@POST @Path("/device/update/rssi") @Consumes(MediaType.APPLICATION_XML)
	void updateRssi(Devices devices);
	
	@GET @Path("/device/update/{code}/{value}")
	void update(@PathParam("code") String code, @PathParam("value") String value);

}