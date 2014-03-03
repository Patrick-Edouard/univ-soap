package server.dao;

import java.util.ArrayList;

import server.data.Voyage;

public class VoyageFactory {

	public static ArrayList<Voyage> getVoyage(){
		JDBCImplementation db = JDBCImplementation.getInstance();
		return db.getVoyages();
	}
}
