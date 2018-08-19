package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Obstplantage;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class ObstplantageTest {
	
	private Obstplantage obstplantage;
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
	
  
  @BeforeMethod
  public void beforeMethod() {
		Properties props = new Properties();
		String dsn = "ressource/main/xml/obstplantage1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Obstplantage wurde nicht gefunden!");
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
		//Hütte init
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
		if (props.getProperty("Strasse").compareToIgnoreCase("true") == 0) {
			  strasse = true;

		  } else {
			  strasse = false;
		  }
		
		obstplantage = new Obstplantage(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t);
	           
  }
  
  @Test
  public void name_muss_obstplantage_sein() {
	  Assert.assertEquals(obstplantage.getName(), name);
	  Assert.assertEquals(obstplantage.getName(), "Obstplantage");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(obstplantage.getZeitalter(), zeitalter);
	  Assert.assertEquals(obstplantage.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void obstplantage_kostet_1592_muenzen() {
	  Assert.assertEquals(obstplantage.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(obstplantage.getMuenzen().intValue(), 1592);
  }
  
  @Test
  public void obstplantage_kostest_118_werkzeug() {
	  Assert.assertEquals(obstplantage.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(obstplantage.getWerkzeug().intValue(), 118);
  }
  
  @Test
  public void obstplantage_kostet_keine_daimanten() {
	  Assert.assertEquals(obstplantage.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(obstplantage.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void obstplantage_benötigt_50_personen() {
	  Assert.assertEquals(obstplantage.getPersonen().intValue(), personen);
	  Assert.assertEquals(obstplantage.getPersonen().intValue(), 50);
  }
  
  @Test
  public void obstplantage_ist_5_lang() {
	  Assert.assertEquals(obstplantage.getLaenge().intValue(), laenge);
	  Assert.assertEquals(obstplantage.getLaenge().intValue(), 5);
  }
  
  @Test
  public void obstplantage_ist_4_breit() {
	  Assert.assertEquals(obstplantage.getBreite().intValue(), breite);
	  Assert.assertEquals(obstplantage.getBreite().intValue(), 4);
  }
  
  @Test
  public void bauzeit_obstplantage_ist_40_minuten() {
	  Assert.assertEquals(obstplantage.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(obstplantage.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(obstplantage.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(obstplantage.getBauzeit().get(Calendar.MINUTE), 40);
	  Assert.assertEquals(obstplantage.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(obstplantage.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void obstplantage_benoetigt_strasse() {
	  Assert.assertEquals(obstplantage.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(obstplantage.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void obstplantage_produziert_in_5_minuten_unb_werkzeug() {
	  Assert.assertEquals(obstplantage.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(obstplantage.getIn_5_Minuten().intValue(), 0);
  }
  
  @Test
  public void obstplantage_produziert_in_15_minuten_unb_werkzeug() {
	  Assert.assertEquals(obstplantage.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(obstplantage.getIn_15_Minuten().intValue(), 0);
  }
  
  @Test
  public void obstplantage_produziert_in_1_stunde_130_werkzeug() {
	  Assert.assertEquals(obstplantage.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(obstplantage.getIn_1_Stunde().intValue(), 130);
  }
  
  @Test
  public void obstplantage_produziert_in_4_stunden_unb_werkzeug() {
	  Assert.assertEquals(obstplantage.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(obstplantage.getIn_4_Stunden().intValue(), 0);
  }
  
  @Test
  public void obstplantage_produziert_in_8_stunden_unb_werkzeug() {
	  Assert.assertEquals(obstplantage.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(obstplantage.getIn_8_Stunden().intValue(), 0);
  }
  
  @Test
  public void obstplantage_produziert_in_1_tag_unb_werkzeug() {
	  Assert.assertEquals(obstplantage.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(obstplantage.getIn_1_Tag().intValue(), 0);
  }
  
  @Test
  public void obstplantage_produziert_in_5_minuten_unbekannt() {
	  Assert.assertEquals(obstplantage.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(obstplantage.getName_5_min(), "unbekannt");
  }
  
  @Test
  public void obstplantage_produziert_in_15_minuten_unbekannt() {
	  Assert.assertEquals(obstplantage.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(obstplantage.getName_15_min(), "unbekannt");
  }
  
  @Test
  public void obstplantage_produziert_in_1_stunde_unbekannt() {
	  Assert.assertEquals(obstplantage.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(obstplantage.getName_1_h(), "unbekannt");
  }
  
  @Test
  public void obstplantage_produziert_in_4_stunden_unbekannt() {
	  Assert.assertEquals(obstplantage.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(obstplantage.getName_4_h(), "unbekannt");
  }
  
  @Test
  public void obstplantage_produziert_in_8_stunden_unbekannt() {
	  Assert.assertEquals(obstplantage.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(obstplantage.getName_8_h(), "unbekannt");
  }
  
  @Test
  public void obstplantage_produziert_in_1_tag_unbekannt() {
	  Assert.assertEquals(obstplantage.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(obstplantage.getName_1_t(), "unbekannt");
  }
  
 

}
