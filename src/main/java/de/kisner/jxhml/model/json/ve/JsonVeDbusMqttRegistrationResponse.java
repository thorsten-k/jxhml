package de.kisner.jxhml.model.json.ve;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="VeMqttRegistrationResponse")
public class JsonVeDbusMqttRegistrationResponse implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("portalId")
	private String portalId;
	public String getPortalId() {return portalId;}
	public void setPortalId(String portalId) {this.portalId = portalId;}
	

	@Override public String toString()
	{
		StringBuffer sb = new StringBuffer();	
		return sb.toString();
	}
}