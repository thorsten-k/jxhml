package de.kisner.jxhml.model.json.hm;

import java.io.Serializable;
import java.util.List;

import org.jeesl.model.json.system.status.JsonRadio;
import org.jeesl.model.json.system.status.JsonType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="device")
public class JsonHmDevice implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("code")
	private String code;
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	@JsonProperty("address")
	private String address;
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("type")
	private JsonType type;
	public JsonType getType() {return type;}
	public void setType(JsonType type) {this.type = type;}
	
	@JsonProperty("radio")
	private JsonRadio radio;
	public JsonRadio getRadio() {return radio;}
	public void setRadio(JsonRadio radio) {this.radio = radio;}
	
	@JsonProperty("room")
	private JsonHmRoom room;
	public JsonHmRoom getRoom() {return room;}
	public void setRoom(JsonHmRoom room) {this.room = room;}

	@JsonProperty("channels")
	private List<JsonHmChannel> channels;
	public List<JsonHmChannel> getChannels() {return channels;}
	public void setChannels(List<JsonHmChannel> channels) {this.channels = channels;}
}