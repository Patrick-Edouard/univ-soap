package server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import server.data.Voyage;


public class JDBCImplementation {
	
	static private JDBCImplementation instance;
	private String urlDB = "jdbc:postgresql://localhost/postgres";
	private String user = "postgres";
    private String password = "motdepasse";
    private Connection con = null;
    private ArrayList<Voyage> mesVoyages;
	
	private JDBCImplementation(){
		this.mesVoyages = new ArrayList<>();
		this.connectDB();
	}
	
	public ArrayList<Voyage> getVoyages(){
		return this.mesVoyages;
	}
	
	private void connectDB(){
		
        Statement st = null;
        ResultSet rs = null;

		try {
			
            this.con = DriverManager.getConnection(urlDB, user, password);
            st = this.con.createStatement();
            rs = st.executeQuery("SELECT * FROM public.\"Voyages\";");
            
            while(rs.next()){
            	Voyage v = new Voyage(rs.getString("destinationPays"),
            			rs.getString("destinationVille"), 
            			rs.getString("description"), 
            			rs.getString("prix"), 
            			rs.getString("regime"));
            	mesVoyages.add(v);
            }
            

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JDBCImplementation.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(JDBCImplementation.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
	}
	
	public static JDBCImplementation getInstance(){
		if(instance == null){
			instance = new JDBCImplementation();
		}
		return instance;
	}
	
	public static void main(String[] args){
		JDBCImplementation.getInstance();
	}
}
