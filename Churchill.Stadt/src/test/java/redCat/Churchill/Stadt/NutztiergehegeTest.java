package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Nutztiergehege;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class NutztiergehegeTest {
	
	private Nutztiergehege nutztiergehege;
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
		String dsn = "ressource/main/xml/nutztiergehege1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Nutztiergehege wurde nicht gefunden!");
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
		
		nutztiergehege = new Nutztiergehege(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_Nutztiergehege_sein() {
	  Assert.assertEquals(nutztiergehege.getName(), name);
	  Assert.assertEquals(nutztiergehege.getName(), "Nutztiergehege");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(nutztiergehege.getZeitalter(), zeitalter);
	  Assert.assertEquals(nutztiergehege.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void Nutztiergehege_kostet_0_muenzen() {
	  Assert.assertEquals(nutztiergehege.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(nutztiergehege.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void Nutztiergehege_kostest_0_werkzeug() {
	  Assert.assertEquals(nutztiergehege.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(nutztiergehege.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void Nutztiergehege_kostet_200_daimanten() {
	  Assert.assertEquals(nutztiergehege.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(nutztiergehege.getDiamanten().intValue(), 200);
  }
  
  @Test
  public void Nutztiergehege_benötigt_40_personen() {
	  Assert.assertEquals(nutztiergehege.getPersonen().intValue(), personen);
	  Assert.assertEquals(nutztiergehege.getPersonen().intValue(), 40);
  }
  
  @Test
  public void Nutztiergehege_ist_4_lang() {
	  Assert.assertEquals(nutztiergehege.getLaenge().intValue(), laenge);
	  Assert.assertEquals(nutztiergehege.getLaenge().intValue(), 4);
  }
  
  @Test
  public void Nutztiergehege_ist_4_breit() {
	  Assert.assertEquals(nutztiergehege.getBreite().intValue(), breite);
	  Assert.assertEquals(nutztiergehege.getBreite().intValue(), 4);
  }
  
  @Test
  public void bauzeit_Nutztiergehege_ist_20_sec() {
	  Assert.assertEquals(nutztiergehege.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(nutztiergehege.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(nutztiergehege.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(nutztiergehege.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void Nutztiergehege_benoetigt_strasse() {
	  Assert.assertEquals(nutztiergehege.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(nutztiergehege.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void Nutztiergehege_produziert_in_5_minuten_68_werkzeug() {
	  Assert.assertEquals(nutztiergehege.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(nutztiergehege.getIn_5_Minuten().intValue(), 68);
  }
  
  @Test
  public void Nutztiergehege_produziert_in_15_minuten_171_werkzeug() {
	  Assert.assertEquals(nutztiergehege.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(nutztiergehege.getIn_15_Minuten().intValue(), 171);
  }
  
  @Test
  public void Nutztiergehege_produziert_in_1_stunde_411_werkzeug() {
	  Assert.assertEquals(nutztiergehege.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(nutztiergehege.getIn_1_Stunde().intValue(), 411);
  }
  
  @Test
  public void Nutztiergehege_produziert_in_4_stunden_684_werkzeug() {
	  Assert.assertEquals(nutztiergehege.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(nutztiergehege.getIn_4_Stunden().intValue(), 684);
  }
  
  @Test
  public void Nutztiergehege_produziert_in_8_stunden_1027_werkzeug() {
	  Assert.assertEquals(nutztiergehege.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(nutztiergehege.getIn_8_Stunden().intValue(), 1027);
  }
  
  @Test
  public void Nutztiergehege_produziert_in_1_tag_2053_werkzeug() {
	  Assert.assertEquals(nutztiergehege.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(nutztiergehege.getIn_1_Tag().intValue(), 2053);
  }
  
  @Test
  public void Nutztiergehege_produziert_in_5_minuten_huhn() {
	  Assert.assertEquals(nutztiergehege.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(nutztiergehege.getName_5_min(), "Huhn");
  }
  
  @Test
  public void Nutztiergehege_produziert_in_15_minuten_ziege() {
	  Assert.assertEquals(nutztiergehege.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(nutztiergehege.getName_15_min(), "Ziege");
  }
  
  @Test
  public void Nutztiergehege_produziert_in_1_stunde_schaf() {
	  Assert.assertEquals(nutztiergehege.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(nutztiergehege.getName_1_h(), "Schaf");
  }
  
  @Test
  public void Nutztiergehege_produziert_in_4_stunden_pferd() {
	  Assert.assertEquals(nutztiergehege.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(nutztiergehege.getName_4_h(), "Pferd");
  }
  
  @Test
  public void Nutztiergehege_produziert_in_8_stunden_stier() {
	  Assert.assertEquals(nutztiergehege.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(nutztiergehege.getName_8_h(), "Stier");
  }
  
  @Test
  public void Nutztiergehege_produziert_in_1_tag_wolf() {
	  Assert.assertEquals(nutztiergehege.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(nutztiergehege.getName_1_t(), "Wolf");
  }
  
  @Test
  public void nutztiergehege_ist_diamant_gebaeude() {
	  Assert.assertEquals(nutztiergehege.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(nutztiergehege.getGebaeude_art(), "Diamant");
  }

}
