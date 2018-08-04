package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Villa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class VillaTest {
	
	private Villa villa;
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
		String dsn = "ressource/main/xml/villa1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Villa wurde nicht gefunden!");
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
		
		villa = new Villa(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_villa_sein() {
	  Assert.assertEquals(villa.getName(), name);
	  Assert.assertEquals(villa.getName(), "Villa");
  }
  
  @Test
  public void zeitalter_muss_eisenzeit_sein() {
	  Assert.assertEquals(villa.getZeitalter(), zeitalter);
	  Assert.assertEquals(villa.getZeitalter(), "Eisenzeit");
  }
  
  @Test
  public void villa_kostet_keine_muenzen() {
	  Assert.assertEquals(villa.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(villa.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void villa_kostest_kein_werkzeug() {
	  Assert.assertEquals(villa.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(villa.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void villa_kostet_200_daimanten() {
	  Assert.assertEquals(villa.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(villa.getDiamanten().intValue(), 200);
  }
  
  @Test
  public void villa_ist_2_lang() {
	  Assert.assertEquals(villa.getLaenge().intValue(), laenge);
	  Assert.assertEquals(villa.getLaenge().intValue(), 2);
  }
  
  @Test
  public void villa_ist_2_breit() {
	  Assert.assertEquals(villa.getBreite().intValue(), breite);
	  Assert.assertEquals(villa.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_villa_ist_20_sec() {
	  Assert.assertEquals(villa.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(villa.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(villa.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(villa.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void villa_hat_87_bewohner() {
	  Assert.assertEquals(villa.getBewohner().intValue(), personen);
	  Assert.assertEquals(villa.getBewohner().intValue(), 87);
  }
  
  @Test
  public void villaeinnahme_ist_100_muenzen() {
	  Assert.assertEquals(villa.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(villa.getMuenz_einnahmen().intValue(), 100);
  }
  
  @Test
  public void villa_hat_alle_stunde_einnahmen() {
	  Assert.assertEquals(villa.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(villa.getEinnahme_dauer().intValue(), 3600);
  }
  
  @Test
  public void villa_benoetigt_strasse() {
	  Assert.assertEquals(villa.isStrasse_benoetigt(), true);
  }

}
