package client.flikrimp;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import javax.imageio.ImageIO;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

public class FlickrPhotosFactory {
	
	public static Element open(InputStream in){
		SAXBuilder sxb = new SAXBuilder();
		Element root = null;
		try {
			root = sxb.build(in).getRootElement();
		} catch (JDOMException e) {
			System.err.println("Erreur de parser");
		} catch (IOException e) {
			System.err.println("Erreur de fichier");
			e.printStackTrace();
		}
		return root;
	}
	
	public static String myRequeteCountry(String country){
		return					
				"<s:Envelope\n" +
				"xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\"\n" +
				"xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\"\n" +
				"xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\"\n" +
				">\n" +
					"<s:Body>\n" +
						"<x:FlickrRequest xmlns:x=\"urn:flickr\">\n" +
							"<method>flickr.photos.search</method>\n" +
							"<tags>"+country+"</tags>\n" +
							"<api_key>428182e8948db217b9721fa7308fad5a</api_key>\n" +
						"</x:FlickrRequest>\n" +
					"</s:Body>\n" +
				"</s:Envelope>";
	}
	
	/**
	 * Fonction appelée pour obtenir l'url d'une photo, à implémenter avec l'api soap de Flickr
	 * @param tag concernant la photo que l'on souaiterait obtenir
	 * @return Un lien vers une photo
	 */
	private static String getURLFor(String tag){
		String urlPic = "";
		try{
		String requete = myRequeteCountry(tag);
		URL uRL = new URL("http://api.flickr.com/services/soap/");
		URLConnection conn = uRL.openConnection();
		conn.setRequestProperty("SOAPAction", "soapAction");
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(requete);
        wr.flush();
        
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        Element root = open(conn.getInputStream());
        
        Element fresponse = null;
        for(Object o : root.getChildren()){
        	Element e = (Element)o;
        	for(Object o2 : e.getChildren()){
        		System.out.println(o2);
        		fresponse =(Element) o2;
        	}
        }
        
        InputSource is = new InputSource(new StringReader(fresponse.getContent(0).getValue()));
        SAXBuilder sxb = new SAXBuilder();
        
        Element reponse = sxb.build(is).getRootElement();
        
        Random r = new Random();
        int random = r.nextInt(reponse.getChildren("photo").size()-1);
        Element photoRand = (Element) reponse.getChildren("photo").get(random);
        urlPic = "http://farm"+photoRand.getAttribute("farm").getValue()+".staticflickr.com/"+photoRand.getAttribute("server").getValue()+"/"+photoRand.getAttribute("id").getValue()+"_"+photoRand.getAttribute("secret").getValue()+".jpg";
        
        wr.close();
        rd.close();
		}catch(JDOMException e){
			
		}catch(IOException e){
			
		}
		return urlPic;
	}
	
	public static BufferedImage getPhotoFor(String tag){
		String url = getURLFor(tag);
		return downloadImage(url);
	}
	
	public static BufferedImage downloadImage(String url){
		BufferedImage image = null;
		try{
			URL urlImage = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)urlImage.openConnection();
			InputStream inputStream = connection.getInputStream();
			image = ImageIO.read(inputStream);
		}catch(MalformedURLException e){
			
		}catch(IOException e){
			System.err.println("Lien de photo mort ou incompatible");
			try{
				image = ImageIO.read(new File("Image-not-foud.gif"));
			}catch(IOException e2){
				System.err.println("Image local par défaut non trouvée");
			}
		}
		if(image.getWidth()>500|| image.getHeight()>500){
			image = createResizedCopy(image, image.getWidth()/(image.getWidth()%500)*10, image.getHeight()/(image.getWidth()%500)*10, true);
		}
		return image;
	}
	
	/**
	 * Redimentionne la photo
	 * @param originalImage
	 * @param scaledWidth
	 * @param scaledHeight
	 * @param preserveAlpha
	 * @return
	 */
	private static BufferedImage createResizedCopy(Image originalImage, 
    		int scaledWidth, int scaledHeight, 
    		boolean preserveAlpha)
    {
    	System.out.println("resizing...");
    	int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    	BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
    	Graphics2D g = scaledBI.createGraphics();
    	if (preserveAlpha) {
    		g.setComposite(AlphaComposite.Src);
    	}
    	g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
    	g.dispose();
    	return scaledBI;
    }
}
