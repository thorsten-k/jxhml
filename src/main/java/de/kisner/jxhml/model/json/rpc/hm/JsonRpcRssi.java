package de.kisner.jxhml.model.json.rpc.hm;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="rssi")
public class JsonRpcRssi implements Serializable
{
	public static final long serialVersionUID=1;
	

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("partner")
	private List<JsonRpcRssiPartner> partner;
	public List<JsonRpcRssiPartner> getPartner() {return partner;}
	public void setPartner(List<JsonRpcRssiPartner> partner) {this.partner = partner;}
}