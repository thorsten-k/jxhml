package de.kisner.jxhml.model.json.hm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="room")
public class JsonHmVersion implements Serializable
{
	public static final long serialVersionUID=1;
		
	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("local")
	private String local;
	public String getLocal() {return local;}
	public void setLocal(String local) {this.local = local;}
	
	@JsonProperty("web")
	private String web;
	public String getWeb() {return web;}
	public void setWeb(String web) {this.web = web;}
}