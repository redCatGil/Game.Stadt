package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Kolonialhaus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class KolonialhausTest {
	
	private Kolonialhaus kolonialhaus;
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
		String dsn = "ressource/main/xml/kolonialhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Kolonialhaus wurde nicht gefunden!");
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
		// init
		name = props.getProperty("Name");
		zeitalter = props.getProperty("Zeitalter");
		muenzen = new Integer(props.getProperty("Muenzen")).intValue();
		werkzeug = new Integer(props.getProperty("Werkzeug")).intValue();
		diamanten = new Integer(props.getProperty("Diamanten")).intValue();
		laenge = new Integer(props.getProperty("Laenge")).intValue();
		breite = new Integer(props.getProperty("Breite")).intValue();
		bauzeit = new Integer(props.getProperty("Bauzeit")).intValue();
		personen = new Integer(props.getProperty("Bewohner")).intValue();
		einnahme = new Integer(props.getProperty("Einnahme")).intValue();
		einnahmedauer = new Integer(props.getProperty("Einnahmedauer")).intValue();
		
		kolonialhaus = new Kolonialhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_kolonialhaus_sein() {
	  Assert.assertEquals(kolonialhaus.getName(), name);
	  Assert.assertEquals(kolonialhaus.getName(), "Kolonialhaus");
  }
  
  @Test
  public void zeitalter_muss_koloniakzeit_sein() {
	  Assert.assertEquals(kolonialhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(kolonialhaus.getZeitalter(), "Kolonialzeit");
  }
  
  @Test
  public void kolonialhaus_kostet_keine_muenzen() {
	  Assert.assertEquals(kolonialhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(kolonialhaus.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void kolonialhaus_kostest_kein_werkzeug() {
	  Assert.assertEquals(kolonialhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(kolonialhaus.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void kolonialhaus_kostet_350_daimanten() {
	  Assert.assertEquals(kolonialhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(kolonialhaus.getDiamanten().intValue(), 350);
  }
  
  @Test
  public void kolonialhaus_ist_2_lang() {
	  Assert.assertEquals(kolonialhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(kolonialhaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void kolonialhaus_ist_2_breit() {
	  Assert.assertEquals(kolonialhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(kolonialhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_kolonialhaus_ist_20_sec() {
	  Assert.assertEquals(kolonialhaus.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(kolonialhaus.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(kolonialhaus.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(kolonialhaus.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void kolonialhaus_hat_311_bewohner() {
	  Assert.assertEquals(kolonialhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(kolonialhaus.getBewohner().intValue(), 311);
  }
  
  @Test
  public void einnahme_kolonialhaus_ist_660_muenzen() {
	  Assert.assertEquals(kolonialhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(kolonialhaus.getMuenz_einnahmen().intValue(), 660);
  }
  
  @Test
  public void kolonialhaus_hat_alle_14400_sec_einnahmen() {
	  Assert.assertEquals(kolonialhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(kolonialhaus.getEinnahme_dauer().intValue(), 14400);
  }
  
  @Test
  public void kolonialhaus_benoetigt_strasse() {
	  Assert.assertEquals(kolonialhaus.isStrasse_benoetigt(), true);
  }

}
