package de.kisner.jxhml.model.json.rpc.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import de.kisner.jxhml.model.json.rpc.hm.JsonRpcVersionLocal;
import de.kisner.jxhml.model.json.rpc.hm.JsonRpcVersionOnline;

@JsonRootName(value="response")
public class JsonRpcAddonVersionResponse implements Serializable
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
	private JsonRpcVersionResult result;
	public JsonRpcVersionResult getResult() {return result;}
	public void setResult(JsonRpcVersionResult result) {this.result = result;}
	
	public class JsonRpcVersionResult implements Serializable
	{
		public static final long serialVersionUID=1;
		
		@JsonProperty("online")
		private List<JsonRpcVersionOnline> online;
		public List<JsonRpcVersionOnline> getOnline() {return online;}
		public void setOnline(List<JsonRpcVersionOnline> online) {this.online = online;}
		
		@JsonProperty("local")
		private List<JsonRpcVersionLocal> local;
		public List<JsonRpcVersionLocal> getLocal() {return local;}
		public void setLocal(List<JsonRpcVersionLocal> local) {this.local = local;}
	}
}