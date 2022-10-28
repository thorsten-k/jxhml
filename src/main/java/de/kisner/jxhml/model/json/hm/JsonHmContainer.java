package de.kisner.jxhml.model.json.hm;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="container")
public class JsonHmContainer implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("rooms")
	public List<JsonHmRoom> rooms;
	public List<JsonHmRoom> getRooms() {return rooms;}
	public void setRooms(List<JsonHmRoom> rooms) {this.rooms = rooms;}
}