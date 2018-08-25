package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Metzgerei;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class MetzgereiTest {
	
	private Metzgerei metzgerei;
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
		String dsn = "ressource/main/xml/metzgerei1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Metzgerei wurde nicht gefunden!");
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
		
		metzgerei = new Metzgerei(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t);
	           
  }
  
  @Test
  public void name_muss_metzgerei_sein() {
	  Assert.assertEquals(metzgerei.getName(), name);
	  Assert.assertEquals(metzgerei.getName(), "Metzgerei");
  }
  
  @Test
  public void zeitalter_muss_eisenzeit_sein() {
	  Assert.assertEquals(metzgerei.getZeitalter(), zeitalter);
	  Assert.assertEquals(metzgerei.getZeitalter(), "Eisenzeit");
  }
  
  @Test
  public void metzgerei_kostet_3977_muenzen() {
	  Assert.assertEquals(metzgerei.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(metzgerei.getMuenzen().intValue(), 3977);
  }
  
  @Test
  public void metzgerei_kostest_397_werkzeug() {
	  Assert.assertEquals(metzgerei.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(metzgerei.getWerkzeug().intValue(), 397);
  }
  
  @Test
  public void metzgerei_kostet_keine_daimanten() {
	  Assert.assertEquals(metzgerei.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(metzgerei.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void metzgerei_benötigt_66_personen() {
	  Assert.assertEquals(metzgerei.getPersonen().intValue(), personen);
	  Assert.assertEquals(metzgerei.getPersonen().intValue(), 66);
  }
  
  @Test
  public void metzgerei_ist_4_lang() {
	  Assert.assertEquals(metzgerei.getLaenge().intValue(), laenge);
	  Assert.assertEquals(metzgerei.getLaenge().intValue(), 4);
  }
  
  @Test
  public void metzgerei_ist_3_breit() {
	  Assert.assertEquals(metzgerei.getBreite().intValue(), breite);
	  Assert.assertEquals(metzgerei.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_metzgerei_ist_1_Stunde_10_minuten() {
	  Assert.assertEquals(metzgerei.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(metzgerei.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(metzgerei.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(metzgerei.getBauzeit().get(Calendar.MINUTE), 10);
	  Assert.assertEquals(metzgerei.getBauzeit().get(Calendar.HOUR), 1);
	  Assert.assertEquals(metzgerei.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void metzgerei_benoetigt_strasse() {
	  Assert.assertEquals(metzgerei.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(metzgerei.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void metzgerei_produziert_in_5_minuten_30_werkzeug() {
	  Assert.assertEquals(metzgerei.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(metzgerei.getIn_5_Minuten().intValue(), 30);
  }
  
  @Test
  public void metzgerei_produziert_in_15_minuten_70_werkzeug() {
	  Assert.assertEquals(metzgerei.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(metzgerei.getIn_15_Minuten().intValue(), 70);
  }
  
  @Test
  public void metzgerei_produziert_in_1_stunde_160_werkzeug() {
	  Assert.assertEquals(metzgerei.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(metzgerei.getIn_1_Stunde().intValue(), 160);
  }
  
  @Test
  public void metzgerei_produziert_in_4_stunden_260_werkzeug() {
	  Assert.assertEquals(metzgerei.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(metzgerei.getIn_4_Stunden().intValue(), 260);
  }
  
  @Test
  public void metzgerei_produziert_in_8_stunden_400_werkzeug() {
	  Assert.assertEquals(metzgerei.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(metzgerei.getIn_8_Stunden().intValue(), 400);
  }
  
  @Test
  public void metzgerei_produziert_in_1_tag_790_werkzeug() {
	  Assert.assertEquals(metzgerei.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(metzgerei.getIn_1_Tag().intValue(), 790);
  }
  
  @Test
  public void metzgerei_produziert_in_5_minuten_schinken() {
	  Assert.assertEquals(metzgerei.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(metzgerei.getName_5_min(), "Schinken");
  }
  
  @Test
  public void metzgerei_produziert_in_15_minuten_gewuerfeltes_kochfleisch() {
	  Assert.assertEquals(metzgerei.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(metzgerei.getName_15_min(), "Gewürfeltes Kochfleisch");
  }
  
  @Test
  public void metzgerei_produziert_in_1_stunde_rippchen() {
	  Assert.assertEquals(metzgerei.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(metzgerei.getName_1_h(), "Rippchen");
  }
  
  @Test
  public void metzgerei_produziert_in_4_stunden_steak() {
	  Assert.assertEquals(metzgerei.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(metzgerei.getName_4_h(), "Steak");
  }
  
  @Test
  public void metzgerei_produziert_in_8_stunden_braten() {
	  Assert.assertEquals(metzgerei.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(metzgerei.getName_8_h(), "Braten");
  }
  
  @Test
  public void metzgerei_produziert_in_1_tag_fleischspiess() {
	  Assert.assertEquals(metzgerei.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(metzgerei.getName_1_t(), "Fleischspieß");
  }
  
 

}
