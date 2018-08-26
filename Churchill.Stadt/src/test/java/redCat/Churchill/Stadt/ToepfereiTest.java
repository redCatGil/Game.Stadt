package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Toepferei;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class ToepfereiTest {
	
	private Toepferei toepferei;
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
		String dsn = "ressource/main/xml/toepferei1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Töpferei wurde nicht gefunden!");
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
		
		toepferei = new Toepferei(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_toepferei_sein() {
	  Assert.assertEquals(toepferei.getName(), name);
	  Assert.assertEquals(toepferei.getName(), "Töpferei");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(toepferei.getZeitalter(), zeitalter);
	  Assert.assertEquals(toepferei.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void toepferei_kostet_232_muenzen() {
	  Assert.assertEquals(toepferei.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(toepferei.getMuenzen().intValue(), 232);
  }
  
  @Test
  public void toepferei_kostest_29_werkzeug() {
	  Assert.assertEquals(toepferei.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(toepferei.getWerkzeug().intValue(), 29);
  }
  
  @Test
  public void toepferei_kostet_keine_daimanten() {
	  Assert.assertEquals(toepferei.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(toepferei.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void toepferei_benötigt_41_personen() {
	  Assert.assertEquals(toepferei.getPersonen().intValue(), personen);
	  Assert.assertEquals(toepferei.getPersonen().intValue(), 41);
  }
  
  @Test
  public void toepferei_ist_4_lang() {
	  Assert.assertEquals(toepferei.getLaenge().intValue(), laenge);
	  Assert.assertEquals(toepferei.getLaenge().intValue(), 4);
  }
  
  @Test
  public void toepferei_ist_3_breit() {
	  Assert.assertEquals(toepferei.getBreite().intValue(), breite);
	  Assert.assertEquals(toepferei.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_toepferei_ist_20_sec() {
	  Assert.assertEquals(toepferei.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(toepferei.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(toepferei.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(toepferei.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void toepferei_benoetigt_strasse() {
	  Assert.assertEquals(toepferei.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(toepferei.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void toepferei_produziert_in_5_minuten_8_werkzeug() {
	  Assert.assertEquals(toepferei.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(toepferei.getIn_5_Minuten().intValue(), 8);
  }
  
  @Test
  public void toepferei_produziert_in_15_minuten_21_werkzeug() {
	  Assert.assertEquals(toepferei.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(toepferei.getIn_15_Minuten().intValue(), 21);
  }
  
  @Test
  public void toepferei_produziert_in_1_stunde_50_werkzeug() {
	  Assert.assertEquals(toepferei.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(toepferei.getIn_1_Stunde().intValue(), 50);
  }
  
  @Test
  public void toepferei_produziert_in_4_stunden_83_werkzeug() {
	  Assert.assertEquals(toepferei.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(toepferei.getIn_4_Stunden().intValue(), 83);
  }
  
  @Test
  public void toepferei_produziert_in_8_stunden_125_werkzeug() {
	  Assert.assertEquals(toepferei.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(toepferei.getIn_8_Stunden().intValue(), 125);
  }
  
  @Test
  public void toepferei_produziert_in_1_tag_249_werkzeug() {
	  Assert.assertEquals(toepferei.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(toepferei.getIn_1_Tag().intValue(), 249);
  }
  
  @Test
  public void toepferei_produziert_in_5_minuten_flasche() {
	  Assert.assertEquals(toepferei.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(toepferei.getName_5_min(), "Flasche");
  }
  
  @Test
  public void toepferei_produziert_in_15_minuten_kleine_toepfen() {
	  Assert.assertEquals(toepferei.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(toepferei.getName_15_min(), "Kleine Töpfe");
  }
  
  @Test
  public void toepferei_produziert_in_1_stunde_gefaesse() {
	  Assert.assertEquals(toepferei.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(toepferei.getName_1_h(), "Gefäße");
  }
  
  @Test
  public void toepferei_produziert_in_4_stunden_kanne() {
	  Assert.assertEquals(toepferei.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(toepferei.getName_4_h(), "Kanne");
  }
  
  @Test
  public void toepferei_produziert_in_8_stunden_amphore() {
	  Assert.assertEquals(toepferei.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(toepferei.getName_8_h(), "Amphore");
  }
  
  @Test
  public void toepferei_produziert_in_1_tag_krug() {
	  Assert.assertEquals(toepferei.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(toepferei.getName_1_t(), "Krug");
  }
  
  @Test
  public void toepferei_ist_normales_gebaeude() {
	  Assert.assertEquals(toepferei.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(toepferei.getGebaeude_art(), "Normal");
  }

}
