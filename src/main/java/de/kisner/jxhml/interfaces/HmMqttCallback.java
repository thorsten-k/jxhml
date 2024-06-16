package de.kisner.jxhml.interfaces;

import org.eclipse.paho.client.mqttv3.MqttCallback;

public interface HmMqttCallback extends MqttCallback
{
	public String getMqttTopic();
	public String getDescription();
}