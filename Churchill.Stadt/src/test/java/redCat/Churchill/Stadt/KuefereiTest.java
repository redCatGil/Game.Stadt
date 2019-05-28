package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Kueferei;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class KuefereiTest {
	
	private Kueferei kueferei;
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
		String dsn = "ressource/main/xml/kueferei1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Küferei wurde nicht gefunden!");
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
		//Küferei init
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
		
		kueferei = new Kueferei(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_kueferei_sein() {
	  Assert.assertEquals(kueferei.getName(), name);
	  Assert.assertEquals(kueferei.getName(), "Küferei");
  }
  
  @Test
  public void zeitalter_muss_spaetes_mittelalter_sein() {
	  Assert.assertEquals(kueferei.getZeitalter(), zeitalter);
	  Assert.assertEquals(kueferei.getZeitalter(), "Spaetes_Mittelalter");
  }
  
  @Test
  public void kueferei_kostet_6100_muenzen() {
	  Assert.assertEquals(kueferei.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(kueferei.getMuenzen().intValue(), 61000);
  }
  
  @Test
  public void kueferei_kostest_10800_werkzeug() {
	  Assert.assertEquals(kueferei.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(kueferei.getWerkzeug().intValue(), 10800);
  }
  
  @Test
  public void kueferei_kostet_keine_daimanten() {
	  Assert.assertEquals(kueferei.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(kueferei.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void kueferei_benoetigt_164_personen() {
	  Assert.assertEquals(kueferei.getPersonen().intValue(), personen);
	  Assert.assertEquals(kueferei.getPersonen().intValue(), 164);
  }
  
  @Test
  public void kueferei_ist_3_lang() {
	  Assert.assertEquals(kueferei.getLaenge().intValue(), laenge);
	  Assert.assertEquals(kueferei.getLaenge().intValue(), 3);
  }
  
  @Test
  public void kueferei_ist_4_breit() {
	  Assert.assertEquals(kueferei.getBreite().intValue(), breite);
	  Assert.assertEquals(kueferei.getBreite().intValue(), 4);
  }
  
  @Test
  public void bauzeit_kueferei_ist_10_stunden_30_minuten() {
	  Assert.assertEquals(kueferei.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(kueferei.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(kueferei.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(kueferei.getBauzeit().get(Calendar.MINUTE), 30);
	  Assert.assertEquals(kueferei.getBauzeit().get(Calendar.HOUR), 10);
	  Assert.assertEquals(kueferei.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void kueferei_benoetigt_strasse() {
	  Assert.assertEquals(kueferei.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(kueferei.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void kueferei_produziert_in_5_minuten_70_werkzeug() {
	  Assert.assertEquals(kueferei.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(kueferei.getIn_5_Minuten().intValue(), 80);
  }
  
  @Test
  public void kueferei_produziert_in_15_minuten_200_werkzeug() {
	  Assert.assertEquals(kueferei.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(kueferei.getIn_15_Minuten().intValue(), 200);
  }
  
  @Test
  public void kueferei_produziert_in_1_stunde_490_werkzeug() {
	  Assert.assertEquals(kueferei.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(kueferei.getIn_1_Stunde().intValue(), 490);
  }
  
  @Test
  public void kueferei_produziert_in_4_stunden_810_werkzeug() {
	  Assert.assertEquals(kueferei.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(kueferei.getIn_4_Stunden().intValue(), 810);
  }
  
  @Test
  public void kueferei_produziert_in_8_stunden_1220_werkzeug() {
	  Assert.assertEquals(kueferei.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(kueferei.getIn_8_Stunden().intValue(), 1220);
  }
  
  @Test
  public void kueferei_produziert_in_1_tag_2440_werkzeug() {
	  Assert.assertEquals(kueferei.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(kueferei.getIn_1_Tag().intValue(), 2440);
  }
  
  @Test
  public void kueferei_produziert_in_5_minuten_verschlag() {
	  Assert.assertEquals(kueferei.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(kueferei.getName_5_min(), "Verschlag");
  }
  
  @Test
  public void kueferei_produziert_in_15_minuten_karrenrad() {
	  Assert.assertEquals(kueferei.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(kueferei.getName_15_min(), "Karrenrad");
  }
  
  @Test
  public void kueferei_produziert_in_1_stunde_korb() {
	  Assert.assertEquals(kueferei.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(kueferei.getName_1_h(), "Korb");
  }
  
  @Test
  public void kueferei_produziert_in_4_stunden_fass() {
	  Assert.assertEquals(kueferei.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(kueferei.getName_4_h(), "Fass");
  }
  
  @Test
  public void kueferei_produziert_in_8_stunden_kiste() {
	  Assert.assertEquals(kueferei.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(kueferei.getName_8_h(), "Kiste");
  }
  
  @Test
  public void kueferei_produziert_in_1_tag_futterkrippe() {
	  Assert.assertEquals(kueferei.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(kueferei.getName_1_t(), "Futterkrippe");
  }
  
  @Test
  public void kueferei_ist_normales_gebaeude() {
	  Assert.assertEquals(kueferei.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(kueferei.getGebaeude_art(), "Normal");
  }

}
