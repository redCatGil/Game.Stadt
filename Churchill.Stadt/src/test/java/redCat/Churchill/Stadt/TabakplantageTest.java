package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Brauerei;
import redCat.Churchill.Stadt.Bauwerke.impl.Tabakplantage;
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


public class TabakplantageTest {
	
	private Tabakplantage tabakplantage;
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
		String dsn = "ressource/main/xml/tabakplantage1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Tabakplantage wurde nicht gefunden!");
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
		//Tabakplantage init
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
		
		tabakplantage = new Tabakplantage(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_tabakplantage_sein() {
	  Assert.assertEquals(tabakplantage.getName(), name);
	  Assert.assertEquals(tabakplantage.getName(), "Tabakplantage");
  }
  
  @Test
  public void zeitalter_muss_kolonialzeit_sein() {
	  Assert.assertEquals(tabakplantage.getZeitalter(), zeitalter);
	  Assert.assertEquals(tabakplantage.getZeitalter(), "Kolonialzeit");
  }
  
  @Test
  public void tabakplantage_kostet_81000_muenzen() {
	  Assert.assertEquals(tabakplantage.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(tabakplantage.getMuenzen().intValue(), 81000);
  }
  
  @Test
  public void tabakplantage_kostest_15700_werkzeug() {
	  Assert.assertEquals(tabakplantage.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(tabakplantage.getWerkzeug().intValue(), 15700);
  }
  
  @Test
  public void tabakplantage_kostet_keine_daimanten() {
	  Assert.assertEquals(tabakplantage.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(tabakplantage.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void tabakplantage_benötigt_365_personen() {
	  Assert.assertEquals(tabakplantage.getPersonen().intValue(), personen);
	  Assert.assertEquals(tabakplantage.getPersonen().intValue(), 365);
  }
  
  @Test
  public void tabakplantage_ist_4_lang() {
	  Assert.assertEquals(tabakplantage.getLaenge().intValue(), laenge);
	  Assert.assertEquals(tabakplantage.getLaenge().intValue(), 4);
  }
  
  @Test
  public void tabakplantage_ist_4_breit() {
	  Assert.assertEquals(tabakplantage.getBreite().intValue(), breite);
	  Assert.assertEquals(tabakplantage.getBreite().intValue(), 4);
  }
  
  @Test
  public void bauzeit_tabakplantage_ist_14_stunden_40_minuten() {
	  Calendar cal =Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
	  cal.setTime(tabakplantage.getpBauzeit());
	  Assert.assertEquals(cal.get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), 40);
	  Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 14);
	  Assert.assertEquals(cal.get(Calendar.SECOND), 0);
  }
  
  @Test
  public void tabakplantage_benoetigt_strasse() {
	  Assert.assertEquals(tabakplantage.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(tabakplantage.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void tabakplantage_produziert_in_5_minuten_150_werkzeug() {
	  Assert.assertEquals(tabakplantage.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(tabakplantage.getIn_5_Minuten().intValue(), 150);
  }
  
  @Test
  public void tabakplantage_produziert_in_15_minuten_380_werkzeug() {
	  Assert.assertEquals(tabakplantage.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(tabakplantage.getIn_15_Minuten().intValue(), 380);
  }
  
  @Test
  public void tabakplantage_produziert_in_1_stunde_900_werkzeug() {
	  Assert.assertEquals(tabakplantage.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(tabakplantage.getIn_1_Stunde().intValue(), 900);
  }
  
  @Test
  public void tabakplantage_produziert_in_4_stunden_1500_werkzeug() {
	  Assert.assertEquals(tabakplantage.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(tabakplantage.getIn_4_Stunden().intValue(), 1500);
  }
  
  @Test
  public void tabakplantage_produziert_in_8_stunden_2260_werkzeug() {
	  Assert.assertEquals(tabakplantage.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(tabakplantage.getIn_8_Stunden().intValue(), 2260);
  }
  
  @Test
  public void tabakplantage_produziert_in_1_tag_4510_werkzeug() {
	  Assert.assertEquals(tabakplantage.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(tabakplantage.getIn_1_Tag().intValue(), 4510);
  }
  
  @Test
  public void tabakplantage_produziert_in_5_minuten_zigarre() {
	  Assert.assertEquals(tabakplantage.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(tabakplantage.getName_5_min(), "Zigarre");
  }
  
  @Test
  public void tabakplantage_produziert_in_15_minuten_zigarillo_schachtel() {
	  Assert.assertEquals(tabakplantage.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(tabakplantage.getName_15_min(), "Zigarillo-Schachtel");
  }
  
  @Test
  public void tabakplantage_produziert_in_1_stunde_zigarrenschachtel() {
	  Assert.assertEquals(tabakplantage.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(tabakplantage.getName_1_h(), "Zigarrenschachtel");
  }
  
  @Test
  public void tabakplantage_produziert_in_4_stunden_zigarrenkiste() {
	  Assert.assertEquals(tabakplantage.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(tabakplantage.getName_4_h(), "Zigarrenkiste");
  }
  
  @Test
  public void tabakplantage_produziert_in_8_stunden_tabakfass() {
	  Assert.assertEquals(tabakplantage.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(tabakplantage.getName_8_h(), "Tabakfass");
  }
  
  @Test
  public void tabakplantage_produziert_in_1_tag_tabakfaesser() {
	  Assert.assertEquals(tabakplantage.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(tabakplantage.getName_1_t(), "Tabakfässer");
  }
  
  @Test
  public void tabakplantage_ist_normales_gebaeude() {
	  Assert.assertEquals(tabakplantage.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(tabakplantage.getGebaeude_art(), "Normal");
  }

}
