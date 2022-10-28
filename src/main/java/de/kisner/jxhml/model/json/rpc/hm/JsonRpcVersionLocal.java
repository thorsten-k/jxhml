package de.kisner.jxhml.model.json.rpc.hm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="room")
public class JsonRpcVersionLocal implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("localversion")
	private String localversion;
	public String getLocalversion() {return localversion;}
	public void setLocalversion(String localversion) {this.localversion = localversion;}
}