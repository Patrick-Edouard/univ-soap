
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package client.webservice;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.7.8
 * 2014-02-11T09:24:27.291+01:00
 * Generated source version: 2.7.8
 * 
 */

@javax.jws.WebService(
                      serviceName = "CatalogueService",
                      portName = "CataloguePort",
                      targetNamespace = "http://webservice.server/",
                      wsdlLocation = "http://localhost:8080/AgenceDeVoyage/services/CataloguePort?wsdl",
                      endpointInterface = "client.webservice.Catalogue")
                      
public class CatalogueImpl implements Catalogue {

    private static final Logger LOG = Logger.getLogger(CatalogueImpl.class.getName());

    /* (non-Javadoc)
     * @see client.webservice.Catalogue#getVoyages(*
     */
    public java.util.List<client.webservice.Voyage> getVoyages() { 
        LOG.info("Executing operation getVoyages");
        try {
            java.util.List<client.webservice.Voyage> _return = new java.util.ArrayList<client.webservice.Voyage>();
            client.webservice.Voyage _returnVal1 = new client.webservice.Voyage();
            _returnVal1.setDescription("Description522235108");
            _returnVal1.setDestinationPays("DestinationPays-367851178");
            _returnVal1.setDestinationVille("DestinationVille-355610023");
            _returnVal1.setPhoto("Photo371107163");
            _returnVal1.setPrix("Prix-1002169113");
            _returnVal1.setRegime("Regime510551819");
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
