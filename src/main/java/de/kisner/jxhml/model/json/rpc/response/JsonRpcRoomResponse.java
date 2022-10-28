package de.kisner.jxhml.model.json.rpc.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import de.kisner.jxhml.model.json.rpc.hm.JsonRpcRoom;

@JsonRootName(value="response")
public class JsonRpcRoomResponse implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("version")
	private String version;
	public String getVersion() {return version;}
	public void setVersion(String version) {this.version = version;}
	
	@JsonProperty("error")
	private String error;
	public String getError() {return error;}
	public void setError(String error) {this.error = error;}

	@JsonProperty("result")
	private List<JsonRpcRoom> result;
	public List<JsonRpcRoom> getResult() {return result;}
	public void setResult(List<JsonRpcRoom> result) {this.result = result;}
}