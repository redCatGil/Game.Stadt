package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Brauerei;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class BrauereiTest {
	
	private Brauerei brauerei;
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
  public void beforeMethod() {
		Properties props = new Properties();
		String dsn = "ressource/main/xml/brauerei1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Brauerei wurde nicht gefunden!");
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
		//Brauerei init
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
		
		brauerei = new Brauerei(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_brauerei_sein() {
	  Assert.assertEquals(brauerei.getName(), name);
	  Assert.assertEquals(brauerei.getName(), "Brauerei");
  }
  
  @Test
  public void zeitalter_muss_spaetes_mittelalter_sein() {
	  Assert.assertEquals(brauerei.getZeitalter(), zeitalter);
	  Assert.assertEquals(brauerei.getZeitalter(), "Spaetes_Mittelalter");
  }
  
  @Test
  public void brauerei_kostet_56000_muenzen() {
	  Assert.assertEquals(brauerei.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(brauerei.getMuenzen().intValue(), 56000);
  }
  
  @Test
  public void brauerei_kostest_9500_werkzeug() {
	  Assert.assertEquals(brauerei.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(brauerei.getWerkzeug().intValue(), 9500);
  }
  
  @Test
  public void brauerei_kostet_keine_daimanten() {
	  Assert.assertEquals(brauerei.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(brauerei.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void brauerei_benötigt_136_personen() {
	  Assert.assertEquals(brauerei.getPersonen().intValue(), personen);
	  Assert.assertEquals(brauerei.getPersonen().intValue(), 136);
  }
  
  @Test
  public void brauerei_ist_3_lang() {
	  Assert.assertEquals(brauerei.getLaenge().intValue(), laenge);
	  Assert.assertEquals(brauerei.getLaenge().intValue(), 3);
  }
  
  @Test
  public void brauerei_ist_3_breit() {
	  Assert.assertEquals(brauerei.getBreite().intValue(), breite);
	  Assert.assertEquals(brauerei.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_brauerei_ist_8_stunden_50_minuten() {
	  Assert.assertEquals(brauerei.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(brauerei.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(brauerei.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(brauerei.getBauzeit().get(Calendar.MINUTE), 50);
	  Assert.assertEquals(brauerei.getBauzeit().get(Calendar.HOUR), 8);
	  Assert.assertEquals(brauerei.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void brauerei_benoetigt_strasse() {
	  Assert.assertEquals(brauerei.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(brauerei.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void brauerei_produziert_in_5_minuten_70_werkzeug() {
	  Assert.assertEquals(brauerei.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(brauerei.getIn_5_Minuten().intValue(), 70);
  }
  
  @Test
  public void brauerei_produziert_in_15_minuten_170_werkzeug() {
	  Assert.assertEquals(brauerei.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(brauerei.getIn_15_Minuten().intValue(), 170);
  }
  
  @Test
  public void brauerei_produziert_in_1_stunde_400_werkzeug() {
	  Assert.assertEquals(brauerei.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(brauerei.getIn_1_Stunde().intValue(), 400);
  }
  
  @Test
  public void brauerei_produziert_in_4_stunden_670_werkzeug() {
	  Assert.assertEquals(brauerei.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(brauerei.getIn_4_Stunden().intValue(), 670);
  }
  
  @Test
  public void brauerei_produziert_in_8_stunden_1000_werkzeug() {
	  Assert.assertEquals(brauerei.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(brauerei.getIn_8_Stunden().intValue(), 1000);
  }
  
  @Test
  public void brauerei_produziert_in_1_tag_2000_werkzeug() {
	  Assert.assertEquals(brauerei.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(brauerei.getIn_1_Tag().intValue(), 2000);
  }
  
  @Test
  public void brauerei_produziert_in_5_minuten_met() {
	  Assert.assertEquals(brauerei.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(brauerei.getName_5_min(), "Met");
  }
  
  @Test
  public void brauerei_produziert_in_15_minuten_ein_krug_bier() {
	  Assert.assertEquals(brauerei.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(brauerei.getName_15_min(), "Ein Krug Bier");
  }
  
  @Test
  public void brauerei_produziert_in_1_stunde_ein_humpen_bier() {
	  Assert.assertEquals(brauerei.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(brauerei.getName_1_h(), "Ein Humpen Bier");
  }
  
  @Test
  public void brauerei_produziert_in_4_stunden_ein_fass_bier() {
	  Assert.assertEquals(brauerei.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(brauerei.getName_4_h(), "Ein Fass Bier");
  }
  
  @Test
  public void brauerei_produziert_in_8_stunden_einige_faesser_biere() {
	  Assert.assertEquals(brauerei.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(brauerei.getName_8_h(), "Einige Fässer Bier");
  }
  
  @Test
  public void brauerei_produziert_in_1_tag_viele_faesser_bier() {
	  Assert.assertEquals(brauerei.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(brauerei.getName_1_t(), "Viele Fässer Bier");
  }
  
  @Test
  public void brauerei_ist_normales_gebaeude() {
	  Assert.assertEquals(brauerei.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(brauerei.getGebaeude_art(), "Normal");
  }

}
