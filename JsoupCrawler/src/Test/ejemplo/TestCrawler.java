package Test.ejemplo;

import java.io.IOException;
import java.util.Hashtable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			doc = Jsoup.connect("https://play.google.com/store/apps/details?id=com.davivienda.daviplataapp").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Hashtable<String, String> valores = new Hashtable<String, String>();
		
		valores.put("nombre", doc.getElementsByClass("id-app-title").text());
		valores.put("Número de ratings", doc.getElementsByClass("rating-count").text());
		valores.put("Rating promedio", doc.getElementsByClass("score").text());
		valores.put("Descripcion", doc.getElementsByClass("description").text());
		valores.put("Cambios recientes", doc.getElementsByClass("recent-change").text());
		valores.put("Ratings con 5 estrellas", doc.getElementsByAttributeValue("itemprop", "description").text());//.select("[itemprop='description']").toString());
		valores.put("Ratings con 4 estrellas", doc.getElementsByClass("rating-bar-container four").text());
			
		System.out.println(valores.toString());
		
		
		//Scraping daviplata appstore
		try {
            doc = Jsoup.connect("https://itunes.apple.com/co/app/daviplata/id1100731780?mt=8").get();
	     } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	     }
	     Hashtable<String, String> datosApp = new Hashtable<String, String>();
	    
	     datosApp.put("Nombre", doc.select("[itemprop='name']").text());
	     datosApp.put("Número de ratings", doc.getElementsByClass("rating-count").text());
	     datosApp.put("Rating promedio", doc.getElementsByClass("score").text());
	     datosApp.put("Descripción", doc.getElementsByClass("truncate").text());
	     datosApp.put("Cambios recientes", doc.getElementsByClass("product-review").text());
	     datosApp.put("Ratings con 5 estrellas", doc.getElementsByClass("rating-bar-container five").text());
	     datosApp.put("Ratings con 4 estrellas", doc.getElementsByClass("rating-bar-container four").text());
	
	
	     System.out.println(datosApp.toString());
	}

}
