package de.kisner.jxhml.model.json.rpc.hm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="partner")
public class JsonRpcRssiPartner implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("rssiData")
	private int[] rssiData;
	public int[] getRssiData() {return rssiData;}
	public void setRssiData(int[] rssiData) {this.rssiData = rssiData;}
}