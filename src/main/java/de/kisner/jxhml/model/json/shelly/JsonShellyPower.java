package de.kisner.jxhml.model.json.shelly;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="em")
public class JsonShellyPower implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("total_act_power")
	private Double totalActualPower;
	public Double getTotalActualPower() {return totalActualPower;}
	public void setTotalActualPower(Double totalActualPower) {this.totalActualPower = totalActualPower;}
	
	@JsonProperty("total_aprt_power")
	private Double totalAparentPower;
	public Double getTotalAparentPower() {return totalAparentPower;}
	public void setTotalAparentPower(Double totalAparentPower) {this.totalAparentPower = totalAparentPower;}
	
	@Override public String toString()
	{
		StringBuffer sb = new StringBuffer();	
		return sb.toString();
	}
}