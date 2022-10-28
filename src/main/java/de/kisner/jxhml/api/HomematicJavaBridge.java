package de.kisner.jxhml.api;

import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.xml.jxhml.Device;
import de.kisner.jxhml.model.xml.jxhml.Devices;
import de.kisner.jxhml.model.xml.jxhml.Version;

public interface HomematicJavaBridge
{
	Version version();
	Devices devicesId();
	Devices devicesDetail();
	Devices devicesRssi();
	Device deviceWithChannels(String code);
//	Device deviceWithData(String code);
	
	JsonHmContainer rooms();
}