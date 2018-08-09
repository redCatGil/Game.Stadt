package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Gutshaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class GutshausTest {
	
	private Gutshaus gutshaus;
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
		String dsn = "ressource/main/xml/gutshaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Gutshaus wurde nicht gefunden!");
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
		
		gutshaus = new Gutshaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_gutshaus_sein() {
	  Assert.assertEquals(gutshaus.getName(), name);
	  Assert.assertEquals(gutshaus.getName(), "Gutshaus");
  }
  
  @Test
  public void zeitalter_muss_spaetes_mittelalter_sein() {
	  Assert.assertEquals(gutshaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(gutshaus.getZeitalter(), "Spaetes_Mittelalter");
  }
  
  @Test
  public void gutshaus_kostet_3626_muenzen() {
	  Assert.assertEquals(gutshaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(gutshaus.getMuenzen().intValue(), 3626);
  }
  
  @Test
  public void gutshaus_kostest_13485_werkzeug() {
	  Assert.assertEquals(gutshaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(gutshaus.getWerkzeug().intValue(), 13485);
  }
  
  @Test
  public void gutshaus_kostet_keine_daimanten() {
	  Assert.assertEquals(gutshaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(gutshaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void gutshaus_ist_2_lang() {
	  Assert.assertEquals(gutshaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(gutshaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void gutshaus_ist_2_breit() {
	  Assert.assertEquals(gutshaus.getBreite().intValue(), breite);
	  Assert.assertEquals(gutshaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_gutshaus_ist_5_Stunden_30_Minuten() {
	  Assert.assertEquals(gutshaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(gutshaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(gutshaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(gutshaus.getBauzeit().get(Calendar.MINUTE), 30);
	  Assert.assertEquals(gutshaus.getBauzeit().get(Calendar.HOUR), 5);
	  Assert.assertEquals(gutshaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void gutshaus_hat_123_bewohner() {
	  Assert.assertEquals(gutshaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(gutshaus.getBewohner().intValue(), 123);
  }
  
  @Test
  public void gutshaus_einnahme_ist_120_muenzen() {
	  Assert.assertEquals(gutshaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(gutshaus.getMuenz_einnahmen().intValue(), 120);
  }
  
  @Test
  public void gutshaus_hat_alle_3600_sec_einnahmen() {
	  Assert.assertEquals(gutshaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(gutshaus.getEinnahme_dauer().intValue(), 3600);
  }
  
  @Test
  public void gutshaus_benoetigt_strasse() {
	  Assert.assertEquals(gutshaus.isStrasse_benoetigt(), true);
  }

}
