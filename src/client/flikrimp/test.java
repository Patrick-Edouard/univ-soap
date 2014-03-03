package client.flikrimp;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.aetrion.flickr.Flickr;
import com.aetrion.flickr.FlickrException;
import com.aetrion.flickr.photos.Photo;
import com.aetrion.flickr.photos.PhotoList;

public class test {
	
	
	
	
	public static void main(String[] args) throws IOException, SAXException, FlickrException{
		
		String apiKey = "428182e8948db217b9721fa7308fad5a";
		Flickr f = new Flickr(apiKey);
		
		PhotoList list  = f.getTagsInterface().getClusterPhotos("Stonehendge", "");
		
		//System.out.println(list);
		
		
		System.out.println(list.size());
		
		int i = 0;
		for(Object o : list){
			if(o instanceof com.aetrion.flickr.photos.Photo){
				System.out.println("Nouvelle photo "+i);
				++i;
				
				Photo p = (Photo)o;
				
				
				System.out.println("Url de la photo : "+p.getUrl());
				
			}
			
			//System.out.println(o);
		}
	}
}
