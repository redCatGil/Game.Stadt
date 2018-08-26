package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.Ziegenzucht;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class ZiegenzuchtTest {
	
	private Ziegenzucht ziegenzucht;
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
		String dsn = "ressource/main/xml/ziegenzucht1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Ziegenzucht wurde nicht gefunden!");
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
		
		ziegenzucht = new Ziegenzucht(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_ziegenzucht_sein() {
	  Assert.assertEquals(ziegenzucht.getName(), name);
	  Assert.assertEquals(ziegenzucht.getName(), "Ziegenzucht");
  }
  
  @Test
  public void zeitalter_muss_eisenzeit_sein() {
	  Assert.assertEquals(ziegenzucht.getZeitalter(), zeitalter);
	  Assert.assertEquals(ziegenzucht.getZeitalter(), "Eisenzeit");
  }
  
  @Test
  public void ziegenzucht_kostet_4800_muenzen() {
	  Assert.assertEquals(ziegenzucht.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(ziegenzucht.getMuenzen().intValue(), 4800);
  }
  
  @Test
  public void ziegenzucht_kostest_680_werkzeug() {
	  Assert.assertEquals(ziegenzucht.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(ziegenzucht.getWerkzeug().intValue(), 680);
  }
  
  @Test
  public void ziegenzucht_kostet_keine_daimanten() {
	  Assert.assertEquals(ziegenzucht.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(ziegenzucht.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void ziegenzucht_benötigt_122_personen() {
	  Assert.assertEquals(ziegenzucht.getPersonen().intValue(), personen);
	  Assert.assertEquals(ziegenzucht.getPersonen().intValue(), 122);
  }
  
  @Test
  public void ziegenzucht_ist_4_lang() {
	  Assert.assertEquals(ziegenzucht.getLaenge().intValue(), laenge);
	  Assert.assertEquals(ziegenzucht.getLaenge().intValue(), 4);
  }
  
  @Test
  public void ziegenzucht_ist_5_breit() {
	  Assert.assertEquals(ziegenzucht.getBreite().intValue(), breite);
	  Assert.assertEquals(ziegenzucht.getBreite().intValue(), 5);
  }
  
  @Test
  public void bauzeit_ziegenzucht_ist_1_stunde_40_minuten() {
	  Assert.assertEquals(ziegenzucht.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(ziegenzucht.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(ziegenzucht.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(ziegenzucht.getBauzeit().get(Calendar.MINUTE), 40);
	  Assert.assertEquals(ziegenzucht.getBauzeit().get(Calendar.HOUR), 1);
	  Assert.assertEquals(ziegenzucht.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void ziegenzucht_benoetigt_strasse() {
	  Assert.assertEquals(ziegenzucht.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(ziegenzucht.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void ziegenzucht_produziert_in_5_minuten_40_werkzeug() {
	  Assert.assertEquals(ziegenzucht.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(ziegenzucht.getIn_5_Minuten().intValue(), 40);
  }
  
  @Test
  public void ziegenzucht_produziert_in_15_minuten_90_werkzeug() {
	  Assert.assertEquals(ziegenzucht.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(ziegenzucht.getIn_15_Minuten().intValue(), 90);
  }
  
  @Test
  public void ziegenzucht_produziert_in_1_stunde_220_werkzeug() {
	  Assert.assertEquals(ziegenzucht.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(ziegenzucht.getIn_1_Stunde().intValue(), 220);
  }
  
  @Test
  public void ziegenzucht_produziert_in_4_stunden_360_werkzeug() {
	  Assert.assertEquals(ziegenzucht.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(ziegenzucht.getIn_4_Stunden().intValue(), 360);
  }
  
  @Test
  public void ziegenzucht_produziert_in_8_stunden_540_werkzeug() {
	  Assert.assertEquals(ziegenzucht.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(ziegenzucht.getIn_8_Stunden().intValue(), 540);
  }
  
  @Test
  public void ziegenzucht_produziert_in_1_tag_1080_werkzeug() {
	  Assert.assertEquals(ziegenzucht.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(ziegenzucht.getIn_1_Tag().intValue(), 1080);
  }
  
  @Test
  public void ziegenzucht_produziert_in_5_minuten_1_6_kaeserad() {
	  Assert.assertEquals(ziegenzucht.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(ziegenzucht.getName_5_min(), "Ein Sechstel eines Käserades");
  }
  
  @Test
  public void ziegenzucht_produziert_in_15_minuten_1_3_kaeserad() {
	  Assert.assertEquals(ziegenzucht.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(ziegenzucht.getName_15_min(), "Ein Drittel eines Käserades");
  }
  
  @Test
  public void ziegenzucht_produziert_in_1_stunde_1_2_kaeserad() {
	  Assert.assertEquals(ziegenzucht.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(ziegenzucht.getName_1_h(), "Ein halbes Käserad");
  }
  
  @Test
  public void ziegenzucht_produziert_in_4_stunden_2_3_kaeserad() {
	  Assert.assertEquals(ziegenzucht.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(ziegenzucht.getName_4_h(), "Zwei Drittel eines Käserades");
  }
  
  @Test
  public void ziegenzucht_produziert_in_8_stunden_5_6_kaeserad() {
	  Assert.assertEquals(ziegenzucht.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(ziegenzucht.getName_8_h(), "Fünf Sechstel eines Käserades");
  }
  
  @Test
  public void ziegenzucht_produziert_in_1_tag_ganzes_kaeserad() {
	  Assert.assertEquals(ziegenzucht.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(ziegenzucht.getName_1_t(), "Ein ganzes Käserad");
  }
  
  @Test
  public void ziegenzucht_ist_normales_gebaeude() {
	  Assert.assertEquals(ziegenzucht.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(ziegenzucht.getGebaeude_art(), "Normal");
  }

}
