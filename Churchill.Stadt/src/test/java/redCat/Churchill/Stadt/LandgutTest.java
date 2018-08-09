package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Landgut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class LandgutTest {
	
	private Landgut landgut;
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
		String dsn = "ressource/main/xml/landgut1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Landgut wurde nicht gefunden!");
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
		
		landgut = new Landgut(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_landgut_sein() {
	  Assert.assertEquals(landgut.getName(), name);
	  Assert.assertEquals(landgut.getName(), "Landgut");
  }
  
  @Test
  public void zeitalter_muss_spaetes_mittelalter_sein() {
	  Assert.assertEquals(landgut.getZeitalter(), zeitalter);
	  Assert.assertEquals(landgut.getZeitalter(), "Spaetes_Mittelalter");
  }
  
  @Test
  public void landgut_kostet_keine_muenzen() {
	  Assert.assertEquals(landgut.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(landgut.getMuenzen().intValue(), 0);
  }
  
  @Test
  public void landgut_kostest_kein_werkzeug() {
	  Assert.assertEquals(landgut.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(landgut.getWerkzeug().intValue(), 0);
  }
  
  @Test
  public void landgut_kostet_300_daimanten() {
	  Assert.assertEquals(landgut.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(landgut.getDiamanten().intValue(), 300);
  }
  
  @Test
  public void landgut_ist_2_lang() {
	  Assert.assertEquals(landgut.getLaenge().intValue(), laenge);
	  Assert.assertEquals(landgut.getLaenge().intValue(), 2);
  }
  
  @Test
  public void landgut_ist_2_breit() {
	  Assert.assertEquals(landgut.getBreite().intValue(), breite);
	  Assert.assertEquals(landgut.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_landgut_ist_20_sec() {
	  Assert.assertEquals(landgut.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(landgut.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(landgut.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(landgut.getBauzeit().get(Calendar.SECOND), 20);
  }
  
  @Test
  public void landgut_hat_246_bewohner() {
	  Assert.assertEquals(landgut.getBewohner().intValue(), personen);
	  Assert.assertEquals(landgut.getBewohner().intValue(), 246);
  }
  
  @Test
  public void einnahme_landgut_ist_400_muenzen() {
	  Assert.assertEquals(landgut.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(landgut.getMuenz_einnahmen().intValue(), 400);
  }
  
  @Test
  public void landgut_hat_alle_14400_sec_einnahmen() {
	  Assert.assertEquals(landgut.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(landgut.getEinnahme_dauer().intValue(), 14400);
  }
  
  @Test
  public void landgut_benoetigt_strasse() {
	  Assert.assertEquals(landgut.isStrasse_benoetigt(), true);
  }

}
