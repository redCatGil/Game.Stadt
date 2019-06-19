package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Chemiefabrik;
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


public class ChemiefabrikTest {
	
	private Chemiefabrik chemiefabrik;
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
		String dsn = "ressource/main/xml/chemiefabrik1.xml";
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
		//Chemiefabrik init
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
		
		chemiefabrik = new Chemiefabrik(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_chemiefabrik_sein() {
	  Assert.assertEquals(chemiefabrik.getName(), name);
	  Assert.assertEquals(chemiefabrik.getName(), "Chemiefabrik");
  }
  
  @Test
  public void zeitalter_muss_Industriezeitalter_sein() {
	  Assert.assertEquals(chemiefabrik.getZeitalter(), zeitalter);
	  Assert.assertEquals(chemiefabrik.getZeitalter(), "Industriezeitalter");
  }
  
  @Test
  public void chemiefabrik_kostet_84000_muenzen() {
	  Assert.assertEquals(chemiefabrik.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(chemiefabrik.getMuenzen().intValue(), 84000);
  }
  
  @Test
  public void chemiefabrik_kostest_19800_werkzeug() {
	  Assert.assertEquals(chemiefabrik.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(chemiefabrik.getWerkzeug().intValue(), 19800);
  }
  
  @Test
  public void chemiefabrik_kostet_keine_daimanten() {
	  Assert.assertEquals(chemiefabrik.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(chemiefabrik.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void chemiefabrik_benötigt_224_personen() {
	  Assert.assertEquals(chemiefabrik.getPersonen().intValue(), personen);
	  Assert.assertEquals(chemiefabrik.getPersonen().intValue(), 224);
  }
  
  @Test
  public void chemiefabrik_ist_4_lang() {
	  Assert.assertEquals(chemiefabrik.getLaenge().intValue(), laenge);
	  Assert.assertEquals(chemiefabrik.getLaenge().intValue(), 4);
  }
  
  @Test
  public void chemiefabrik_ist_3_breit() {
	  Assert.assertEquals(chemiefabrik.getBreite().intValue(), breite);
	  Assert.assertEquals(chemiefabrik.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_chemiefabrike_ist_12_stunden_20_minuten() {
	  Calendar cal =Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
	  cal.setTime(chemiefabrik.getpBauzeit());
	  Assert.assertEquals(cal.get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), 20);
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 12);
	  Assert.assertEquals(cal.get(Calendar.SECOND), 0);
  }
  
  @Test
  public void chemiefabrik_benoetigt_strasse() {
	  Assert.assertEquals(chemiefabrik.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(chemiefabrik.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void chemiefabrik_produziert_in_5_minuten_120_werkzeug() {
	  Assert.assertEquals(chemiefabrik.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(chemiefabrik.getIn_5_Minuten().intValue(), 120);
  }
  
  @Test
  public void chemiefabrik_produziert_in_15_minuten_300_werkzeug() {
	  Assert.assertEquals(chemiefabrik.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(chemiefabrik.getIn_15_Minuten().intValue(), 300);
  }
  
  @Test
  public void chemiefabrik_produziert_in_1_stunde_720_werkzeug() {
	  Assert.assertEquals(chemiefabrik.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(chemiefabrik.getIn_1_Stunde().intValue(), 720);
  }
  
  @Test
  public void chemiefabrik_produziert_in_4_stunden_1200_werkzeug() {
	  Assert.assertEquals(chemiefabrik.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(chemiefabrik.getIn_4_Stunden().intValue(), 1200);
  }
  
  @Test
  public void chemiefabrik_produziert_in_8_stunden_1800_werkzeug() {
	  Assert.assertEquals(chemiefabrik.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(chemiefabrik.getIn_8_Stunden().intValue(), 1800);
  }
  
  @Test
  public void chemiefabrik_produziert_in_1_tag_3590_werkzeug() {
	  Assert.assertEquals(chemiefabrik.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(chemiefabrik.getIn_1_Tag().intValue(), 3590);
  }
  
  @Test
  public void chemiefabrik_produziert_in_5_minuten_reagenzien() {
	  Assert.assertEquals(chemiefabrik.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(chemiefabrik.getName_5_min(), "Reagenzien");
  }
  
  @Test
  public void chemiefabrik_produziert_in_15_minuten_insektiziede() {
	  Assert.assertEquals(chemiefabrik.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(chemiefabrik.getName_15_min(), "Insektiziede");
  }
  
  @Test
  public void chemiefabrik_produziert_in_1_stunde_zusatzstoffe() {
	  Assert.assertEquals(chemiefabrik.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(chemiefabrik.getName_1_h(), "Zusatzstoffe");
  }
  
  @Test
  public void chemiefabrik_produziert_in_4_stunden_farben_und_lacke() {
	  Assert.assertEquals(chemiefabrik.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(chemiefabrik.getName_4_h(), "Farben und Lacke");
  }
  
  @Test
  public void chemiefabrik_produziert_in_8_stunden_sprengstoff() {
	  Assert.assertEquals(chemiefabrik.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(chemiefabrik.getName_8_h(), "Sprengstoff");
  }
  
  @Test
  public void chemiefabrik_produziert_in_1_tag_medikamente() {
	  Assert.assertEquals(chemiefabrik.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(chemiefabrik.getName_1_t(), "Medikamente");
  }
  
  @Test
  public void chemiefabrik_ist_normales_gebaeude() {
	  Assert.assertEquals(chemiefabrik.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(chemiefabrik.getGebaeude_art(), "Normal");
  }

}
