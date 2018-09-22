package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.Windmuehle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class WindmuehleTest {
	
	private Windmuehle windmuehle;
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
		String dsn = "ressource/main/xml/windmuehle1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Windmühle wurde nicht gefunden!");
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
		
		windmuehle = new Windmuehle(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_windmuehle_sein() {
	  Assert.assertEquals(windmuehle.getName(), name);
	  Assert.assertEquals(windmuehle.getName(), "Windmühle");
  }
  
  @Test
  public void zeitalter_muss_hochmittelalter_sein() {
	  Assert.assertEquals(windmuehle.getZeitalter(), zeitalter);
	  Assert.assertEquals(windmuehle.getZeitalter(), "Hochmittelalter");
  }
  
  @Test
  public void windmuehle_kostet_0_muenzen() {
	  Assert.assertEquals(windmuehle.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(windmuehle.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void windmuehle_kostest_0_werkzeug() {
	  Assert.assertEquals(windmuehle.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(windmuehle.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void windmuehle_kostet_500_daimanten() {
	  Assert.assertEquals(windmuehle.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(windmuehle.getDiamanten().intValue(), 500);
  }
  
  @Test
  public void windmuehle_benötigt_148_personen() {
	  Assert.assertEquals(windmuehle.getPersonen().intValue(), personen);
	  Assert.assertEquals(windmuehle.getPersonen().intValue(), 148);
  }
  
  @Test
  public void windmuehle_ist_3_lang() {
	  Assert.assertEquals(windmuehle.getLaenge().intValue(), laenge);
	  Assert.assertEquals(windmuehle.getLaenge().intValue(), 3);
  }
  
  @Test
  public void windmuehle_ist_4_breit() {
	  Assert.assertEquals(windmuehle.getBreite().intValue(), breite);
	  Assert.assertEquals(windmuehle.getBreite().intValue(), 4);
  }
  
  @Test
  public void bauzeit_windmuehle_ist_20_sekunden() {
	  Assert.assertEquals(windmuehle.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(windmuehle.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(windmuehle.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(windmuehle.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(windmuehle.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(windmuehle.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void windmuehle_benoetigt_strasse() {
	  Assert.assertEquals(windmuehle.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(windmuehle.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void windmuehle_produziert_in_5_minuten_130_werkzeug() {
	  Assert.assertEquals(windmuehle.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(windmuehle.getIn_5_Minuten().intValue(), 130);
  }
  
  @Test
  public void windmuehle_produziert_in_15_minuten_320_werkzeug() {
	  Assert.assertEquals(windmuehle.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(windmuehle.getIn_15_Minuten().intValue(), 320);
  }
  
  @Test
  public void windmuehle_produziert_in_1_stunde_770_werkzeug() {
	  Assert.assertEquals(windmuehle.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(windmuehle.getIn_1_Stunde().intValue(), 770);
  }
  
  @Test
  public void windmuehle_produziert_in_4_stunden_1290_werkzeug() {
	  Assert.assertEquals(windmuehle.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(windmuehle.getIn_4_Stunden().intValue(), 1290);
  }
  
  @Test
  public void windmuehle_produziert_in_8_stunden_1930_werkzeug() {
	  Assert.assertEquals(windmuehle.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(windmuehle.getIn_8_Stunden().intValue(), 1930);
  }
  
  @Test
  public void windmuehle_produziert_in_1_tag_3860_werkzeug() {
	  Assert.assertEquals(windmuehle.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(windmuehle.getIn_1_Tag().intValue(), 3860);
  }
  
  @Test
  public void windmuehle_produziert_in_5_minuten_mehl() {
	  Assert.assertEquals(windmuehle.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(windmuehle.getName_5_min(), "Mehl");
  }
  
  @Test
  public void windmuehle_produziert_in_15_minuten_becher_mehl() {
	  Assert.assertEquals(windmuehle.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(windmuehle.getName_15_min(), "Becher Mehl");
  }
  
  @Test
  public void windmuehle_produziert_in_1_stunde_schuessel_mehl() {
	  Assert.assertEquals(windmuehle.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(windmuehle.getName_1_h(), "Schüssel Mehl");
  }
  
  @Test
  public void windmuehle_produziert_in_4_stunden_beutel_mehl() {
	  Assert.assertEquals(windmuehle.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(windmuehle.getName_4_h(), "Beutel Mehl");
  }
  
  @Test
  public void windmuehle_produziert_in_8_stunden_sack_mehl() {
	  Assert.assertEquals(windmuehle.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(windmuehle.getName_8_h(), "Sack Mehl");
  }
  
  @Test
  public void windmuehle_produziert_in_1_tag_grosser_sack_mehl() {
	  Assert.assertEquals(windmuehle.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(windmuehle.getName_1_t(), "großer Sack Mehl");
  }
  
  @Test
  public void windmuehle_ist_diamant_gebaeude() {
	  Assert.assertEquals(windmuehle.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(windmuehle.getGebaeude_art(), "Diamant");
  }

}
