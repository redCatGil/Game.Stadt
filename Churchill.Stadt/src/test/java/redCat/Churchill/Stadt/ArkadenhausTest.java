package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Arkadenhaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class ArkadenhausTest {
	
	private Arkadenhaus arkadenhaus;
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
		String dsn = "ressource/main/xml/arkadenhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Arkadenhaus wurde nicht gefunden!");
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
		
		arkadenhaus = new Arkadenhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_arkadenhaus_sein() {
	  Assert.assertEquals(arkadenhaus.getName(), name);
	  Assert.assertEquals(arkadenhaus.getName(), "Arkadenhaus");
  }
  
  @Test
  public void zeitalter_muss_Kolonialzeit_sein() {
	  Assert.assertEquals(arkadenhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(arkadenhaus.getZeitalter(), "Kolonialzeit");
  }
  
  @Test
  public void arkadenhaus_kostet_5336_muenzen() {
	  Assert.assertEquals(arkadenhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(arkadenhaus.getMuenzen().intValue(), 5336);
  }
  
  @Test
  public void arkadenhaus_kostest_20056_werkzeug() {
	  Assert.assertEquals(arkadenhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(arkadenhaus.getWerkzeug().intValue(), 20056);
  }
  
  @Test
  public void arkadenhaus_kostet_keine_daimanten() {
	  Assert.assertEquals(arkadenhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(arkadenhaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void arkadenhaus_ist_2_lang() {
	  Assert.assertEquals(arkadenhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(arkadenhaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void arkadenhaus_ist_2_breit() {
	  Assert.assertEquals(arkadenhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(arkadenhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_arkadenhaus_ist_6_Stunde_20_Minuten() {
	  Assert.assertEquals(arkadenhaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(arkadenhaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(arkadenhaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(arkadenhaus.getBauzeit().get(Calendar.MINUTE), 20);
	  Assert.assertEquals(arkadenhaus.getBauzeit().get(Calendar.HOUR), 6);
	  Assert.assertEquals(arkadenhaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void arkadenhaus_hat_155_bewohner() {
	  Assert.assertEquals(arkadenhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(arkadenhaus.getBewohner().intValue(), 155);
  }
  
  @Test
  public void arkadenhaus_einnahme_ist_180_muenzen() {
	  Assert.assertEquals(arkadenhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(arkadenhaus.getMuenz_einnahmen().intValue(), 180);
  }
  
  @Test
  public void arkadenhaus_hat_alle_3600_sec_einnahmen() {
	  Assert.assertEquals(arkadenhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(arkadenhaus.getEinnahme_dauer().intValue(), 3600);
  }
  
  @Test
  public void arkadenhaus_benoetigt_strasse() {
	  Assert.assertEquals(arkadenhaus.isStrasse_benoetigt(), true);
  }

}
