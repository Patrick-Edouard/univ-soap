package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import client.flikrimp.FlickrPhotosFactory;
import client.webservice.Voyage;

public class PanelVoyage extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public PanelVoyage(Voyage voyage){
		this.setMinimumSize(new Dimension(400,400));
        this.setBorder(new LineBorder(Color.DARK_GRAY));
        //this.setLayout(null);
        this.setLayout(new BorderLayout());
        JLabel labNom = new JLabel("Voyage : "+voyage.getDestinationPays()+" "+voyage.getDestinationVille());
        labNom.setSize(150,20);
        this.add(labNom,BorderLayout.NORTH);
        JTextArea description = new JTextArea("- Description : "+voyage.getDescription()+"\n- Regime : "+voyage.getRegime()+"\n- Prix : "+voyage.getPrix());
        description.setBackground(null);
        description.setEditable(false);
        description.setBorder(null);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setFocusable(false);
        JScrollPane yolo = new JScrollPane(description);
        yolo.setBounds(5,20,300,300);
        this.add(yolo,BorderLayout.CENTER);
        JLabel img = new JLabel();
        img.setIcon(new ImageIcon(FlickrPhotosFactory.getPhotoFor(voyage.getDestinationVille())));
        img.setBounds(275,0,400,300);
        img.setHorizontalTextPosition(JLabel.LEFT);
        JPanel panDroit = new JPanel();
        panDroit.setLayout(new GridLayout(2, 1));
        panDroit.add(img);
        
        JLabel map = new JLabel();
        map.setIcon(new ImageIcon(FlickrPhotosFactory.downloadImage("http://maps.googleapis.com/maps/api/staticmap?center="+voyage.getDestinationVille()+"&size=499x300&maptype=roadmap&sensor=false")));
        
        panDroit.add(map);
        this.add(panDroit,BorderLayout.EAST);
	}
}
