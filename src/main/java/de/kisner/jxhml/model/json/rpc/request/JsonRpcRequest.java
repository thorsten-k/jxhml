package de.kisner.jxhml.model.json.rpc.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="request")
public class JsonRpcRequest implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("method")
	private String method;
	public String getMethod() {return method;}
	public void setMethod(String method) {this.method = method;}

	@JsonProperty("params")
	private JsonRpcRequestParams params;
	public JsonRpcRequestParams getParams() {return params;}
	public void setParams(JsonRpcRequestParams params) {this.params = params;}
	
	public class JsonRpcRequestParams implements Serializable
	{
		public static final long serialVersionUID=1;
		
		@JsonProperty("_session_id_")
		private String session;
		public String getSession() {return session;}
		public void setSession(String session) {this.session = session;}
	}
}