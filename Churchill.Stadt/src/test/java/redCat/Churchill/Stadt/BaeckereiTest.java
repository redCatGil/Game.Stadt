package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Baeckerei;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class BaeckereiTest {
	
	private Baeckerei baeckerei;
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
		String dsn = "ressource/main/xml/baeckerei1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Bäckerei wurde nicht gefunden!");
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
		
		baeckerei = new Baeckerei(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_baeckerei_sein() {
	  Assert.assertEquals(baeckerei.getName(), name);
	  Assert.assertEquals(baeckerei.getName(), "Bäckerei");
  }
  
  @Test
  public void zeitalter_muss_fruehes_mittelalter_sein() {
	  Assert.assertEquals(baeckerei.getZeitalter(), zeitalter);
	  Assert.assertEquals(baeckerei.getZeitalter(), "Fruehes_Mittelalter");
  }
  
  @Test
  public void baeckerei_kostet_0_muenzen() {
	  Assert.assertEquals(baeckerei.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(baeckerei.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void baeckerei_kostest_0_werkzeug() {
	  Assert.assertEquals(baeckerei.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(baeckerei.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void baeckerei_kostet_400_daimanten() {
	  Assert.assertEquals(baeckerei.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(baeckerei.getDiamanten().intValue(), 400);
  }
  
  @Test
  public void baeckerei_benötigt_103_personen() {
	  Assert.assertEquals(baeckerei.getPersonen().intValue(), personen);
	  Assert.assertEquals(baeckerei.getPersonen().intValue(), 103);
  }
  
  @Test
  public void baeckerei_ist_4_lang() {
	  Assert.assertEquals(baeckerei.getLaenge().intValue(), laenge);
	  Assert.assertEquals(baeckerei.getLaenge().intValue(), 4);
  }
  
  @Test
  public void baeckerei_ist_3_breit() {
	  Assert.assertEquals(baeckerei.getBreite().intValue(), breite);
	  Assert.assertEquals(baeckerei.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_baeckerei_ist_20_sekunden() {
	  Assert.assertEquals(baeckerei.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(baeckerei.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(baeckerei.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(baeckerei.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(baeckerei.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(baeckerei.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void baeckerei_benoetigt_strasse() {
	  Assert.assertEquals(baeckerei.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(baeckerei.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void baeckerei_produziert_in_5_minuten_80_werkzeug() {
	  Assert.assertEquals(baeckerei.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(baeckerei.getIn_5_Minuten().intValue(), 80);
  }
  
  @Test
  public void baeckerei_produziert_in_15_minuten_200_werkzeug() {
	  Assert.assertEquals(baeckerei.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(baeckerei.getIn_15_Minuten().intValue(), 200);
  }
  
  @Test
  public void baeckerei_produziert_in_1_stunde_480_werkzeug() {
	  Assert.assertEquals(baeckerei.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(baeckerei.getIn_1_Stunde().intValue(), 480);
  }
  
  @Test
  public void baeckerei_produziert_in_4_stunden_800_werkzeug() {
	  Assert.assertEquals(baeckerei.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(baeckerei.getIn_4_Stunden().intValue(), 800);
  }
  
  @Test
  public void baeckerei_produziert_in_8_stunden_1200_werkzeug() {
	  Assert.assertEquals(baeckerei.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(baeckerei.getIn_8_Stunden().intValue(), 1200);
  }
  
  @Test
  public void baeckerei_produziert_in_1_tag_2400_werkzeug() {
	  Assert.assertEquals(baeckerei.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(baeckerei.getIn_1_Tag().intValue(), 2400);
  }
  
  @Test
  public void baeckerei_produziert_in_5_minuten_kuchen() {
	  Assert.assertEquals(baeckerei.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(baeckerei.getName_5_min(), "Kuchen");
  }
  
  @Test
  public void baeckerei_produziert_in_15_minuten_baguettes() {
	  Assert.assertEquals(baeckerei.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(baeckerei.getName_15_min(), "Baguettes");
  }
  
  @Test
  public void baeckerei_produziert_in_1_stunde_brezel() {
	  Assert.assertEquals(baeckerei.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(baeckerei.getName_1_h(), "Brezel");
  }
  
  @Test
  public void baeckerei_produziert_in_4_stunden_croissant() {
	  Assert.assertEquals(baeckerei.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(baeckerei.getName_4_h(), "Croissant");
  }
  
  @Test
  public void baeckerei_produziert_in_8_stunden_brot() {
	  Assert.assertEquals(baeckerei.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(baeckerei.getName_8_h(), "Brot");
  }
  
  @Test
  public void baeckerei_produziert_in_1_tag_broetchen() {
	  Assert.assertEquals(baeckerei.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(baeckerei.getName_1_t(), "Brötchen");
  }
  
  @Test
  public void baeckerei_ist_diamant_gebaeude() {
	  Assert.assertEquals(baeckerei.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(baeckerei.getGebaeude_art(), "Diamant");
  }

}
