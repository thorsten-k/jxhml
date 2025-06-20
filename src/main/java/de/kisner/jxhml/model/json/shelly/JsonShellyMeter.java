package de.kisner.jxhml.model.json.shelly;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="meter")
public class JsonShellyMeter implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("localDateTime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime localDateTime;
	public LocalDateTime getLocalDateTime() {return localDateTime;}
	public void setLocalDateTime(LocalDateTime localDateTime) {this.localDateTime = localDateTime;}
	
	@JsonProperty("total_act")
	private Double totalFromGrid;
	public Double getTotalFromGrid() {return totalFromGrid;}
	public void setTotalFromGrid(Double totalFromGrid) {this.totalFromGrid = totalFromGrid;}

	@JsonProperty("total_act_ret")
	private Double totalToGrid;
	public Double getTotalToGrid() {return totalToGrid;}
	public void setTotalToGrid(Double totalToGrid) {this.totalToGrid = totalToGrid;}

	@Override public String toString()
	{
		StringBuffer sb = new StringBuffer();	
		return sb.toString();
	}
}