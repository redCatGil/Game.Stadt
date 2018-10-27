package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Gewuerzhandlung;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class GewuerzhandlungTest {
	
	private Gewuerzhandlung gewuerzhandlung;
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
		String dsn = "ressource/main/xml/gewuerzhandlung1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Gewürzhandlung wurde nicht gefunden!");
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
		
		gewuerzhandlung = new Gewuerzhandlung(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_gewuerzhandlung_sein() {
	  Assert.assertEquals(gewuerzhandlung.getName(), name);
	  Assert.assertEquals(gewuerzhandlung.getName(), "Gewürzhandlung");
  }
  
  @Test
  public void zeitalter_muss_spaetes_mittelalter_sein() {
	  Assert.assertEquals(gewuerzhandlung.getZeitalter(), zeitalter);
	  Assert.assertEquals(gewuerzhandlung.getZeitalter(), "Spaetes_Mittelalter");
  }
  
  @Test
  public void gewuerzhandlung_kostet_0_muenzen() {
	  Assert.assertEquals(gewuerzhandlung.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(gewuerzhandlung.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void gewuerzhandlung_kostest_0_werkzeug() {
	  Assert.assertEquals(gewuerzhandlung.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(gewuerzhandlung.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void gewuerzhandlung_kostet_500_daimanten() {
	  Assert.assertEquals(gewuerzhandlung.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(gewuerzhandlung.getDiamanten().intValue(), 500);
  }
  
  @Test
  public void gewuerzhandlung_benötigt_86_personen() {
	  Assert.assertEquals(gewuerzhandlung.getPersonen().intValue(), personen);
	  Assert.assertEquals(gewuerzhandlung.getPersonen().intValue(), 86);
  }
  
  @Test
  public void gewuerzhandlung_ist_3_lang() {
	  Assert.assertEquals(gewuerzhandlung.getLaenge().intValue(), laenge);
	  Assert.assertEquals(gewuerzhandlung.getLaenge().intValue(), 3);
  }
  
  @Test
  public void gewuerzhandlung_ist_3_breit() {
	  Assert.assertEquals(gewuerzhandlung.getBreite().intValue(), breite);
	  Assert.assertEquals(gewuerzhandlung.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_gewuerzhandlung_ist_20_sekunden() {
	  Assert.assertEquals(gewuerzhandlung.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(gewuerzhandlung.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(gewuerzhandlung.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(gewuerzhandlung.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(gewuerzhandlung.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(gewuerzhandlung.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void gewuerzhandlung_benoetigt_strasse() {
	  Assert.assertEquals(gewuerzhandlung.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(gewuerzhandlung.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_5_minuten_120_werkzeug() {
	  Assert.assertEquals(gewuerzhandlung.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(gewuerzhandlung.getIn_5_Minuten().intValue(), 120);
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_15_minuten_310_werkzeug() {
	  Assert.assertEquals(gewuerzhandlung.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(gewuerzhandlung.getIn_15_Minuten().intValue(), 310);
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_1_stunde_730_werkzeug() {
	  Assert.assertEquals(gewuerzhandlung.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(gewuerzhandlung.getIn_1_Stunde().intValue(), 730);
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_4_stunden_1220_werkzeug() {
	  Assert.assertEquals(gewuerzhandlung.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(gewuerzhandlung.getIn_4_Stunden().intValue(), 1220);
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_8_stunden_1830_werkzeug() {
	  Assert.assertEquals(gewuerzhandlung.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(gewuerzhandlung.getIn_8_Stunden().intValue(), 1830);
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_1_tag_3660_werkzeug() {
	  Assert.assertEquals(gewuerzhandlung.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(gewuerzhandlung.getIn_1_Tag().intValue(), 3660);
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_5_minuten_zimt() {
	  Assert.assertEquals(gewuerzhandlung.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(gewuerzhandlung.getName_5_min(), "Zimt");
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_15_minuten_chillil() {
	  Assert.assertEquals(gewuerzhandlung.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(gewuerzhandlung.getName_15_min(), "Chilli");
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_1_stunde_ingwer() {
	  Assert.assertEquals(gewuerzhandlung.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(gewuerzhandlung.getName_1_h(), "Ingwer");
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_4_stunden_pfeffer() {
	  Assert.assertEquals(gewuerzhandlung.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(gewuerzhandlung.getName_4_h(), "Pfeffer");
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_8_stunden_muskatnuss() {
	  Assert.assertEquals(gewuerzhandlung.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(gewuerzhandlung.getName_8_h(), "Muskatnuss");
  }
  
  @Test
  public void gewuerzhandlung_produziert_in_1_tag_nelke() {
	  Assert.assertEquals(gewuerzhandlung.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(gewuerzhandlung.getName_1_t(), "Nelke");
  }
  
  @Test
  public void gewuerzhandlung_ist_diamant_gebaeude() {
	  Assert.assertEquals(gewuerzhandlung.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(gewuerzhandlung.getGebaeude_art(), "Diamant");
  }

}
