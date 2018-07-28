package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Huette;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class HuettenTest {
	
	private Huette huette;
	private String name;
	private String zeitalter;
	private int muenzen;
	private int werkzeug;
	private int diamanten;
	private int laenge;
	private int breite;
	private int bauzeit;
	private int personen;
	private int einnahme;
	private int einnahmedauer;
	
  
  @BeforeMethod
  public void beforeMethod() {
		Properties props = new Properties();
		String dsn = "ressource/main/xml/huette1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Hütte wurde nicht gefunden!");
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
		einnahme = new Integer(props.getProperty("Einnahme")).intValue();
		einnahmedauer = new Integer(props.getProperty("Einnahmedauer")).intValue();
		
		huette = new Huette(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void huettenname_muss_huette_sein() {
	  Assert.assertEquals(huette.getName(), name);
  }
  
  @Test
  public void zeitalter_muss_steinzeit_sein() {
	  Assert.assertEquals(huette.getZeitalter(), zeitalter);
  }
  
  @Test
  public void huette_kostet_keine_muenzen() {
	  Assert.assertEquals(huette.getMuenzen().intValue(), muenzen);
  }
  
  @Test
  public void huettenbau_kostest_55_werkzeug() {
	  Assert.assertEquals(huette.getWerkzeug().intValue(), werkzeug);
  }
  
  @Test
  public void huette_kostet_keine_daimanten() {
	  Assert.assertEquals(huette.getDiamanten().intValue(), diamanten);
  }
  
  @Test
  public void huette_ist_2_lang() {
	  Assert.assertEquals(huette.getLaenge().intValue(), laenge);
  }
  
  @Test
  public void huette_ist_2_breit() {
	  Assert.assertEquals(huette.getBreite().intValue(), breite);
  }
  
  @Test
  public void bauzeit_heutte_ist_5_sec() {
	  Assert.assertEquals(huette.getBauzeit().get(Calendar.SECOND), bauzeit);
  }
  
  @Test
  public void huette_hat_14_bewohner() {
	  Assert.assertEquals(huette.getBewohner().intValue(), personen);
  }
  
  @Test
  public void huetteneinnahme_ist_6_muenzen() {
	  Assert.assertEquals(huette.getMuenz_einnahmen().intValue(), einnahme);
  }
  
  @Test
  public void heutte_hat_alle_300_sec_einnahmen() {
	  Assert.assertEquals(huette.getEinnahme_dauer().intValue(), einnahmedauer);
  }
  
  @Test
  public void huette_benoetigt_strasse() {
	  Assert.assertEquals(huette.isStrasse_benoetigt(), true);
  }

}
