package de.kisner.jxhml.model.json.rpc.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import de.kisner.jxhml.model.json.rpc.hm.JsonRpcDevice;

@JsonRootName(value="response")
public class JsonRpcDeviceResponse implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("version")
	private String version;
	public String getVersion() {return version;}
	public void setVersion(String version) {this.version = version;}
	
	@JsonProperty("error")
	private JsonRpcError error;
	public JsonRpcError getError() {return error;}
	public void setError(JsonRpcError error) {this.error = error;}

	@JsonProperty("result")
	private JsonRpcDevice result;
	public JsonRpcDevice getResult() {return result;}
	public void setResult(JsonRpcDevice result) {this.result = result;}
}