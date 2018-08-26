package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Schneiderei;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class SchneidereiTest {
	
	private Schneiderei schneiderei;
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
		String dsn = "ressource/main/xml/schneiderei1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Schneiderei wurde nicht gefunden!");
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
		
		schneiderei = new Schneiderei(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_schneiderei_sein() {
	  Assert.assertEquals(schneiderei.getName(), name);
	  Assert.assertEquals(schneiderei.getName(), "Schneiderei");
  }
  
  @Test
  public void zeitalter_muss_eisenzeit_sein() {
	  Assert.assertEquals(schneiderei.getZeitalter(), zeitalter);
	  Assert.assertEquals(schneiderei.getZeitalter(), "Eisenzeit");
  }
  
  @Test
  public void schneiderei_kostet_0_muenzen() {
	  Assert.assertEquals(schneiderei.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(schneiderei.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void schneiderei_kostest_0_werkzeug() {
	  Assert.assertEquals(schneiderei.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(schneiderei.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void schneiderei_kostet_400_daimanten() {
	  Assert.assertEquals(schneiderei.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(schneiderei.getDiamanten().intValue(), 400);
  }
  
  @Test
  public void schneiderei_benötigt_88_personen() {
	  Assert.assertEquals(schneiderei.getPersonen().intValue(), personen);
	  Assert.assertEquals(schneiderei.getPersonen().intValue(), 88);
  }
  
  @Test
  public void schneiderei_ist_3_lang() {
	  Assert.assertEquals(schneiderei.getLaenge().intValue(), laenge);
	  Assert.assertEquals(schneiderei.getLaenge().intValue(), 3);
  }
  
  @Test
  public void schneiderei_ist_4_breit() {
	  Assert.assertEquals(schneiderei.getBreite().intValue(), breite);
	  Assert.assertEquals(schneiderei.getBreite().intValue(), 4);
  }
  
  @Test
  public void bauzeit_schneiderei_ist_20_sec() {
	  Assert.assertEquals(schneiderei.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(schneiderei.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(schneiderei.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(schneiderei.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(schneiderei.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(schneiderei.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void schneiderei_benoetigt_strasse() {
	  Assert.assertEquals(schneiderei.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(schneiderei.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void schneiderei_produziert_in_5_minuten_60_werkzeug() {
	  Assert.assertEquals(schneiderei.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(schneiderei.getIn_5_Minuten().intValue(), 60);
  }
  
  @Test
  public void schneiderei_produziert_in_15_minuten_150_werkzeug() {
	  Assert.assertEquals(schneiderei.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(schneiderei.getIn_15_Minuten().intValue(), 150);
  }
  
  @Test
  public void schneiderei_produziert_in_1_stunde_360_werkzeug() {
	  Assert.assertEquals(schneiderei.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(schneiderei.getIn_1_Stunde().intValue(), 360);
  }
  
  @Test
  public void schneiderei_produziert_in_4_stunden_600_werkzeug() {
	  Assert.assertEquals(schneiderei.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(schneiderei.getIn_4_Stunden().intValue(), 600);
  }
  
  @Test
  public void schneiderei_produziert_in_8_stunden_900_werkzeug() {
	  Assert.assertEquals(schneiderei.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(schneiderei.getIn_8_Stunden().intValue(), 900);
  }
  
  @Test
  public void schneiderei_produziert_in_1_tag_1800_werkzeug() {
	  Assert.assertEquals(schneiderei.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(schneiderei.getIn_1_Tag().intValue(), 1800);
  }
  
  @Test
  public void schneiderei_produziert_in_5_minuten_tuch() {
	  Assert.assertEquals(schneiderei.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(schneiderei.getName_5_min(), "Tuch");
  }
  
  @Test
  public void schneiderei_produziert_in_15_minuten_viel_tuch() {
	  Assert.assertEquals(schneiderei.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(schneiderei.getName_15_min(), "Viel Tuch");
  }
  
  @Test
  public void schneiderei_produziert_in_1_stunde_einfache_kleider() {
	  Assert.assertEquals(schneiderei.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(schneiderei.getName_1_h(), "Einfache Kleider");
  }
  
  @Test
  public void schneiderei_produziert_in_4_stunden_Cape() {
	  Assert.assertEquals(schneiderei.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(schneiderei.getName_4_h(), "Cape");
  }
  
  @Test
  public void schneiderei_produziert_in_8_stunden_gute_kleider() {
	  Assert.assertEquals(schneiderei.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(schneiderei.getName_8_h(), "Gute Kleider");
  }
  
  @Test
  public void schneiderei_produziert_in_1_tag_toga() {
	  Assert.assertEquals(schneiderei.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(schneiderei.getName_1_t(), "Toga");
  }
  
  @Test
  public void schneiderei_ist_diamant_gebaeude() {
	  Assert.assertEquals(schneiderei.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(schneiderei.getGebaeude_art(), "Diamant");
  }

}
