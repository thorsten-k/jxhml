package de.kisner.jxhml.api.i;

import javax.ws.rs.PathParam;

import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.xml.jxhml.Device;
import de.kisner.jxhml.model.xml.jxhml.Devices;

public interface HomematicModuleRestInterface
{
	void updateDevices(Devices devices);
	void updateRssi(Devices devices);
	void updateChannels(Device device);
	void update(@PathParam("code") String code, @PathParam("value") String value);
	
	void updateRooms(JsonHmContainer rooms);
}