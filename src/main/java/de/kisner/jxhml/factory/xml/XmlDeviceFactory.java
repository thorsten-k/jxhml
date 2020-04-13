package de.kisner.jxhml.factory.xml;

import de.kisner.jxhml.model.xml.api.Channel;
import de.kisner.jxhml.model.xml.jxhml.Channels;
import de.kisner.jxhml.model.xml.jxhml.Radio;
import de.kisner.jxhml.model.xml.jxhml.Type;

public class XmlDeviceFactory
{
	public static de.kisner.jxhml.model.xml.jxhml.Device build() {return new de.kisner.jxhml.model.xml.jxhml.Device();}
	
	public static de.kisner.jxhml.model.xml.jxhml.Device id(de.kisner.jxhml.model.xml.api.Device api)
	{
		de.kisner.jxhml.model.xml.jxhml.Device xml = build();
		xml.setCode(api.getIseId());
		return xml;
	}
	
	public static de.kisner.jxhml.model.xml.jxhml.Device withChannels(de.kisner.jxhml.model.xml.api.Device api)
	{
		de.kisner.jxhml.model.xml.jxhml.Device xml = build();
		xml.setCode(api.getIseId());
		xml.setAddress(api.getAddress());
		
		Radio radio = new Radio();
		radio.setCode(api.getInterface());
		xml.setRadio(radio);
		
		Type type = new Type();
		type.setCode(api.getDeviceType());
		xml.setType(type);
		
		Channels channels = XmlChannelsFactory.build();
		for(Channel c : api.getChannel()) {channels.getChannel().add(XmlChannelFactory.build(c));}
		xml.setChannels(channels);

		return xml;
	}
	
	public static de.kisner.jxhml.model.xml.jxhml.Device withData(de.kisner.jxhml.model.xml.api.Device api)
	{
		de.kisner.jxhml.model.xml.jxhml.Device xml = build();
		xml.setCode(api.getIseId());
		xml.setAddress(api.getAddress());
		
		Radio radio = new Radio();
		radio.setCode(api.getInterface());
		xml.setRadio(radio);
		
		Type type = new Type();
		type.setCode(api.getDeviceType());
		xml.setType(type);
		
		Channels channels = XmlChannelsFactory.build();
		for(Channel c : api.getChannel()) {channels.getChannel().add(XmlChannelFactory.build(c));}
		xml.setChannels(channels);

		return xml;
	}
}