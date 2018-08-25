package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Schmiede;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class SchmiedeTest {
	
	private Schmiede schmiede;
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
		String dsn = "ressource/main/xml/schmiede1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Schmiede wurde nicht gefunden!");
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
		
		schmiede = new Schmiede(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t);
	           
  }
  
  @Test
  public void name_muss_schmiede_sein() {
	  Assert.assertEquals(schmiede.getName(), name);
	  Assert.assertEquals(schmiede.getName(), "Schmiede");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(schmiede.getZeitalter(), zeitalter);
	  Assert.assertEquals(schmiede.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void schmiede_kostet_412_muenzen() {
	  Assert.assertEquals(schmiede.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(schmiede.getMuenzen().intValue(), 412);
  }
  
  @Test
  public void schmiede_kostest_38_werkzeug() {
	  Assert.assertEquals(schmiede.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(schmiede.getWerkzeug().intValue(), 38);
  }
  
  @Test
  public void schmiede_kostet_keine_daimanten() {
	  Assert.assertEquals(schmiede.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(schmiede.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void schmiede_benötigt_12_personen() {
	  Assert.assertEquals(schmiede.getPersonen().intValue(), personen);
	  Assert.assertEquals(schmiede.getPersonen().intValue(), 12);
  }
  
  @Test
  public void schmiede_ist_2_lang() {
	  Assert.assertEquals(schmiede.getLaenge().intValue(), laenge);
	  Assert.assertEquals(schmiede.getLaenge().intValue(), 2);
  }
  
  @Test
  public void schmiede_ist_2_breit() {
	  Assert.assertEquals(schmiede.getBreite().intValue(), breite);
	  Assert.assertEquals(schmiede.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_schmiede_ist_20_minuten() {
	  Assert.assertEquals(schmiede.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(schmiede.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(schmiede.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(schmiede.getBauzeit().get(Calendar.MINUTE), 20);
	  Assert.assertEquals(schmiede.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(schmiede.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void schmiede_benoetigt_strasse() {
	  Assert.assertEquals(schmiede.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(schmiede.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void schmiede_produziert_in_5_minuten_5_werkzeug() {
	  Assert.assertEquals(schmiede.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(schmiede.getIn_5_Minuten().intValue(), 5);
  }
  
  @Test
  public void schmiede_produziert_in_15_minuten_13_werkzeug() {
	  Assert.assertEquals(schmiede.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(schmiede.getIn_15_Minuten().intValue(), 13);
  }
  
  @Test
  public void schmiede_produziert_in_1_stunde_32_werkzeug() {
	  Assert.assertEquals(schmiede.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(schmiede.getIn_1_Stunde().intValue(), 32);
  }
  
  @Test
  public void schmiede_produziert_in_4_stunden_53_werkzeug() {
	  Assert.assertEquals(schmiede.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(schmiede.getIn_4_Stunden().intValue(), 53);
  }
  
  @Test
  public void schmiede_produziert_in_8_stunden_80_werkzeug() {
	  Assert.assertEquals(schmiede.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(schmiede.getIn_8_Stunden().intValue(), 80);
  }
  
  @Test
  public void schmiede_produziert_in_1_tag_160_werkzeug() {
	  Assert.assertEquals(schmiede.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(schmiede.getIn_1_Tag().intValue(), 160);
  }
  
  @Test
  public void schmiede_produziert_in_5_minuten_einfaches_hufeisen() {
	  Assert.assertEquals(schmiede.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(schmiede.getName_5_min(), "Einfaches Hufeisen");
  }
  
  @Test
  public void schmiede_produziert_in_15_minuten_gutes_hufeisen() {
	  Assert.assertEquals(schmiede.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(schmiede.getName_15_min(), "Gutes Hufeisen");
  }
  
  @Test
  public void schmiede_produziert_in_1_stunde_greifzange() {
	  Assert.assertEquals(schmiede.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(schmiede.getName_1_h(), "Greifzange");
  }
  
  @Test
  public void schmiede_produziert_in_4_stunden_zange() {
	  Assert.assertEquals(schmiede.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(schmiede.getName_4_h(), "Zange");
  }
  
  @Test
  public void schmiede_produziert_in_8_stunden_schloss() {
	  Assert.assertEquals(schmiede.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(schmiede.getName_8_h(), "Schloss");
  }
  
  @Test
  public void schmiede_produziert_in_1_tag_helm() {
	  Assert.assertEquals(schmiede.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(schmiede.getName_1_t(), "Helm");
  }
  
 

}
