package de.kisner.jxhml.model.json.hm;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="room")
public class JsonHmRoom implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("id")
	private Long id;
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	@JsonProperty("code")
	private String code;
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("channels")
	private List<JsonHmChannel> channels;
	public List<JsonHmChannel> getChannels() {return channels;}
	public void setChannels(List<JsonHmChannel> channels) {this.channels = channels;}
	
	@JsonProperty("devices")
	private List<JsonHmDevice> devices;
	public List<JsonHmDevice> getDevices() {return devices;}
	public void setDevices(List<JsonHmDevice> devices) {this.devices = devices;}
}