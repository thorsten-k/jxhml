package de.kisner.jxhml.factory.xml;

import de.kisner.jxhml.model.xml.jxhml.Device;
import de.kisner.jxhml.model.xml.jxhml.Devices;

public class XmlDevicesFactory
{

	public static Devices build(){return new Devices();}
	
	public static Devices build(Device device)
	{
		Devices xml = build();
		xml.getDevice().add(device);
		return xml;
	}
}