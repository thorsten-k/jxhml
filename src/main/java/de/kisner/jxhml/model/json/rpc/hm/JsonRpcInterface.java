package de.kisner.jxhml.model.json.rpc.hm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="interface")
public class JsonRpcInterface implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("port")
	private String port;
	public String getPort() {return port;}
	public void setPort(String port) {this.port = port;}

	@JsonProperty("info")
	private String info;
	public String getInfo() {return info;}
	public void setInfo(String info) {this.info = info;}
}