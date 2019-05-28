package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Segelmacher;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.TimeZone;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class SegelmacherTest {
	
	private Segelmacher segelmacher;
	private String name;
	private String zeitalter;
	private int muenzen;
	private int werkzeug;
	private int personen;
	private int diamanten;
	private int laenge;
	private int breite;
	private int bauzeit;
	private int wz_5_min;
	private int wz_15_min;
	private int wz_1_h;
	private int wz_4_h;
	private int wz_8_h;
	private int wz_1_t;
	private String name_prod_5_min;
	private String name_prod_15_min;
	private String name_prod_1_h;
	private String name_prod_4_h;
	private String name_prod_8_h;
	private String name_prod_1_t;
	private boolean strasse;
	private String gebaeude_art;
	
  
  @BeforeMethod
  public void beforeMethod() throws ParseException {
		Properties props = new Properties();
		String dsn = "ressource/main/xml/segelmacher1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für den Segelmacher wurde nicht gefunden!");
			e.printStackTrace();
		//Props-Format passt nicht
		} catch (InvalidPropertiesFormatException e) {
			System.err.println("Das Format passt nicht");
			e.printStackTrace();
		//Fehler beim öffen / lesen der XML-Datei
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Fehler beim öffen / lesen der XML-Datei");
			e.printStackTrace();
		}
		//Segelmacher init
		name = props.getProperty("Name");
		zeitalter = props.getProperty("Zeitalter");
		muenzen = new Integer(props.getProperty("Muenzen")).intValue();
		werkzeug = new Integer(props.getProperty("Werkzeug")).intValue();
		diamanten = new Integer(props.getProperty("Diamanten")).intValue();
		laenge = new Integer(props.getProperty("Laenge")).intValue();
		breite = new Integer(props.getProperty("Breite")).intValue();
		bauzeit = new Integer(props.getProperty("Bauzeit")).intValue();
		personen = new Integer(props.getProperty("Personen")).intValue();
		wz_5_min = new Integer(props.getProperty("5_min")).intValue();
		wz_15_min = new Integer(props.getProperty("15_min")).intValue();
		wz_1_h = new Integer(props.getProperty("1_h")).intValue();
		wz_4_h = new Integer(props.getProperty("4_h")).intValue();
		wz_8_h = new Integer(props.getProperty("8_h")).intValue();
		wz_1_t = new Integer(props.getProperty("1_t")).intValue();
		name_prod_5_min = props.getProperty("Name_5_min");
		name_prod_15_min = props.getProperty("Name_15_min");
		name_prod_1_h = props.getProperty("Name_1_h");
		name_prod_4_h = props.getProperty("Name_4_h");
		name_prod_8_h = props.getProperty("Name_8_h");
		name_prod_1_t = props.getProperty("Name_1_t");
		gebaeude_art = props.getProperty("Geb_Art");
		if (props.getProperty("Strasse").compareToIgnoreCase("true") == 0) {
			  strasse = true;

		  } else {
			  strasse = false;
		  }
		
		segelmacher = new Segelmacher(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_segelmacher_sein() {
	  Assert.assertEquals(segelmacher.getName(), name);
	  Assert.assertEquals(segelmacher.getName(), "Segelmacher");
  }
  
  @Test
  public void zeitalter_muss_kolonialzeit_sein() {
	  Assert.assertEquals(segelmacher.getZeitalter(), zeitalter);
	  Assert.assertEquals(segelmacher.getZeitalter(), "Kolonialzeit");
  }
  
  @Test
  public void segelmacher_kostet_59000_muenzen() {
	  Assert.assertEquals(segelmacher.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(segelmacher.getMuenzen().intValue(), 59000);
  }
  
  @Test
  public void segelmacher_kostest_7700_werkzeug() {
	  Assert.assertEquals(segelmacher.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(segelmacher.getWerkzeug().intValue(), 7700);
  }
  
  @Test
  public void segelmacher_kostet_keine_daimanten() {
	  Assert.assertEquals(segelmacher.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(segelmacher.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void segelmacher_benötigt_147_personen() {
	  Assert.assertEquals(segelmacher.getPersonen().intValue(), personen);
	  Assert.assertEquals(segelmacher.getPersonen().intValue(), 147);
  }
  
  @Test
  public void segelmacher_ist_3_lang() {
	  Assert.assertEquals(segelmacher.getLaenge().intValue(), laenge);
	  Assert.assertEquals(segelmacher.getLaenge().intValue(), 3);
  }
  
  @Test
  public void segelmacher_ist_3_breit() {
	  Assert.assertEquals(segelmacher.getBreite().intValue(), breite);
	  Assert.assertEquals(segelmacher.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_segelmacher_ist_12_stunden_40_minuten() {
	  Calendar cal =Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
	  cal.setTime(segelmacher.getpBauzeit());
	  Assert.assertEquals(cal.get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), 40);
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 12);
	  Assert.assertEquals(cal.get(Calendar.SECOND), 0);
  }
  
  @Test
  public void segelmacher_benoetigt_strasse() {
	  Assert.assertEquals(segelmacher.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(segelmacher.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void segelmacher_produziert_in_5_minuten_80_werkzeug() {
	  Assert.assertEquals(segelmacher.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(segelmacher.getIn_5_Minuten().intValue(), 80);
  }
  
  @Test
  public void segelmacher_produziert_in_15_minuten_190_werkzeug() {
	  Assert.assertEquals(segelmacher.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(segelmacher.getIn_15_Minuten().intValue(), 190);
  }
  
  @Test
  public void segelmacher_produziert_in_1_stunde_470_werkzeug() {
	  Assert.assertEquals(segelmacher.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(segelmacher.getIn_1_Stunde().intValue(), 470);
  }
  
  @Test
  public void segelmacher_produziert_in_4_stunden_780_werkzeug() {
	  Assert.assertEquals(segelmacher.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(segelmacher.getIn_4_Stunden().intValue(), 780);
  }
  
  @Test
  public void segelmacher_produziert_in_8_stunden_1160_werkzeug() {
	  Assert.assertEquals(segelmacher.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(segelmacher.getIn_8_Stunden().intValue(), 1160);
  }
  
  @Test
  public void segelmacher_produziert_in_1_tag_2330_werkzeug() {
	  Assert.assertEquals(segelmacher.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(segelmacher.getIn_1_Tag().intValue(), 2330);
  }
  
  @Test
  public void segelmacher_produziert_in_5_minuten_wimpel() {
	  Assert.assertEquals(segelmacher.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(segelmacher.getName_5_min(), "Wimpel");
  }
  
  @Test
  public void segelmacher_produziert_in_15_minuten_fahne() {
	  Assert.assertEquals(segelmacher.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(segelmacher.getName_15_min(), "Fahne");
  }
  
  @Test
  public void segelmacher_produziert_in_1_stunde_kleines_segel() {
	  Assert.assertEquals(segelmacher.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(segelmacher.getName_1_h(), "Kleines Segel");
  }
  
  @Test
  public void segelmacher_produziert_in_4_stunden_latainersegel() {
	  Assert.assertEquals(segelmacher.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(segelmacher.getName_4_h(), "Latainersegel");
  }
  
  @Test
  public void segelmacher_produziert_in_8_stunden_rahsegel() {
	  Assert.assertEquals(segelmacher.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(segelmacher.getName_8_h(), "Rahsegel");
  }
  
  @Test
  public void segelmacher_produziert_in_1_tag_vollzeug() {
	  Assert.assertEquals(segelmacher.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(segelmacher.getName_1_t(), "Vollzeug");
  }
  
  @Test
  public void segelmacher_ist_normales_gebaeude() {
	  Assert.assertEquals(segelmacher.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(segelmacher.getGebaeude_art(), "Normal");
  }

}
