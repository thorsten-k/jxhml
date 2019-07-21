
package de.kisner.jxhml.model.xml.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence&gt;
 *         &lt;element ref="{}datapoint" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ise_id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datapoint"
})
@XmlRootElement(name = "channel")
public class Channel
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected List<Datapoint> datapoint;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "ise_id")
    protected String iseId;

    /**
     * Gets the value of the datapoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datapoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatapoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Datapoint }
     * 
     * 
     */
    public List<Datapoint> getDatapoint() {
        if (datapoint == null) {
            datapoint = new ArrayList<Datapoint>();
        }
        return this.datapoint;
    }

    public boolean isSetDatapoint() {
        return ((this.datapoint!= null)&&(!this.datapoint.isEmpty()));
    }

    public void unsetDatapoint() {
        this.datapoint = null;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the iseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIseId() {
        return iseId;
    }

    /**
     * Sets the value of the iseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIseId(String value) {
        this.iseId = value;
    }

    public boolean isSetIseId() {
        return (this.iseId!= null);
    }

}
