package redCat.Churchill.Stadt.Bauwerke.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

public class Saegemuehle extends Guetergebaeude {
	
	private final String DSN = "ressource/main/xml/saegemuehle1.xml";

	public Saegemuehle() {
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
		this.setIn4StundenName(props.getProperty("4hName"));
		this.setIn4StundenMenge(new Integer(props.getProperty("4hMenge")));
		this.setIn4StundenMuenzen(new Integer(props.getProperty("4hMuenzen")));
		this.setIn4StundenWZ(new Integer(props.getProperty("4hWz")));
		this.setIn8StundenName(props.getProperty("8hName"));
		this.setIn8StundenMenge(new Integer(props.getProperty("8hMenge")));
		this.setIn8StundenMuenzen(new Integer(props.getProperty("8hMuenzen")));
		this.setIn8StundenWZ(new Integer(props.getProperty("8hWz")));
		this.setIn1TagName(props.getProperty("1tName"));
		this.setIn1TagMenge(new Integer(props.getProperty("1tMenge")));
		this.setIn1TagMuenzen(new Integer(props.getProperty("1tMuenzen")));
		this.setIn1TagWZ(new Integer(props.getProperty("1tWz")));
		this.setIn2TagenName(props.getProperty("2tName"));
		this.setIn2TagenMenge(new Integer(props.getProperty("2tMenge")));
		this.setIn2TagenMuenzen(new Integer(props.getProperty("2tMuenzen")));
		this.setIn2TagenWZ(new Integer(props.getProperty("2tWz")));
		this.setGebaeude_art(props.getProperty("Geb_Art"));
		
	}

	/**
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
	public Saegemuehle(GregorianCalendar bauzeit, Integer breite, Integer diamanten, Integer laenge, Integer muenzen,
			String name, Integer personen, boolean strasse_benoetigt, Integer werkzeug, String zeitalter,
			String produkt, String material, GueterProd in4Stunden, GueterProd in8Stunden, GueterProd in1Tag,
			GueterProd in2Tagen, String gebaeude_art) {
		super(bauzeit, breite, diamanten, laenge, muenzen, name, personen, strasse_benoetigt, werkzeug, zeitalter, produkt,
				material, in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);
		// TODO Auto-generated constructor stub
	}

	/**
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
	public Saegemuehle(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten,
			int laenge, int breite, int zeit, boolean strasse, String produkt, String material, GueterProd in4Stunden,
			GueterProd in8Stunden, GueterProd in1Tag, GueterProd in2Tagen, String gebaeude_art) {
		super(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, zeit, strasse, produkt, material,
				in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
