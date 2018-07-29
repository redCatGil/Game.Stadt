package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Langhaus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class LanghausTest {
	
	private Langhaus langhaus;
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
		String dsn = "ressource/main/xml/langhaus1.xml";
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
		//Langhaus init
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
		
		langhaus = new Langhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_langhaus_sein() {
	  Assert.assertEquals(langhaus.getName(), name);
	  Assert.assertEquals(langhaus.getName(), "Langhaus");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(langhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(langhaus.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void langhaus_kostet_keine_muenzen() {
	  Assert.assertEquals(langhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(langhaus.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void langhaus_kostest_kein_werkzeug() {
	  Assert.assertEquals(langhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(langhaus.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void langhaus_kostet_100_daimanten() {
	  Assert.assertEquals(langhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(langhaus.getDiamanten().intValue(), 100);
  }
  
  @Test
  public void langhaus_ist_4_lang() {
	  Assert.assertEquals(langhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(langhaus.getLaenge().intValue(), 4);
  }
  
  @Test
  public void langhaus_ist_2_breit() {
	  Assert.assertEquals(langhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(langhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_langhaus_ist_5_sec() {
	  Assert.assertEquals(langhaus.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(langhaus.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(langhaus.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(langhaus.getBauzeit().get(Calendar.SECOND), 5);
  }
  
  @Test
  public void langhaus_hat_70_bewohner() {
	  Assert.assertEquals(langhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(langhaus.getBewohner().intValue(), 70);
  }
  
  @Test
  public void langhauseinnahme_ist_100_muenzen() {
	  Assert.assertEquals(langhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(langhaus.getMuenz_einnahmen().intValue(), 100);
  }
  
  @Test
  public void langhaus_hat_alle_stunde_einnahmen() {
	  Assert.assertEquals(langhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(langhaus.getEinnahme_dauer().intValue(), 3600);
  }
  
  @Test
  public void langhaus_benoetigt_strasse() {
	  Assert.assertEquals(langhaus.isStrasse_benoetigt(), true);
  }

}
