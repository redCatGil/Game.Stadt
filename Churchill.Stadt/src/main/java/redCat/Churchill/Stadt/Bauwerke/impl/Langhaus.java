package redCat.Churchill.Stadt.Bauwerke.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

public class Langhaus extends Wohngebaeude {
	
	private final String DSN = "langhaus1.xml";

	public Langhaus() {
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
		  cal.set(Calendar.YEAR,2017);
		  cal.set(Calendar.MONTH,Calendar.JANUARY);
		  cal.set(Calendar.DAY_OF_MONTH,1);
		  this.setBauzeit(cal);
		  
		  this.setBewohner(new Integer(props.getProperty("Bewohner")));
		  this.setMuenz_einnahmen(new Integer(props.getProperty("Einnahme")));
		  this.setEinnahme_dauer(new Integer(props.getProperty("Einnahmedauer")));
		
	}

	public Langhaus(String name, String zeitalter, int muenzen, int werkzeug, int diamanten, int laenge, int breite,
			int zeit, int bewohner, int einnahmen, int einnahme_dauer) {
		super(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite, zeit, bewohner, einnahmen, einnahme_dauer);
		// TODO Auto-generated constructor stub
	}
	
	

}
