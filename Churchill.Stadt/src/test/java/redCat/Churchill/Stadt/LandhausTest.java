package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Landhaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class LandhausTest {
	
	private Landhaus landhaus;
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
		String dsn = "ressource/main/xml/landhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Landhaus wurde nicht gefunden!");
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
		
		landhaus = new Landhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_landhaus_sein() {
	  Assert.assertEquals(landhaus.getName(), name);
	  Assert.assertEquals(landhaus.getName(), "Landhaus");
  }
  
  @Test
  public void zeitalter_muss_kolonialzeit_sein() {
	  Assert.assertEquals(landhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(landhaus.getZeitalter(), "Kolonialzeit");
  }
  
  @Test
  public void landhaus_kostet_6552_muenzen() {
	  Assert.assertEquals(landhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(landhaus.getMuenzen().intValue(), 6552);
  }
  
  @Test
  public void landhaus_kostest_24843_werkzeug() {
	  Assert.assertEquals(landhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(landhaus.getWerkzeug().intValue(), 24843);
  }
  
  @Test
  public void landhaus_kostet_keine_daimanten() {
	  Assert.assertEquals(landhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(landhaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void landhaus_ist_2_lang() {
	  Assert.assertEquals(landhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(landhaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void landhaus_ist_2_breit() {
	  Assert.assertEquals(landhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(landhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_landhaus_ist_7_Stunden_30_Minuten() {
	  Assert.assertEquals(landhaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(landhaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(landhaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(landhaus.getBauzeit().get(Calendar.MINUTE), 30);
	  Assert.assertEquals(landhaus.getBauzeit().get(Calendar.HOUR), 7);
	  Assert.assertEquals(landhaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void landhaus_hat_207_bewohner() {
	  Assert.assertEquals(landhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(landhaus.getBewohner().intValue(), 207);
  }
  
  @Test
  public void landhaus_einnahme_ist_560_muenzen() {
	  Assert.assertEquals(landhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(landhaus.getMuenz_einnahmen().intValue(), 560);
  }
  
  @Test
  public void landhaus_hat_alle_28800_sec_einnahmen() {
	  Assert.assertEquals(landhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(landhaus.getEinnahme_dauer().intValue(), 28800);
  }
  
  @Test
  public void mietshaus_benoetigt_strasse() {
	  Assert.assertEquals(landhaus.isStrasse_benoetigt(), true);
  }

}
