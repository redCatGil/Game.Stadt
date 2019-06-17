package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Parfuem_Destillerie;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.TimeZone;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class Parfuem_DestillerieTest1 {
	
	private Parfuem_Destillerie parfuemdestillerie;
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
		String dsn = "ressource/main/xml/parfuemdestillerie1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Parfüm-Destillerie wurde nicht gefunden!");
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
		//Parfüm-Destillerie init
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
		
		parfuemdestillerie = new Parfuem_Destillerie(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_parfuem_destillerie_sein() {
	  Assert.assertEquals(parfuemdestillerie.getName(), name);
	  Assert.assertEquals(parfuemdestillerie.getName(), "Parfüm-Destillerie");
  }
  
  @Test
  public void zeitalter_muss_kolonialzeit_sein() {
	  Assert.assertEquals(parfuemdestillerie.getZeitalter(), zeitalter);
	  Assert.assertEquals(parfuemdestillerie.getZeitalter(), "Kolonialzeit");
  }
  
  @Test
  public void parfuem_destillerie_kostet_0_muenzen() {
	  Assert.assertEquals(parfuemdestillerie.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(parfuemdestillerie.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void parfuem_destillerie_kostest_0_werkzeug() {
	  Assert.assertEquals(parfuemdestillerie.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(parfuemdestillerie.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void parfuem_destillerie_kostet_500_daimanten() {
	  Assert.assertEquals(parfuemdestillerie.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(parfuemdestillerie.getDiamanten().intValue(), 500);
  }
  
  @Test
  public void parfuem_destillerie_benötigt_78_personen() {
	  Assert.assertEquals(parfuemdestillerie.getPersonen().intValue(), personen);
	  Assert.assertEquals(parfuemdestillerie.getPersonen().intValue(), 78);
  }
  
  @Test
  public void parfuem_destillerie_ist_3_lang() {
	  Assert.assertEquals(parfuemdestillerie.getLaenge().intValue(), laenge);
	  Assert.assertEquals(parfuemdestillerie.getLaenge().intValue(), 3);
  }
  
  @Test
  public void parfuem_destillerie_ist_2_breit() {
	  Assert.assertEquals(parfuemdestillerie.getBreite().intValue(), breite);
	  Assert.assertEquals(parfuemdestillerie.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_parfuem_destillerie_ist_20_sekunden() {
	  Calendar cal =Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
	  cal.setTime(parfuemdestillerie.getpBauzeit());
	  Assert.assertEquals(cal.get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(cal.get(Calendar.MINUTE), 0);
	  Assert.assertEquals(cal.get(Calendar.HOUR), 0);
	  Assert.assertEquals(cal.get(Calendar.SECOND), 20);
  }
  
  @Test
  public void parfuem_destillerie_benoetigt_strasse() {
	  Assert.assertEquals(parfuemdestillerie.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(parfuemdestillerie.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_5_minuten_100_werkzeug() {
	  Assert.assertEquals(parfuemdestillerie.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(parfuemdestillerie.getIn_5_Minuten().intValue(), 100);
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_15_minuten_260_werkzeug() {
	  Assert.assertEquals(parfuemdestillerie.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(parfuemdestillerie.getIn_15_Minuten().intValue(), 260);
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_1_stunde_620_werkzeug() {
	  Assert.assertEquals(parfuemdestillerie.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(parfuemdestillerie.getIn_1_Stunde().intValue(), 620);
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_4_stunden_1030_werkzeug() {
	  Assert.assertEquals(parfuemdestillerie.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(parfuemdestillerie.getIn_4_Stunden().intValue(), 1030);
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_8_stunden_1550_werkzeug() {
	  Assert.assertEquals(parfuemdestillerie.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(parfuemdestillerie.getIn_8_Stunden().intValue(), 1550);
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_1_tag_3100_werkzeug() {
	  Assert.assertEquals(parfuemdestillerie.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(parfuemdestillerie.getIn_1_Tag().intValue(), 3100);
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_5_minuten_unbekannt() {
	  Assert.assertEquals(parfuemdestillerie.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(parfuemdestillerie.getName_5_min(), "unbekannt");
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_15_minuten_unbekannt() {
	  Assert.assertEquals(parfuemdestillerie.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(parfuemdestillerie.getName_15_min(), "unbekannt");
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_1_stunde_unbekannt() {
	  Assert.assertEquals(parfuemdestillerie.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(parfuemdestillerie.getName_1_h(), "unbekannt");
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_4_stunden_unbekannt() {
	  Assert.assertEquals(parfuemdestillerie.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(parfuemdestillerie.getName_4_h(), "unbekannt");
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_8_stunden_unbekannt() {
	  Assert.assertEquals(parfuemdestillerie.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(parfuemdestillerie.getName_8_h(), "unbekannt");
  }
  
  @Test
  public void parfuem_destillerie_produziert_in_1_tag_unbekannt() {
	  Assert.assertEquals(parfuemdestillerie.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(parfuemdestillerie.getName_1_t(), "unbekannt");
  }
  
  @Test
  public void parfuem_destillerie_ist_diamant_gebaeude() {
	  Assert.assertEquals(parfuemdestillerie.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(parfuemdestillerie.getGebaeude_art(), "Diamant");
  }

}
