
package client.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.webservice package. 
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

    private final static QName _GetVoyagesResponse_QNAME = new QName("http://webservice.server/", "getVoyagesResponse");
    private final static QName _GetVoyages_QNAME = new QName("http://webservice.server/", "getVoyages");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetVoyages }
     * 
     */
    public GetVoyages createGetVoyages() {
        return new GetVoyages();
    }

    /**
     * Create an instance of {@link GetVoyagesResponse }
     * 
     */
    public GetVoyagesResponse createGetVoyagesResponse() {
        return new GetVoyagesResponse();
    }

    /**
     * Create an instance of {@link Voyage }
     * 
     */
    public Voyage createVoyage() {
        return new Voyage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoyagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server/", name = "getVoyagesResponse")
    public JAXBElement<GetVoyagesResponse> createGetVoyagesResponse(GetVoyagesResponse value) {
        return new JAXBElement<GetVoyagesResponse>(_GetVoyagesResponse_QNAME, GetVoyagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoyages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server/", name = "getVoyages")
    public JAXBElement<GetVoyages> createGetVoyages(GetVoyages value) {
        return new JAXBElement<GetVoyages>(_GetVoyages_QNAME, GetVoyages.class, null, value);
    }

}
