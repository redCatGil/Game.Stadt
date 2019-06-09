package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.Uhrmacher;

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


public class UhrmacherTest {
	
	private Uhrmacher uhrmacher;
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
		String dsn = "ressource/main/xml/uhrmacher1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für den Uhrmacher wurde nicht gefunden!");
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
		//Uhrmacher init
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
		
		uhrmacher = new Uhrmacher(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_uhrmacher_sein() {
	  Assert.assertEquals(uhrmacher.getName(), name);
	  Assert.assertEquals(uhrmacher.getName(), "Uhrmacher");
  }
  
  @Test
  public void zeitalter_muss_kolonialzeit_sein() {
	  Assert.assertEquals(uhrmacher.getZeitalter(), zeitalter);
	  Assert.assertEquals(uhrmacher.getZeitalter(), "Kolonialzeit");
  }
  
  @Test
  public void uhrmacher_kostet_43000_muenzen() {
	  Assert.assertEquals(uhrmacher.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(uhrmacher.getMuenzen().intValue(), 43000);
  }
  
  @Test
  public void uhrmacher_kostest_7400_werkzeug() {
	  Assert.assertEquals(uhrmacher.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(uhrmacher.getWerkzeug().intValue(), 7400);
  }
  
  @Test
  public void uhrmacher_kostet_keine_daimanten() {
	  Assert.assertEquals(uhrmacher.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(uhrmacher.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void uhrmacher_benötigt_68_personen() {
	  Assert.assertEquals(uhrmacher.getPersonen().intValue(), personen);
	  Assert.assertEquals(uhrmacher.getPersonen().intValue(), 68);
  }
  
  @Test
  public void uhrmacher_ist_3_lang() {
	  Assert.assertEquals(uhrmacher.getLaenge().intValue(), laenge);
	  Assert.assertEquals(uhrmacher.getLaenge().intValue(), 3);
  }
  
  @Test
  public void uhrmacher_ist_2_breit() {
	  Assert.assertEquals(uhrmacher.getBreite().intValue(), breite);
	  Assert.assertEquals(uhrmacher.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_uhrmachere_ist_8_stunden_20_minuten() {
	  Calendar cal =Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
	  cal.setTime(uhrmacher.getpBauzeit());
	  Assert.assertEquals(cal.get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), 20);
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 8);
	  Assert.assertEquals(cal.get(Calendar.SECOND), 0);
  }
  
  @Test
  public void uhrmacher_benoetigt_strasse() {
	  Assert.assertEquals(uhrmacher.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(uhrmacher.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void uhrmacher_produziert_in_5_minuten_50_werkzeug() {
	  Assert.assertEquals(uhrmacher.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(uhrmacher.getIn_5_Minuten().intValue(), 50);
  }
  
  @Test
  public void uhrmacher_produziert_in_15_minuten_140_werkzeug() {
	  Assert.assertEquals(uhrmacher.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(uhrmacher.getIn_15_Minuten().intValue(), 140);
  }
  
  @Test
  public void uhrmacher_produziert_in_1_stunde_320_werkzeug() {
	  Assert.assertEquals(uhrmacher.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(uhrmacher.getIn_1_Stunde().intValue(), 320);
  }
  
  @Test
  public void uhrmacher_produziert_in_4_stunden_540_werkzeug() {
	  Assert.assertEquals(uhrmacher.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(uhrmacher.getIn_4_Stunden().intValue(), 540);
  }
  
  @Test
  public void uhrmacher_produziert_in_8_stunden_810_werkzeug() {
	  Assert.assertEquals(uhrmacher.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(uhrmacher.getIn_8_Stunden().intValue(), 810);
  }
  
  @Test
  public void uhrmacher_produziert_in_1_tag_1620_werkzeug() {
	  Assert.assertEquals(uhrmacher.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(uhrmacher.getIn_1_Tag().intValue(), 1620);
  }
  
  @Test
  public void uhrmacher_produziert_in_5_minuten_uhrenteile() {
	  Assert.assertEquals(uhrmacher.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(uhrmacher.getName_5_min(), "Uhrenteile");
  }
  
  @Test
  public void uhrmacher_produziert_in_15_minuten_sextant() {
	  Assert.assertEquals(uhrmacher.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(uhrmacher.getName_15_min(), "Sextant");
  }
  
  @Test
  public void uhrmacher_produziert_in_1_stunde_taschenuhr() {
	  Assert.assertEquals(uhrmacher.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(uhrmacher.getName_1_h(), "Taschenuhr");
  }
  
  @Test
  public void uhrmacher_produziert_in_4_stunden_Tischuhr() {
	  Assert.assertEquals(uhrmacher.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(uhrmacher.getName_4_h(), "Tischuhr");
  }
  
  @Test
  public void uhrmacher_produziert_in_8_stunden_standuhr() {
	  Assert.assertEquals(uhrmacher.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(uhrmacher.getName_8_h(), "Standuhr");
  }
  
  @Test
  public void uhrmacher_produziert_in_1_tag_turmuhr() {
	  Assert.assertEquals(uhrmacher.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(uhrmacher.getName_1_t(), "Turmuhr");
  }
  
  @Test
  public void uhrmacher_ist_normales_gebaeude() {
	  Assert.assertEquals(uhrmacher.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(uhrmacher.getGebaeude_art(), "Normal");
  }

}
