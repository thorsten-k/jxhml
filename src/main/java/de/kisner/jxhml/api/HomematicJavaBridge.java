package de.kisner.jxhml.api;

import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.xml.jxhml.Device;
import de.kisner.jxhml.model.xml.jxhml.Devices;

public interface HomematicJavaBridge
{
	Devices devicesId();
	Devices devicesDetail();
	Devices devicesRssi();
	Device deviceWithChannels(String code);
//	Device deviceWithData(String code);
	
	JsonHmContainer versions();
	JsonHmContainer rooms();
}