
package de.kisner.jxhml.model.xml.jxhml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.kisner.jxhml.model.xml.jxhml package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.kisner.jxhml.model.xml.jxhml
     * 
     */
    public ObjectFactory() {
    }

   

    /**
     * Create an instance of {@link Devices }
     * 
     */
    public Devices createDevices() {
        return new Devices();
    }

    /**
     * Create an instance of {@link Device }
     * 
     */
    public Device createDevice() {
        return new Device();
    }

    /**
     * Create an instance of {@link Type }
     * 
     */
    public Type createType() {
        return new Type();
    }

    /**
     * Create an instance of {@link Radio }
     * 
     */
    public Radio createRadio() {
        return new Radio();
    }

    /**
     * Create an instance of {@link Channels }
     * 
     */
    public Channels createChannels() {
        return new Channels();
    }

    /**
     * Create an instance of {@link Channel }
     * 
     */
    public Channel createChannel() {
        return new Channel();
    }

    /**
     * Create an instance of {@link Datas }
     * 
     */
    public Datas createDatas() {
        return new Datas();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

}
