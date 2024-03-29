
package de.kisner.jxhml.model.xml.api;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.kisner.jxhml.model.xml.api package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.kisner.jxhml.model.xml.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeviceList }
     * 
     */
    public DeviceList createDeviceList() {
        return new DeviceList();
    }

    /**
     * Create an instance of {@link Device }
     * 
     */
    public Device createDevice() {
        return new Device();
    }

    /**
     * Create an instance of {@link Channel }
     * 
     */
    public Channel createChannel() {
        return new Channel();
    }

    /**
     * Create an instance of {@link Datapoint }
     * 
     */
    public Datapoint createDatapoint() {
        return new Datapoint();
    }

    /**
     * Create an instance of {@link State }
     * 
     */
    public State createState() {
        return new State();
    }

    /**
     * Create an instance of {@link RssiList }
     * 
     */
    public RssiList createRssiList() {
        return new RssiList();
    }

    /**
     * Create an instance of {@link Rssi }
     * 
     */
    public Rssi createRssi() {
        return new Rssi();
    }

}
