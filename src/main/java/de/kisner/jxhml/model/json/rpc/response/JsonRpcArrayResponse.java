package de.kisner.jxhml.model.json.rpc.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="response")
public class JsonRpcArrayResponse implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("version")
	private String version;
	public String getVersion() {return version;}
	public void setVersion(String version) {this.version = version;}

	@JsonProperty("result")
	private String[] result;
	public String[] getResult() {return result;}
	public void setResult(String[] result) {this.result = result;}

	@JsonProperty("error")
	private String error;
	public String getError() {return error;}
	public void setError(String error) {this.error = error;}
}