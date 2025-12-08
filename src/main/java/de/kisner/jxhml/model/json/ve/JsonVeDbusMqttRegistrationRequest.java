package de.kisner.jxhml.model.json.ve;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="VeMqttRegistrationRequest")
public class JsonVeDbusMqttRegistrationRequest implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("clientId")
	private String clientId;
	public String getClientId() {return clientId;}
	public void setClientId(String clientId) {this.clientId = clientId;}

	@JsonProperty("connected")
	private Integer connected;
	public Integer getConnected() {return connected;}
	public void setConnected(Integer connected) {this.connected = connected;}
	
	@JsonProperty("version")
	private String version;
	public String getVersion() {return version;}
	public void setVersion(String version) {this.version = version;}
	
	@JsonProperty("services")
    private Map<String,String> services;
    public Map<String,String> getServices() { return services; }
    public void setServices(Map<String,String> services) { this.services = services; }
    
	@Override public String toString()
	{
		StringBuffer sb = new StringBuffer();	
		return sb.toString();
	}
}