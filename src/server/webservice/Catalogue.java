package server.webservice;

import java.util.ArrayList;

import javax.jws.WebService;

import server.dao.VoyageFactory;
import server.data.Voyage;

@WebService(targetNamespace = "http://webservice.server/", portName = "CataloguePort", serviceName = "CatalogueService")
public class Catalogue {
	private ArrayList<Voyage> lesVoyages;
	
	public Catalogue(){
		this.lesVoyages = VoyageFactory.getVoyage();
	}
	
	public ArrayList<Voyage> getVoyages(){
		return this.lesVoyages;
	}
}
