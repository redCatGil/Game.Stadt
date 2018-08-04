package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Fachwerkhaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class FachwerkhausTest {
	
	private Fachwerkhaus fachwerkhaus;
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
		String dsn = "ressource/main/xml/fachwerkhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Fachwerkhaus wurde nicht gefunden!");
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
		
		fachwerkhaus = new Fachwerkhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_fachwerkhaus_sein() {
	  Assert.assertEquals(fachwerkhaus.getName(), name);
	  Assert.assertEquals(fachwerkhaus.getName(), "Fachwerkhaus");
  }
  
  @Test
  public void zeitalter_muss_fruehes_Mittelalter_sein() {
	  Assert.assertEquals(fachwerkhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(fachwerkhaus.getZeitalter(), "Fruehes_Mittelalter");
  }
  
  @Test
  public void fachwerkhaus_kostet_651_muenzen() {
	  Assert.assertEquals(fachwerkhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(fachwerkhaus.getMuenzen().intValue(), 651);
  }
  
  @Test
  public void fachwerkhaus_kostest_2418_werkzeug() {
	  Assert.assertEquals(fachwerkhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(fachwerkhaus.getWerkzeug().intValue(), 2418);
  }
  
  @Test
  public void fachwerkhaus_kostet_keine_daimanten() {
	  Assert.assertEquals(fachwerkhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(fachwerkhaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void fachwerkhaus_ist_2_lang() {
	  Assert.assertEquals(fachwerkhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(fachwerkhaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void fachwerkhaus_ist_2_breit() {
	  Assert.assertEquals(fachwerkhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(fachwerkhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_fachwerkhaus_ist_1_Stunde_20_Minuten() {
	  Assert.assertEquals(fachwerkhaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(fachwerkhaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(fachwerkhaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(fachwerkhaus.getBauzeit().get(Calendar.MINUTE), 20);
	  Assert.assertEquals(fachwerkhaus.getBauzeit().get(Calendar.HOUR), 1);
	  Assert.assertEquals(fachwerkhaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void fachwerkhaus_hat_67_bewohner() {
	  Assert.assertEquals(fachwerkhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(fachwerkhaus.getBewohner().intValue(), 67);
  }
  
  @Test
  public void fachwerkhauseinnahme_ist_60_muenzen() {
	  Assert.assertEquals(fachwerkhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(fachwerkhaus.getMuenz_einnahmen().intValue(), 60);
  }
  
  @Test
  public void fachwerkhaus_hat_alle_3600_sec_einnahmen() {
	  Assert.assertEquals(fachwerkhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(fachwerkhaus.getEinnahme_dauer().intValue(), 3600);
  }
  
  @Test
  public void fachwerkhaus_benoetigt_strasse() {
	  Assert.assertEquals(fachwerkhaus.isStrasse_benoetigt(), true);
  }

}
