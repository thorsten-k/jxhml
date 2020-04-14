
package de.kisner.jxhml.model.xml.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="device" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="rx" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="tx" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "rssi")
public class Rssi
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "device")
    protected String device;
    @XmlAttribute(name = "rx")
    protected Integer rx;
    @XmlAttribute(name = "tx")
    protected Integer tx;

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevice(String value) {
        this.device = value;
    }

    public boolean isSetDevice() {
        return (this.device!= null);
    }

    /**
     * Gets the value of the rx property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getRx() {
        return rx;
    }

    /**
     * Sets the value of the rx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRx(int value) {
        this.rx = value;
    }

    public boolean isSetRx() {
        return (this.rx!= null);
    }

    public void unsetRx() {
        this.rx = null;
    }

    /**
     * Gets the value of the tx property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getTx() {
        return tx;
    }

    /**
     * Sets the value of the tx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTx(int value) {
        this.tx = value;
    }

    public boolean isSetTx() {
        return (this.tx!= null);
    }

    public void unsetTx() {
        this.tx = null;
    }

}
