package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Gerberei;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class GerbereiTest {
	
	private Gerberei gerberei;
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
		String dsn = "ressource/main/xml/gerberei1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Gerberei wurde nicht gefunden!");
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
		
		gerberei = new Gerberei(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_gerberei_sein() {
	  Assert.assertEquals(gerberei.getName(), name);
	  Assert.assertEquals(gerberei.getName(), "Gerberei");
  }
  
  @Test
  public void zeitalter_muss_fruehes_mittelalter_sein() {
	  Assert.assertEquals(gerberei.getZeitalter(), zeitalter);
	  Assert.assertEquals(gerberei.getZeitalter(), "Fruehes_Mittelalter");
  }
  
  @Test
  public void gerberei_kostet_7020_muenzen() {
	  Assert.assertEquals(gerberei.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(gerberei.getMuenzen().intValue(), 7020);
  }
  
  @Test
  public void gerberei_kostest_1620_werkzeug() {
	  Assert.assertEquals(gerberei.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(gerberei.getWerkzeug().intValue(), 1620);
  }
  
  @Test
  public void gerberei_kostet_keine_daimanten() {
	  Assert.assertEquals(gerberei.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(gerberei.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void gerberei_benötigt_54_personen() {
	  Assert.assertEquals(gerberei.getPersonen().intValue(), personen);
	  Assert.assertEquals(gerberei.getPersonen().intValue(), 54);
  }
  
  @Test
  public void gerberei_ist_3_lang() {
	  Assert.assertEquals(gerberei.getLaenge().intValue(), laenge);
	  Assert.assertEquals(gerberei.getLaenge().intValue(), 3);
  }
  
  @Test
  public void gerberei_ist_3_breit() {
	  Assert.assertEquals(gerberei.getBreite().intValue(), breite);
	  Assert.assertEquals(gerberei.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_gerberei_ist_3_stunden() {
	  Assert.assertEquals(gerberei.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(gerberei.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(gerberei.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(gerberei.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(gerberei.getBauzeit().get(Calendar.HOUR), 3);
	  Assert.assertEquals(gerberei.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void gerberei_benoetigt_strasse() {
	  Assert.assertEquals(gerberei.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(gerberei.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void gerberei_produziert_in_5_minuten_30_werkzeug() {
	  Assert.assertEquals(gerberei.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(gerberei.getIn_5_Minuten().intValue(), 30);
  }
  
  @Test
  public void gerberei_produziert_in_15_minuten_70_werkzeug() {
	  Assert.assertEquals(gerberei.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(gerberei.getIn_15_Minuten().intValue(), 70);
  }
  
  @Test
  public void gerberei_produziert_in_1_stunde_160_werkzeug() {
	  Assert.assertEquals(gerberei.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(gerberei.getIn_1_Stunde().intValue(), 160);
  }
  
  @Test
  public void gerberei_produziert_in_4_stunden_270_werkzeug() {
	  Assert.assertEquals(gerberei.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(gerberei.getIn_4_Stunden().intValue(), 270);
  }
  
  @Test
  public void gerberei_produziert_in_8_stunden_410_werkzeug() {
	  Assert.assertEquals(gerberei.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(gerberei.getIn_8_Stunden().intValue(), 410);
  }
  
  @Test
  public void gerberei_produziert_in_1_tag_810_werkzeug() {
	  Assert.assertEquals(gerberei.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(gerberei.getIn_1_Tag().intValue(), 810);
  }
  
  @Test
  public void gerberei_produziert_in_5_minuten_Ziegenfell() {
	  Assert.assertEquals(gerberei.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(gerberei.getName_5_min(), "Ziegenfell");
  }
  
  @Test
  public void gerberei_produziert_in_15_minuten_Schweinehaut() {
	  Assert.assertEquals(gerberei.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(gerberei.getName_15_min(), "Schweinehaut");
  }
  
  @Test
  public void gerberei_produziert_in_1_stunde_wildfell() {
	  Assert.assertEquals(gerberei.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(gerberei.getName_1_h(), "Wildfell");
  }
  
  @Test
  public void gerberei_produziert_in_4_stunden_hasenfell() {
	  Assert.assertEquals(gerberei.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(gerberei.getName_4_h(), "Hasenfell");
  }
  
  @Test
  public void gerberei_produziert_in_8_stunden_waschbaerpelz() {
	  Assert.assertEquals(gerberei.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(gerberei.getName_8_h(), "Waschbärpelz");
  }
  
  @Test
  public void gerberei_produziert_in_1_tag_baerenhaut() {
	  Assert.assertEquals(gerberei.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(gerberei.getName_1_t(), "Bärenhaut");
  }
  
  @Test
  public void gerberei_ist_normales_gebaeude() {
	  Assert.assertEquals(gerberei.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(gerberei.getGebaeude_art(), "Normal");
  }

}
