package de.kisner.jxhml.model.json.hm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="dataPoint")
//@JsonPropertyOrder({ "id", "label", "target", "source", "attributes" })
public class JsonHmPoint implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("id")
	private String id;
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	@JsonProperty("type")
	private String type;
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	@JsonProperty("code")
	private String code;
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	@JsonProperty("channel")
	private JsonHmChannel channel;
	public JsonHmChannel getChannel() {return channel;}
	public void setChannel(JsonHmChannel channel) {this.channel = channel;}
	
	@JsonProperty("raw")
	private String raw;
	public String getRaw() {return raw;}
	public void setRaw(String raw) {this.raw = raw;}
}