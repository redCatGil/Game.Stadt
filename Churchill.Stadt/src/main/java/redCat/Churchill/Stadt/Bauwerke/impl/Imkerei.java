package redCat.Churchill.Stadt.Bauwerke.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

public class Imkerei extends Guetergebaeude {
	
	private final String DSN = "ressource/main/xml/imkerei1.xml";

	/**
	 * Standardkonstruktor für die Imkerei
	 * Die Werte werden alle aus dem Standard-XML für die Imkerei übernommen
	 */
	public Imkerei() {
		// TODO Auto-generated constructor stub
		super();
		Properties props = new Properties();
		boolean strasse = true;
		
		try {
			  FileInputStream inFile = new FileInputStream(DSN);
			  props.loadFromXML(inFile);

		  } catch (IOException e) {
			  System.err.println("Die Verarbeitung wurde abgebrochen, da ein IO-Fehler aufgetreten ist!!");
			  e.printStackTrace();
		  }
		
		if (props.getProperty("Strasse").compareToIgnoreCase("true") == 0) {
			  strasse = true;

		  } else {
			  strasse = false;
		  }

		
		this.setName(props.getProperty("Name"));
		this.setZeitalter(props.getProperty("Zeitalter"));
		this.setMuenzen(new Integer(props.getProperty("Muenzen")));
		this.setWerkzeug(new Integer(props.getProperty("Werkzeug")));
		this.setPersonen(new Integer(props.getProperty("Personen")));
		this.setDiamanten(new Integer(props.getProperty("Diamanten")));
		this.setLaenge(new Integer(props.getProperty("Laenge")));
		this.setBreite(new Integer(props.getProperty("Breite")));
		this.setStrasse_benoetigt(strasse);
		
		int zeit = new Integer(props.getProperty("Bauzeit")).intValue();
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY,Toolbox.ermittleStunden(zeit));
		cal.set(Calendar.HOUR,Toolbox.ermittleStunden(zeit));
		cal.set(Calendar.MINUTE,Toolbox.ermittleMinuten(zeit));
		cal.set(Calendar.SECOND,Toolbox.ermittleSekunden(zeit));
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.YEAR,2018);
		cal.set(Calendar.MONTH,Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH,1);
		this.setBauzeit(cal);
		
		this.setProdukt(props.getProperty("Produkt"));
		this.setMaterial(props.getProperty("Material"));
		GueterProd gut;
		System.out.println("Name 4h: "+ props.getProperty("4hName"));
//		4 Stunden
		gut = new GueterProd();
		gut.setProdName(props.getProperty("4hName"));
		gut.setProdMenge(new Integer(props.getProperty("4hMenge")));
		gut.setProdMuenzen(new Integer(props.getProperty("4hMuenzen")));
		gut.setProdWZ(new Integer(props.getProperty("4hWZ")));
		this.setIn4Stunden(gut);
//		8 Stunden
		gut = new GueterProd();
		gut.setProdName(props.getProperty("8hName"));
		gut.setProdMenge(new Integer(props.getProperty("8hMenge")));
		gut.setProdMuenzen(new Integer(props.getProperty("8hMuenzen")));
		gut.setProdWZ(new Integer(props.getProperty("8hWZ")));
		this.setIn8Stunden(gut);
//      1 Tag
		gut = new GueterProd();
		gut.setProdName(props.getProperty("1tName"));
		gut.setProdMenge(new Integer(props.getProperty("1tMenge")));
		gut.setProdMuenzen(new Integer(props.getProperty("1tMuenzen")));
		gut.setProdWZ(new Integer(props.getProperty("1tWZ")));
		this.setIn1Tag(gut);
//		2 Tage
		gut = new GueterProd();
		gut.setProdName(props.getProperty("2tName"));
		gut.setProdMenge(new Integer(props.getProperty("2tMenge")));
		gut.setProdMuenzen(new Integer(props.getProperty("2tMuenzen")));
		gut.setProdWZ(new Integer(props.getProperty("2tWZ")));
		this.setIn2Tagen(gut);

		this.setGebaeude_art(props.getProperty("Geb_Art"));
		
	}

	/**
	 * Konstruktor bei dem die Imkerei mit den übergebenen Werten aufgebaut wird.
	 * Die Bauzeit wird als GregorianCalender übergeben.
	 * 
	 * @param bauzeit
	 * @param breite
	 * @param diamanten
	 * @param laenge
	 * @param muenzen
	 * @param name
	 * @param personen
	 * @param strasse_benoetigt
	 * @param werkzeug
	 * @param zeitalter
	 * @param produkt
	 * @param material
	 * @param in4Stunden
	 * @param in8Stunden
	 * @param in1Tag
	 * @param in2Tagen
	 * @param gebaeude_art
	 */
	public Imkerei(GregorianCalendar bauzeit, Integer breite, Integer diamanten, Integer laenge, Integer muenzen,
			String name, Integer personen, boolean strasse_benoetigt, Integer werkzeug, String zeitalter,
			String produkt, String material, GueterProd in4Stunden, GueterProd in8Stunden, GueterProd in1Tag,
			GueterProd in2Tagen, String gebaeude_art) {
		super(bauzeit, breite, diamanten, laenge, muenzen, name, personen, strasse_benoetigt, werkzeug, zeitalter, produkt,
				material, in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Konstruktor bei dem die Imkerei mit den übergebenen Werten aufgebaut wird.
	 * Die Bauzeit wird als int übergeben.
	 * 
	 * @param name
	 * @param zeitalter
	 * @param muenzen
	 * @param werkzeug
	 * @param personen
	 * @param diamanten
	 * @param laenge
	 * @param breite
	 * @param zeit
	 * @param strasse
	 * @param produkt
	 * @param material
	 * @param in4Stunden
	 * @param in8Stunden
	 * @param in1Tag
	 * @param in2Tagen
	 * @param gebaeude_art
	 */
	public Imkerei(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten,
			int laenge, int breite, int zeit, boolean strasse, String produkt, String material, GueterProd in4Stunden,
			GueterProd in8Stunden, GueterProd in1Tag, GueterProd in2Tagen, String gebaeude_art) {
		super(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, zeit, strasse, produkt, material,
				in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
