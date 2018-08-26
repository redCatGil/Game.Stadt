package redCat.Churchill.Stadt.Bauwerke.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

public class Nutztiergehege extends Produktionsgebaeude {
	
	private final String DSN = "ressource/main/xml/nutztiergehege1.xml";

	public Nutztiergehege() {
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
		
		this.setIn_5_Minuten(new Integer(props.getProperty("5_min")));
		this.setIn_15_Minuten(new Integer(props.getProperty("15_min")));
		this.setIn_1_Stunde(new Integer(props.getProperty("1_h")));
		this.setIn_4_Stunden(new Integer(props.getProperty("4_h")));
		this.setIn_8_Stunden(new Integer(props.getProperty("8_h")));
		this.setIn_1_Tag(new Integer(props.getProperty("1_t")));
		this.setName_5_min(props.getProperty("Name_5_min"));
		this.setName_15_min(props.getProperty("Name_15_min"));
		this.setName_1_h(props.getProperty("Name_1_h"));
		this.setName_4_h(props.getProperty("Name_4_h"));
		this.setName_8_h(props.getProperty("Name_8_h"));
		this.setName_1_t(props.getProperty("Name_1_t"));
		this.setGebaeude_art(props.getProperty("Geb_Art"));
		
	}

	public Nutztiergehege(String name, String zeitalter, int muenzen, int werkzeug,
			int personen, int diamanten, int laenge, int breite, int zeit,
			boolean strasse, int in_5_min, int in_15_min, int in_1_h,
			int in_4_h, int in_8_h, int in_1_tag, String name_5_min,
			String name_15_min, String name_1_h, String name_4_h,
			String name_8_h, String name_1_t, String gebaeude_art) {
		super(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge,
				breite, zeit, strasse, in_5_min, in_15_min, in_1_h, in_4_h,
				in_8_h, in_1_tag, name_5_min, name_15_min, name_1_h, name_4_h,
				name_8_h, name_1_t, gebaeude_art);
		// TODO Auto-generated constructor stub
	}

}
