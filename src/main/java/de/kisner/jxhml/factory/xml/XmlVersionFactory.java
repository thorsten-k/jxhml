package de.kisner.jxhml.factory.xml;

public class XmlVersionFactory
{

	public static de.kisner.jxhml.model.xml.jxhml.Version version(de.kisner.jxhml.model.xml.api.Version api)
	{
		de.kisner.jxhml.model.xml.jxhml.Version xml = new de.kisner.jxhml.model.xml.jxhml.Version();
		xml.setValue(api.getValue());
		return xml;
	}

}