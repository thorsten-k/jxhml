package de.kisner.jxhml.factory.xml;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import de.kisner.jxhml.model.xml.jxhml.Data;

public class XmlDataFactory
{	
	public static Data build(){return new Data();}
	
	public static Data build(Integer value, String type) {return build(value,type,null);}
	public static Data build(Integer value, String type, Date record)
	{
		Data xml = build();
		xml.setValue(value);
		xml.setType(type);
		if(record!=null) {xml.setRecord(XmlDataFactory.toXmlGc(record));}
		return xml;
	}
	
	public static Data build(Date record, Double value)
	{
		Data xml = build();
		xml.setRecord(XmlDataFactory.toXmlGc(record));
		xml.setValue(value);
		return xml;
	}
	
	public static XMLGregorianCalendar toXmlGc(Date d)
    {
	    try
	    {
			Instant yourInstant = d.toInstant();
			ZoneId zone = ZoneId.of("America/Asuncion");
			ZonedDateTime dateTime = yourInstant.atZone(zone);
		    GregorianCalendar c = GregorianCalendar.from(dateTime);
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			return date2;
			
		}
	    catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
}