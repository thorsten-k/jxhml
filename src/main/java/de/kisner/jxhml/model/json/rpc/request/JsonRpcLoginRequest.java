package de.kisner.jxhml.model.json.rpc.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="request")
public class JsonRpcLoginRequest implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("method")
	private String method;
	public String getMethod() {return method;}
	public void setMethod(String method) {this.method = method;}

	@JsonProperty("params")
	private JsonRpcRequestLoginParams params;
	public JsonRpcRequestLoginParams getParams() {return params;}
	public void setParams(JsonRpcRequestLoginParams params) {this.params = params;}
	
	public class JsonRpcRequestLoginParams implements Serializable
	{
		public static final long serialVersionUID=1;
		
		@JsonProperty("username")
		private String username;
		public String getUsername() {return username;}
		public void setUsername(String username) {this.username = username;}

		@JsonProperty("password")
		private String password;
		public String getPassword() {return password;}
		public void setPassword(String password) {this.password = password;}
	}
}