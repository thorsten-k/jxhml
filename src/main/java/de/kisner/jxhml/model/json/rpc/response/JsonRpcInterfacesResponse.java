package de.kisner.jxhml.model.json.rpc.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import de.kisner.jxhml.model.json.rpc.hm.JsonRpcInterface;

@JsonRootName(value="response")
public class JsonRpcInterfacesResponse implements Serializable
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
	private List<JsonRpcInterface> result;
	public List<JsonRpcInterface> getResult() {return result;}
	public void setResult(List<JsonRpcInterface> result) {this.result = result;}
}