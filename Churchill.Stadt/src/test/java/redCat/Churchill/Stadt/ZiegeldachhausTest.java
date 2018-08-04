package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.Ziegeldachhaus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class ZiegeldachhausTest {
	
	private Ziegeldachhaus ziegeldachhaus;
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
		String dsn = "ressource/main/xml/ziegeldachhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Ziegeldachhaus wurde nicht gefunden!");
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
		personen = new Integer(props.getProperty("Bewohner")).intValue();
		einnahme = new Integer(props.getProperty("Einnahme")).intValue();
		einnahmedauer = new Integer(props.getProperty("Einnahmedauer")).intValue();
		
		ziegeldachhaus = new Ziegeldachhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_ziegeldachhaus_sein() {
	  Assert.assertEquals(ziegeldachhaus.getName(), name);
	  Assert.assertEquals(ziegeldachhaus.getName(), "Ziegeldachhaus");
  }
  
  @Test
  public void zeitalter_muss_eisenzeit_sein() {
	  Assert.assertEquals(ziegeldachhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(ziegeldachhaus.getZeitalter(), "Eisenzeit");
  }
  
  @Test
  public void ziegeldachhaus_kostet_372_muenzen() {
	  Assert.assertEquals(ziegeldachhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(ziegeldachhaus.getMuenzen().intValue(), 372);
  }
  
  @Test
  public void ziegeldachhaus_kostest_558_werkzeug() {
	  Assert.assertEquals(ziegeldachhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(ziegeldachhaus.getWerkzeug().intValue(), 558);
  }
  
  @Test
  public void ziegeldachhaus_kostet_keine_daimanten() {
	  Assert.assertEquals(ziegeldachhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(ziegeldachhaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void ziegeldachhaus_ist_2_lang() {
	  Assert.assertEquals(ziegeldachhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(ziegeldachhaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void ziegeldachhaus_ist_2_breit() {
	  Assert.assertEquals(ziegeldachhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(ziegeldachhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_ziegeldachhaus_ist_20_Minuten() {
	  Assert.assertEquals(ziegeldachhaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(ziegeldachhaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(ziegeldachhaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(ziegeldachhaus.getBauzeit().get(Calendar.MINUTE), 20);
	  Assert.assertEquals(ziegeldachhaus.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(ziegeldachhaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void ziegeldachhaus_hat_44_bewohner() {
	  Assert.assertEquals(ziegeldachhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(ziegeldachhaus.getBewohner().intValue(), 44);
  }
  
  @Test
  public void ziegeldachhauseinnahme_ist_15_muenzen() {
	  Assert.assertEquals(ziegeldachhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(ziegeldachhaus.getMuenz_einnahmen().intValue(), 15);
  }
  
  @Test
  public void ziegeldachhausl_hat_alle_900_sec_einnahmen() {
	  Assert.assertEquals(ziegeldachhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(ziegeldachhaus.getEinnahme_dauer().intValue(), 900);
  }
  
  @Test
  public void ziegeldachhaus_benoetigt_strasse() {
	  Assert.assertEquals(ziegeldachhaus.isStrasse_benoetigt(), true);
  }

}
