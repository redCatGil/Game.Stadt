package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Herrenhaus;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class HerrenhausTest {
	
	private Herrenhaus herrenhaus;
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
		String dsn = "ressource/main/xml/herrenhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Herrenhaus wurde nicht gefunden!");
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
		
		herrenhaus = new Herrenhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_herrenhaus_sein() {
	  Assert.assertEquals(herrenhaus.getName(), name);
	  Assert.assertEquals(herrenhaus.getName(), "Herrenhaus");
  }
  
  @Test
  public void zeitalter_muss_hochmittelalter_sein() {
	  Assert.assertEquals(herrenhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(herrenhaus.getZeitalter(), "Hochmittelalter");
  }
  
  @Test
  public void herrenhaus_kostet_keine_muenzen() {
	  Assert.assertEquals(herrenhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(herrenhaus.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void herrenhaus_kostest_kein_werkzeug() {
	  Assert.assertEquals(herrenhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(herrenhaus.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void herrenhaus_kostet_300_daimanten() {
	  Assert.assertEquals(herrenhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(herrenhaus.getDiamanten().intValue(), 300);
  }
  
  @Test
  public void herrenhaus_ist_2_lang() {
	  Assert.assertEquals(herrenhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(herrenhaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void herrenhaus_ist_2_breit() {
	  Assert.assertEquals(herrenhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(herrenhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_herrenhaus_ist_20_sec() {
	  Assert.assertEquals(herrenhaus.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(herrenhaus.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(herrenhaus.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(herrenhaus.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void herrenhaus_hat_188_bewohner() {
	  Assert.assertEquals(herrenhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(herrenhaus.getBewohner().intValue(), 188);
  }
  
  @Test
  public void einnahme_herrenhaus_ist_340_muenzen() {
	  Assert.assertEquals(herrenhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(herrenhaus.getMuenz_einnahmen().intValue(), 340);
  }
  
  @Test
  public void herrenhaus_hat_alle_14400_sec_einnahmen() {
	  Assert.assertEquals(herrenhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(herrenhaus.getEinnahme_dauer().intValue(), 14400);
  }
  
  @Test
  public void herrenhaus_benoetigt_strasse() {
	  Assert.assertEquals(herrenhaus.isStrasse_benoetigt(), true);
  }

}
