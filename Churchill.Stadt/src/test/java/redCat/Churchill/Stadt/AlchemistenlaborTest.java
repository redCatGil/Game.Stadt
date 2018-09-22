package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Alchemistenlabor;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class AlchemistenlaborTest {
	
	private Alchemistenlabor alchemistenlabor;
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
		String dsn = "ressource/main/xml/alchemistenlabor1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Alchemistenlabor wurde nicht gefunden!");
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
		
		alchemistenlabor = new Alchemistenlabor(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, wz_5_min, wz_15_min, wz_1_h, wz_4_h, wz_8_h, wz_1_t, 
				                  name_prod_5_min, name_prod_15_min, name_prod_1_h, name_prod_4_h, name_prod_8_h, name_prod_1_t, gebaeude_art);
	           
  }
  
  @Test
  public void name_muss_alchemistenlabor_sein() {
	  Assert.assertEquals(alchemistenlabor.getName(), name);
	  Assert.assertEquals(alchemistenlabor.getName(), "Alchemistenlabor");
  }
  
  @Test
  public void zeitalter_muss_Hochmittelalter_sein() {
	  Assert.assertEquals(alchemistenlabor.getZeitalter(), zeitalter);
	  Assert.assertEquals(alchemistenlabor.getZeitalter(), "Hochmittelalter");
  }
  
  @Test
  public void alchemistenlabor_kostet_13950_muenzen() {
	  Assert.assertEquals(alchemistenlabor.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(alchemistenlabor.getMuenzen().intValue(), 13950);
  }
  
  @Test
  public void alchemistenlabor_kostest_2883_werkzeug() {
	  Assert.assertEquals(alchemistenlabor.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(alchemistenlabor.getWerkzeug().intValue(), 2883);
  }
  
  @Test
  public void alchemistenlabor_kostet_keine_daimanten() {
	  Assert.assertEquals(alchemistenlabor.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(alchemistenlabor.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void alchemistenlabor_benötigt_40_personen() {
	  Assert.assertEquals(alchemistenlabor.getPersonen().intValue(), personen);
	  Assert.assertEquals(alchemistenlabor.getPersonen().intValue(), 40);
  }
  
  @Test
  public void alchemistenlabor_ist_3_lang() {
	  Assert.assertEquals(alchemistenlabor.getLaenge().intValue(), laenge);
	  Assert.assertEquals(alchemistenlabor.getLaenge().intValue(), 3);
  }
  
  @Test
  public void alchemistenlabor_ist_2_breit() {
	  Assert.assertEquals(alchemistenlabor.getBreite().intValue(), breite);
	  Assert.assertEquals(alchemistenlabor.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_alchemistenlabor_ist_5_stunde_20_minuten() {
	  Assert.assertEquals(alchemistenlabor.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(alchemistenlabor.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(alchemistenlabor.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(alchemistenlabor.getBauzeit().get(Calendar.MINUTE), 20);
	  Assert.assertEquals(alchemistenlabor.getBauzeit().get(Calendar.HOUR), 5);
	  Assert.assertEquals(alchemistenlabor.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void alchemistenlabor_benoetigt_strasse() {
	  Assert.assertEquals(alchemistenlabor.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(alchemistenlabor.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void alchemistenlabor_produziert_in_5_minuten_30_werkzeug() {
	  Assert.assertEquals(alchemistenlabor.getIn_5_Minuten().intValue(), wz_5_min);
	  Assert.assertEquals(alchemistenlabor.getIn_5_Minuten().intValue(), 30);
  }
  
  @Test
  public void alchemistenlabor_produziert_in_15_minuten_80_werkzeug() {
	  Assert.assertEquals(alchemistenlabor.getIn_15_Minuten().intValue(), wz_15_min);
	  Assert.assertEquals(alchemistenlabor.getIn_15_Minuten().intValue(), 80);
  }
  
  @Test
  public void alchemistenlabor_produziert_in_1_stunde_180_werkzeug() {
	  Assert.assertEquals(alchemistenlabor.getIn_1_Stunde().intValue(), wz_1_h);
	  Assert.assertEquals(alchemistenlabor.getIn_1_Stunde().intValue(), 180);
  }
  
  @Test
  public void alchemistenlabor_produziert_in_4_stunden_310_werkzeug() {
	  Assert.assertEquals(alchemistenlabor.getIn_4_Stunden().intValue(), wz_4_h);
	  Assert.assertEquals(alchemistenlabor.getIn_4_Stunden().intValue(), 310);
  }
  
  @Test
  public void alchemistenlabor_produziert_in_8_stunden_460_werkzeug() {
	  Assert.assertEquals(alchemistenlabor.getIn_8_Stunden().intValue(), wz_8_h);
	  Assert.assertEquals(alchemistenlabor.getIn_8_Stunden().intValue(), 460);
  }
  
  @Test
  public void alchemistenlabor_produziert_in_1_tag_920_werkzeug() {
	  Assert.assertEquals(alchemistenlabor.getIn_1_Tag().intValue(), wz_1_t);
	  Assert.assertEquals(alchemistenlabor.getIn_1_Tag().intValue(), 920);
  }
  
  @Test
  public void alchemistenlabor_produziert_in_5_minuten_moerser() {
	  Assert.assertEquals(alchemistenlabor.getName_5_min(), name_prod_5_min);
	  Assert.assertEquals(alchemistenlabor.getName_5_min(), "Mörser");
  }
  
  @Test
  public void alchemistenlabor_produziert_in_15_minuten_gift() {
	  Assert.assertEquals(alchemistenlabor.getName_15_min(), name_prod_15_min);
	  Assert.assertEquals(alchemistenlabor.getName_15_min(), "Gift");
  }
  
  @Test
  public void alchemistenlabor_produziert_in_1_stunde_elexir() {
	  Assert.assertEquals(alchemistenlabor.getName_1_h(), name_prod_1_h);
	  Assert.assertEquals(alchemistenlabor.getName_1_h(), "Elexir");
  }
  
  @Test
  public void alchemistenlabor_produziert_in_4_stunden_reagenzien() {
	  Assert.assertEquals(alchemistenlabor.getName_4_h(), name_prod_4_h);
	  Assert.assertEquals(alchemistenlabor.getName_4_h(), "Reagenzien");
  }
  
  @Test
  public void alchemistenlabor_produziert_in_8_stunden_traenke() {
	  Assert.assertEquals(alchemistenlabor.getName_8_h(), name_prod_8_h);
	  Assert.assertEquals(alchemistenlabor.getName_8_h(), "Tränke");
  }
  
  @Test
  public void alchemistenlabor_produziert_in_1_tag_salpeter() {
	  Assert.assertEquals(alchemistenlabor.getName_1_t(), name_prod_1_t);
	  Assert.assertEquals(alchemistenlabor.getName_1_t(), "Salpeter");
  }
  
  @Test
  public void alchemistenlabor_ist_normales_gebaeude() {
	  Assert.assertEquals(alchemistenlabor.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(alchemistenlabor.getGebaeude_art(), "Normal");
  }

}
