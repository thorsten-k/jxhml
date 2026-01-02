package de.kisner.jxhml.model.json.rpc.hm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="sysVar")
public class JsonRpcSystemVariable implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("id")
	private String id;
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("type")
	private String type;
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	@JsonProperty("unit")
	private String unit;
	public String getUnit() {return unit;}
	public void setUnit(String unit) {this.unit = unit;}
	
	@JsonProperty("value")
	private String value;
	public String getValue() {return value;}
	public void setValue(String value) {this.value = value;}
	
	@JsonProperty("channelId")
	private Integer channelId;
	public Integer getChannelId() {return channelId;}
	public void setChannelId(Integer channelId) {this.channelId = channelId;}
	
	
	@JsonProperty("isVisible")
	private Boolean isVisible;
	public Boolean getIsVisible() {return isVisible;}
	public void setIsVisible(Boolean isVisible) {this.isVisible = isVisible;}

	@JsonProperty("isInternal")
	private Boolean isInternal;
	public Boolean getIsInternal() {return isInternal;}
	public void setIsInternal(Boolean isInternal) {this.isInternal = isInternal;}
	
	
	@JsonProperty("valueName0")
	private String valueName0;
	public String getValueName0() {return valueName0;}
	public void setValueName0(String valueName0) {this.valueName0 = valueName0;}
	
	@JsonProperty("valueName1")
	private String valueName1;
	public String getValueName1() {return valueName1;}
	public void setValueName1(String valueName1) {this.valueName1 = valueName1;}
	
	@JsonProperty("valueName2")
	private String valueName2;
	public String getValueName2() {return valueName2;}
	public void setValueName2(String valueName2) {this.valueName2 = valueName2;}
	
	@JsonProperty("valueName3")
	private String valueName3;
	public String getValueName3() {return valueName3;}
	public void setValueName3(String valueName3) {this.valueName3 = valueName3;}
	
	@JsonProperty("valueName4")
	private String valueName4;
	public String getValueName4() {return valueName4;}
	public void setValueName4(String valueName4) {this.valueName4 = valueName4;}
}