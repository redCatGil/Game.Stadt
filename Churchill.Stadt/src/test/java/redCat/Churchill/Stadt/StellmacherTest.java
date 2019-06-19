package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Stellmacher;
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


public class StellmacherTest {
	
	private Stellmacher stellmacher;
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
		String dsn = "ressource/main/xml/stellmacher1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für den Stellmacher wurde nicht gefunden!");
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
		//Stellmacher init
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
		
		stellmacher = new Stellmacher(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_stellmacher_sein() {
	  Assert.assertEquals(stellmacher.getName(), name);
	  Assert.assertEquals(stellmacher.getName(), "Stellmacher");
  }
  
  @Test
  public void zeitalter_muss_Industriezeitalter_sein() {
	  Assert.assertEquals(stellmacher.getZeitalter(), zeitalter);
	  Assert.assertEquals(stellmacher.getZeitalter(), "Industriezeitalter");
  }
  
  @Test
  public void stellmacher_kostet_keine_muenzen() {
	  Assert.assertEquals(stellmacher.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(stellmacher.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void stellmacher_kostest_kein_werkzeug() {
	  Assert.assertEquals(stellmacher.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(stellmacher.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void stellmacher_kostet_500_daimanten() {
	  Assert.assertEquals(stellmacher.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(stellmacher.getDiamanten().intValue(), 500);
  }
  
  @Test
  public void stellmacher_benötigt_180_personen() {
	  Assert.assertEquals(stellmacher.getPersonen().intValue(), personen);
	  Assert.assertEquals(stellmacher.getPersonen().intValue(), 180);
  }
  
  @Test
  public void stellmacher_ist_4_lang() {
	  Assert.assertEquals(stellmacher.getLaenge().intValue(), laenge);
	  Assert.assertEquals(stellmacher.getLaenge().intValue(), 4);
  }
  
  @Test
  public void stellmacher_ist_3_breit() {
	  Assert.assertEquals(stellmacher.getBreite().intValue(), breite);
	  Assert.assertEquals(stellmacher.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_stellmachere_ist_20_secunden() {
	  Calendar cal =Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
	  cal.setTime(stellmacher.getpBauzeit());
	  Assert.assertEquals(cal.get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), 0);
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 0);
	  Assert.assertEquals(cal.get(Calendar.SECOND), 20);
  }
  
  @Test
  public void stellmacher_benoetigt_strasse() {
	  Assert.assertEquals(stellmacher.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(stellmacher.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void stellmacher_produziert_in_5_minuten_250_werkzeug() {
	  Assert.assertEquals(stellmacher.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(stellmacher.getIn_5_Minuten().intValue(), 250);
  }
  
  @Test
  public void stellmacher_produziert_in_15_minuten_630_werkzeug() {
	  Assert.assertEquals(stellmacher.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(stellmacher.getIn_15_Minuten().intValue(), 630);
  }
  
  @Test
  public void stellmacher_produziert_in_1_stunde_1500_werkzeug() {
	  Assert.assertEquals(stellmacher.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(stellmacher.getIn_1_Stunde().intValue(), 1500);
  }
  
  @Test
  public void stellmacher_produziert_in_4_stunden_2510_werkzeug() {
	  Assert.assertEquals(stellmacher.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(stellmacher.getIn_4_Stunden().intValue(), 2510);
  }
  
  @Test
  public void stellmacher_produziert_in_8_stunden_3760_werkzeug() {
	  Assert.assertEquals(stellmacher.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(stellmacher.getIn_8_Stunden().intValue(), 3760);
  }
  
  @Test
  public void stellmacher_produziert_in_1_tag_7520_werkzeug() {
	  Assert.assertEquals(stellmacher.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(stellmacher.getIn_1_Tag().intValue(), 7520);
  }
  
  @Test
  public void stellmacher_produziert_in_5_minuten_speichen() {
	  Assert.assertEquals(stellmacher.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(stellmacher.getName_5_min(), "Speichen");
  }
  
  @Test
  public void stellmacher_produziert_in_15_minuten_karrenrad() {
	  Assert.assertEquals(stellmacher.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(stellmacher.getName_15_min(), "Karrenrad");
  }
  
  @Test
  public void stellmacher_produziert_in_1_stunde_wagenrad() {
	  Assert.assertEquals(stellmacher.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(stellmacher.getName_1_h(), "Wagenrad");
  }
  
  @Test
  public void stellmacher_produziert_in_4_stunden_karren() {
	  Assert.assertEquals(stellmacher.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(stellmacher.getName_4_h(), "Karren");
  }
  
  @Test
  public void stellmacher_produziert_in_8_stunden_droschke() {
	  Assert.assertEquals(stellmacher.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(stellmacher.getName_8_h(), "Droschke");
  }
  
  @Test
  public void stellmacher_produziert_in_1_tag_kutsche() {
	  Assert.assertEquals(stellmacher.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(stellmacher.getName_1_t(), "Kutsche");
  }
  
  @Test
  public void stellmacher_ist_diamt_gebaeude() {
	  Assert.assertEquals(stellmacher.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(stellmacher.getGebaeude_art(), "Diamant");
  }

}
