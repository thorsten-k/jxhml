package de.kisner.jxhml.model.json.hm;

import java.io.Serializable;

import org.jeesl.model.json.system.status.JsonCategory;
import org.jeesl.model.json.system.status.JsonMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="channel")
public class JsonHmChannel implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("code")
	private String code;
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	@JsonProperty("position")
	private Integer position;
	public Integer getPosition() {return position;}
	public void setPosition(Integer position) {this.position = position;}

	@JsonProperty("address")
	private String address;
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("category")
	private JsonCategory category;
	public JsonCategory getCategory() {return category;}
	public void setCategory(JsonCategory category) {this.category = category;}

	@JsonProperty("mode")
	private JsonMode mode;
	public JsonMode getMode() {return mode;}
	public void setMode(JsonMode mode) {this.mode = mode;}
	
}