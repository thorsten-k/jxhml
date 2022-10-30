package de.kisner.jxhml.model.json.rpc.hm;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value="device")
public class JsonRpcDevice implements Serializable
{
	public static final long serialVersionUID=1;
	
	@JsonProperty("id")
	private String id;
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("address")
	private String address;
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	@JsonProperty("interface")
	private String iface;
	public String getIface() {return iface;}
	public void setIface(String iface) {this.iface = iface;}
	
	@JsonProperty("type")
	private String type;
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	@JsonProperty("operateGroupOnly")
	private Boolean operateGroupOnly;
	public Boolean getOperateGroupOnly() {return operateGroupOnly;}
	public void setOperateGroupOnly(Boolean operateGroupOnly) {this.operateGroupOnly = operateGroupOnly;}
	
	@JsonProperty("enabledServiceMsg")
	private Boolean enabledServiceMsg;
	public Boolean getEnabledServiceMsg() {return enabledServiceMsg;}
	public void setEnabledServiceMsg(Boolean enabledServiceMsg) {this.enabledServiceMsg = enabledServiceMsg;}
	
	@JsonProperty("channels")
	private List<JsonRpcChannel> channels;
	public List<JsonRpcChannel> getChannels() {return channels;}
	public void setChannels(List<JsonRpcChannel> channels) {this.channels = channels;}
}