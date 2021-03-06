package de.kisner.jxhml.factory.xml;

public class XmlChannelFactory
{
	public static de.kisner.jxhml.model.xml.jxhml.Channel build() {return new de.kisner.jxhml.model.xml.jxhml.Channel();}
	public static de.kisner.jxhml.model.xml.jxhml.Channel build(de.kisner.jxhml.model.xml.api.Channel api)
	{
		de.kisner.jxhml.model.xml.jxhml.Channel xml = build();
		xml.setCode(""+api.getIseId());
		
		String[] split = api.getName().split(":");
		if(split.length==2)
		{
			xml.setNr(Integer.valueOf(split[1]));
		}


		return xml;
	}
}