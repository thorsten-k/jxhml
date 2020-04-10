package de.kisner.jxhml.handler;

import de.kisner.jxhml.api.HomematicJavaApi;
import de.kisner.jxhml.api.HomematicXmlApi;
import de.kisner.jxhml.factory.xml.XmlDeviceFactory;
import de.kisner.jxhml.factory.xml.XmlDevicesFactory;
import de.kisner.jxhml.factory.xml.XmlVersionFactory;
import de.kisner.jxhml.model.xml.api.Device;
import de.kisner.jxhml.model.xml.jxhml.Devices;
import de.kisner.jxhml.model.xml.jxhml.Version;


public class HomematicXmlHandler implements HomematicJavaApi
{
	private final HomematicXmlApi rest;
	
	public HomematicXmlHandler(HomematicXmlApi rest)
	{
		this.rest=rest;
	}

	@Override public Version version() {return XmlVersionFactory.version(rest.version());}

	@Override public Devices devicesId()
	{
		Devices xml = XmlDevicesFactory.build();
		for(Device d : rest.deviceList().getDevice())
		{
			xml.getDevice().add(XmlDeviceFactory.id(d));
		}
		
		return xml;
	}
	
	@Override public Devices devicesDetail()
	{
		Devices xml = XmlDevicesFactory.build();
		for(Device d : rest.deviceList().getDevice())
		{
			xml.getDevice().add(XmlDeviceFactory.full(d));
		}
		
		return xml;
	}

	@Override public de.kisner.jxhml.model.xml.jxhml.Device device(String id)
	{
		for(Device d : rest.deviceList().getDevice())
		{
			if(d.getIseId().equals(id)) {return XmlDeviceFactory.full(d);}
		}
		return XmlDeviceFactory.build();
	}
}