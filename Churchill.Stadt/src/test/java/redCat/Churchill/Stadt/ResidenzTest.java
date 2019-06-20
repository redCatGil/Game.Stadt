package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Residenz;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class ResidenzTest {
	
	private Residenz residenz;
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
		String dsn = "ressource/main/xml/residenz1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Residenz wurde nicht gefunden!");
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
		
		residenz = new Residenz(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_residenz_sein() {
	  Assert.assertEquals(residenz.getName(), name);
	  Assert.assertEquals(residenz.getName(), "Residenz");
  }
  
  @Test
  public void zeitalter_muss_industriezeitalter_sein() {
	  Assert.assertEquals(residenz.getZeitalter(), zeitalter);
	  Assert.assertEquals(residenz.getZeitalter(), "Industriezeitalter");
  }
  
  @Test
  public void residenz_kostet_keine_muenzen() {
	  Assert.assertEquals(residenz.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(residenz.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void residenz_kostest_kein_werkzeug() {
	  Assert.assertEquals(residenz.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(residenz.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void residenz_kostet_350_daimanten() {
	  Assert.assertEquals(residenz.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(residenz.getDiamanten().intValue(), 350);
  }
  
  @Test
  public void residenz_ist_3_lang() {
	  Assert.assertEquals(residenz.getLaenge().intValue(), laenge);
	  Assert.assertEquals(residenz.getLaenge().intValue(), 3);
  }
  
  @Test
  public void residenz_ist_2_breit() {
	  Assert.assertEquals(residenz.getBreite().intValue(), breite);
	  Assert.assertEquals(residenz.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_residenz_ist_20_sec() {
	  residenz.getBauzeit().set(Calendar.AM_PM, Calendar.AM);
	  Assert.assertEquals(residenz.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(residenz.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(residenz.getBauzeit().get(Calendar.HOUR_OF_DAY), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(residenz.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(residenz.getBauzeit().get(Calendar.HOUR_OF_DAY), 0);
	  Assert.assertEquals(residenz.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void residenz_hat_569_bewohner() {
	  Assert.assertEquals(residenz.getBewohner().intValue(), personen);
	  Assert.assertEquals(residenz.getBewohner().intValue(), 569);
  }
  
  @Test
  public void einnahme_residenz_ist_1230_muenzen() {
	  Assert.assertEquals(residenz.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(residenz.getMuenz_einnahmen().intValue(), 1230);
  }
  
  @Test
  public void residenz_hat_alle_14400_sec_einnahmen() {
	  Assert.assertEquals(residenz.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(residenz.getEinnahme_dauer().intValue(), 14400);
  }
  
  @Test
  public void residenz_benoetigt_strasse() {
	  Assert.assertEquals(residenz.isStrasse_benoetigt(), true);
  }

}
