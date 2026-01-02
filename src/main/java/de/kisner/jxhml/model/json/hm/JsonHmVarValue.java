package de.kisner.jxhml.model.json.hm;

import java.io.Serializable;

import org.jeesl.model.json.system.status.JsonStatus;
import org.jeesl.model.json.system.status.JsonType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="var")
public class JsonHmVarValue implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("refId")
	private Long refId;
	public Long getRefId() {return refId;}
	public void setRefId(Long refId) {this.refId = refId;}

	@JsonProperty("code")
	private String code;
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("type")
	private JsonType type;
	public JsonType getType() {return type;}
	public void setType(JsonType type) {this.type = type;}

	
	@JsonProperty("valueBoolean")
	private Boolean valueBoolean;
	public Boolean getValueBoolean() {return valueBoolean;}
	public void setValueBoolean(Boolean valueBoolean) {this.valueBoolean = valueBoolean;}
	
	@JsonProperty("valueNumber")
	private Double valueNumber;
	public Double getValueNumber() {return valueNumber;}
	public void setValueNumber(Double valueNumber) {this.valueNumber = valueNumber;}
	
	@JsonProperty("valueString")
	private String valueString;
	public String getValueString() {return valueString;}
	public void setValueString(String valueString) {this.valueString = valueString;}

	@JsonProperty("valueOption")
	private JsonStatus option;
	public JsonStatus getValueOption() {return option;}
	public void setValueOption(JsonStatus option) {this.option = option;}
}