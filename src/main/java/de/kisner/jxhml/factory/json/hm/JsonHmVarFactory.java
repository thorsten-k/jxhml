package de.kisner.jxhml.factory.json.hm;

import org.exlp.util.io.JsonUtil;
import org.jeesl.factory.json.system.status.JsonStatusFactory;
import org.jeesl.factory.json.system.status.JsonTypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.jxhml.model.json.hm.JsonHmVar;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcSystemVariable;

public class JsonHmVarFactory
{
	final static Logger logger = LoggerFactory.getLogger(JsonHmVarFactory.class);
	
	
	
	public static JsonHmVar build() {return new JsonHmVar();}
	
	public static JsonHmVar build(JsonRpcSystemVariable var)
	{
		JsonHmVar json = JsonHmVarFactory.build();
		json.setRefId(Long.valueOf(var.getId()));
		json.setName(var.getName());
		json.setType(JsonTypeFactory.build(var.getType()));
		
//		switch(Type.valueOf(var.getType()))
//		{
//			case LOGIC: json.setValueBoolean(Boolean.valueOf(var.getValue())); break;
//			case NUMBER: json.setValueNumber(Double.valueOf(var.getValue())); break;
//			case STRING: json.setValueString(var.getValue()); break;
//			case ALARM: logger.warn("NYI {}",var.getType()); break;
//			case LIST: json.setValueOption(JsonStatusFactory.build(var.getValue(), null)); ; break;
//			
//			
//			default: logger.warn("NYI {}",var.getType()); JsonUtil.info(var); break;
//		}
		
		return json;
	}
}