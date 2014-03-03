
package client.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for voyage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="voyage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinationPays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinationVille" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voyage", propOrder = {
    "description",
    "destinationPays",
    "destinationVille",
    "photo",
    "prix",
    "regime"
})
public class Voyage {

    protected String description;
    protected String destinationPays;
    protected String destinationVille;
    protected String photo;
    protected String prix;
    protected String regime;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the destinationPays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationPays() {
        return destinationPays;
    }

    /**
     * Sets the value of the destinationPays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationPays(String value) {
        this.destinationPays = value;
    }

    /**
     * Gets the value of the destinationVille property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationVille() {
        return destinationVille;
    }

    /**
     * Sets the value of the destinationVille property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationVille(String value) {
        this.destinationVille = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
    }

    /**
     * Gets the value of the prix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrix() {
        return prix;
    }

    /**
     * Sets the value of the prix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrix(String value) {
        this.prix = value;
    }

    /**
     * Gets the value of the regime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegime() {
        return regime;
    }

    /**
     * Sets the value of the regime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegime(String value) {
        this.regime = value;
    }

	@Override
	public String toString() {
		return "Voyage [description=" + description + ", destinationPays="
				+ destinationPays + ", destinationVille=" + destinationVille
				+ ", photo=" + photo + ", prix=" + prix + ", regime=" + regime
				+ "]";
	}

}
