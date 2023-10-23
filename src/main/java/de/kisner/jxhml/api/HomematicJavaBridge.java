package de.kisner.jxhml.api;

import de.kisner.jxhml.model.json.hm.JsonHmContainer;
import de.kisner.jxhml.model.xml.jxhml.Device;
import de.kisner.jxhml.model.xml.jxhml.Devices;

public interface HomematicJavaBridge
{
	Devices devicesId();
	Devices devicesDetail();

	Device deviceWithChannels(String code);
	
	/**
	* Returns for installed components the version number. 
	*
	* @return      A JSON Object with a list of Version
	* @see         Image
	*/
	JsonHmContainer versions();
	
	JsonHmContainer rooms();
	JsonHmContainer subsections();
	JsonHmContainer devices();
}