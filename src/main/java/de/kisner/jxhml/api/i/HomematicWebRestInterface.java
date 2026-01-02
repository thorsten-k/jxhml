package de.kisner.jxhml.api.i;

import javax.ws.rs.PathParam;

import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.xml.jxhml.Devices;

public interface HomematicWebRestInterface
{
	void updateVersions(JsonHmContainer rooms);
	void updateRooms(JsonHmContainer rooms);
	void updateSubsections(JsonHmContainer subsections);
	void updateDevices(JsonHmContainer devices);
	void updatePoints(JsonHmContainer points);
	
	void updateVars(JsonHmContainer vars);
	void updateRssi(Devices devices);
	void update(@PathParam("code") String code, @PathParam("value") String value);
}