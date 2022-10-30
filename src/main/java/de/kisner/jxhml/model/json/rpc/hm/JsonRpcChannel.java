package de.kisner.jxhml.model.json.rpc.hm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="channel")
public class JsonRpcChannel implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("id")
	private String id;
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	@JsonProperty("deviceId")
	private String deviceId;
	public String getDeviceId() {return deviceId;}
	public void setDeviceId(String deviceId) {this.deviceId = deviceId;}

	@JsonProperty("index")
	private Integer index;
	public Integer getIndex() {return index;}
	public void setIndex(Integer index) {this.index = index;}
	
	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("address")
	private String address;
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	@JsonProperty("mode")
	private String mode;
	public String getMode() {return mode;}
	public void setMode(String mode) {this.mode = mode;}
	
	@JsonProperty("category")
	private String category;
	public String getCategory() {return category;}
	public void setCategory(String category) {this.category = category;}
	
	@JsonProperty("partnerId")
	private String partnerId;
	public String getPartnerId() {return partnerId;}
	public void setPartnerId(String partnerId) {this.partnerId = partnerId;}
}