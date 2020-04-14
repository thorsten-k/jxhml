package de.kisner.jxhml.factory.xml;

import java.util.Date;

import de.kisner.jxhml.model.xml.jxhml.Data;
import de.kisner.jxhml.model.xml.jxhml.Datas;

public class XmlDatasFactory
{
	public static Datas build(){return new Datas();}
	public static Datas build(Date record)
	{
		Datas xml = build();
		xml.setRecord(XmlDataFactory.toXmlGc(record));
		return xml;
	}
	
	public static Datas build(Data data)
	{
		 Datas xml = build();
		 xml.getData().add(data);
		 return xml;
	}
}