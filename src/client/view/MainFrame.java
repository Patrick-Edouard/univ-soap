package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.xml.namespace.QName;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import client.webservice.Catalogue;
import client.webservice.CatalogueService;
import client.webservice.Voyage;

public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static final QName SERVICE_NAME = new QName("http://webservice.server/", "CatalogueService");
	private URL wsdlURL = CatalogueService.WSDL_LOCATION;
	private ArrayList<Voyage> mesVoyages;
	private String OSMURL = "http://openstreetmap.org/api/0.6/map?bbox=5.863695,45.645636,5.875368,45.649597";
	private JPanel panVoyagesPropose;
	
	private JPanel panGauche;
	private JPanel panDroite;
	
	public MainFrame(){
		super("Agence de Voyage");
		this.mesVoyages = new ArrayList<>();
		this.getDatasFromSOAP();
		this.initFrame();
		this.initPanel();
		this.fillVoyagesView();
		this.fillSearchPan();
		//this.fillMap();
		this.revalidate();
		this.setVisible(true);
	}
	
	private void fillVoyagesView(){
		
		JScrollPane panelBody;
		this.panVoyagesPropose = new JPanel();
		this.panVoyagesPropose.setBounds(0, 0, 600, 600);
		this.panVoyagesPropose.setLayout(new GridLayout(this.mesVoyages.size(),1));
		
		for(Voyage v : this.mesVoyages){
			this.panVoyagesPropose.add(new PanelVoyage(v));
		}
		
		this.panVoyagesPropose.setSize(new Dimension(500,500));
		panelBody = new JScrollPane(this.panVoyagesPropose, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panelBody.setBounds(0, 0, 600, 600);
		panelBody.updateUI();
		this.panDroite.add(panelBody, BorderLayout.CENTER);
		
	}
	
	private void fillSearchPan(){
		this.panGauche.setLayout(new BorderLayout());
		this.panGauche.add(new JButton("Afficher les favoris"),BorderLayout.NORTH);
		this.panGauche.add(new JLabel("Recherche :"),BorderLayout.SOUTH);
	}
	
	private void initPanel(){
		this.panGauche = new JPanel();
		this.panGauche.setBorder(new LineBorder(Color.LIGHT_GRAY));
		this.panDroite = new JPanel();
		this.panDroite.setLayout(new BorderLayout());
		this.panDroite.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		this.setLayout(new GridLayout(1,2));
		
		this.add(this.panGauche);
		this.add(this.panDroite);
	}
	
	private void fillMap(){
		//OsmTileLoader otl = new OsmTileLoader()
		JMapViewer view = new JMapViewer();
		//TileLoader
		this.add(view);
		
	}
	
	private void initFrame(){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//tk.getScreenSize().getHeight();
		this.setSize((int)tk.getScreenSize().getWidth(), (int)tk.getScreenSize().getHeight()-50);
		this.setVisible(false);
	}
	
	private void getDatasFromSOAP(){
		
        CatalogueService ss = new CatalogueService(wsdlURL, SERVICE_NAME);
        Catalogue port = ss.getCataloguePort();  
        
        {
        System.out.println("Invoking getVoyages...");
        java.util.List<client.webservice.Voyage> _getVoyages__return = port.getVoyages();
        mesVoyages.addAll(_getVoyages__return);
        System.out.println("getVoyages.result=" + mesVoyages);
        }
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) throws java.lang.Exception {
        new MainFrame();
	}
}
