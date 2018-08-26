package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Jagdlager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class JagdlagerTest {
	
	private Jagdlager jagdlager;
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
	private String gebaeude_art;
	private boolean strasse;
	
  
  @BeforeMethod
  public void beforeMethod() {
		Properties props = new Properties();
		String dsn = "ressource/main/xml/jagdlager1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Jagdlager wurde nicht gefunden!");
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
		gebaeude_art = props.getProperty("Geb_Art");
		if (props.getProperty("Strasse").compareToIgnoreCase("true") == 0) {
			  strasse = true;

		  } else {
			  strasse = false;
		  }
		
		jagdlager = new Jagdlager(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_jagdlager_sein() {
	  Assert.assertEquals(jagdlager.getName(), name);
	  Assert.assertEquals(jagdlager.getName(), "Jagdlager");
  }
  
  @Test
  public void zeitalter_muss_steinzeit_sein() {
	  Assert.assertEquals(jagdlager.getZeitalter(), zeitalter);
	  Assert.assertEquals(jagdlager.getZeitalter(), "Steinzeit");
  }
  
  @Test
  public void jagdlager_kostet_87_muenzen() {
	  Assert.assertEquals(jagdlager.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(jagdlager.getMuenzen().intValue(), 87);
  }
  
  @Test
  public void jagdlager_kostest_0_werkzeug() {
	  Assert.assertEquals(jagdlager.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(jagdlager.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void jagdlager_kostet_keine_daimanten() {
	  Assert.assertEquals(jagdlager.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(jagdlager.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void jagdlager_benötigt_28_personen() {
	  Assert.assertEquals(jagdlager.getPersonen().intValue(), personen);
	  Assert.assertEquals(jagdlager.getPersonen().intValue(), 28);
  }
  
  @Test
  public void jagdlager_ist_3_lang() {
	  Assert.assertEquals(jagdlager.getLaenge().intValue(), laenge);
	  Assert.assertEquals(jagdlager.getLaenge().intValue(), 3);
  }
  
  @Test
  public void jagdlager_ist_3_breit() {
	  Assert.assertEquals(jagdlager.getBreite().intValue(), breite);
	  Assert.assertEquals(jagdlager.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_jagdlager_ist__sec() {
	  Assert.assertEquals(jagdlager.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(jagdlager.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(jagdlager.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(jagdlager.getBauzeit().get(Calendar.SECOND), 5);
  }
  
  @Test
  public void jagdlager_benoetigt_strasse() {
	  Assert.assertEquals(jagdlager.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(jagdlager.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void jagdlager_produziert_in_5_minuten_7_werkzeug() {
	  Assert.assertEquals(jagdlager.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(jagdlager.getIn_5_Minuten().intValue(), 7);
  }
  
  @Test
  public void jagdlager_produziert_in_15_minuten_14_werkzeug() {
	  Assert.assertEquals(jagdlager.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(jagdlager.getIn_15_Minuten().intValue(), 14);
  }
  
  @Test
  public void jagdlager_produziert_in_1_stunde_34_werkzeug() {
	  Assert.assertEquals(jagdlager.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(jagdlager.getIn_1_Stunde().intValue(), 34);
  }
  
  @Test
  public void jagdlager_produziert_in_4_stunden_56_werkzeug() {
	  Assert.assertEquals(jagdlager.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(jagdlager.getIn_4_Stunden().intValue(), 56);
  }
  
  @Test
  public void jagdlager_produziert_in_8_stunden_84_werkzeug() {
	  Assert.assertEquals(jagdlager.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(jagdlager.getIn_8_Stunden().intValue(), 84);
  }
  
  @Test
  public void jagdlager_produziert_in_1_tag_169_werkzeug() {
	  Assert.assertEquals(jagdlager.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(jagdlager.getIn_1_Tag().intValue(), 169);
  }
  
  @Test
  public void jagdlager_produziert_in_5_minuten_trophae() {
	  Assert.assertEquals(jagdlager.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(jagdlager.getName_5_min(), "Trophäe");
  }
  
  @Test
  public void jagdlager_produziert_in_15_minuten_orakelknochen() {
	  Assert.assertEquals(jagdlager.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(jagdlager.getName_15_min(), "Orakelknochen");
  }
  
  @Test
  public void jagdlager_produziert_in_1_stunde_knochendoch() {
	  Assert.assertEquals(jagdlager.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(jagdlager.getName_1_h(), "Knochendolch");
  }
  
  @Test
  public void jagdlager_produziert_in_4_stunden_kette_aus_zaehnen() {
	  Assert.assertEquals(jagdlager.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(jagdlager.getName_4_h(), "Kette aus Zähnen");
  }
  
  @Test
  public void jagdlager_produziert_in_8_stunden_pfeilspitzen() {
	  Assert.assertEquals(jagdlager.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(jagdlager.getName_8_h(), "Pfeilspitzen");
  }
  
  @Test
  public void jagdlager_produziert_in_1_tag_pelz() {
	  Assert.assertEquals(jagdlager.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(jagdlager.getName_1_t(), "Pelz");
  }
  
  @Test
  public void jagdlager_ist_normales_gebaeude() {
	  Assert.assertEquals(jagdlager.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(jagdlager.getGebaeude_art(), "Normal");
  }
 

}
