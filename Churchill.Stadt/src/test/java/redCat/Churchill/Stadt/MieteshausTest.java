package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Mietshaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class MieteshausTest {
	
	private Mietshaus mietshaus;
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
		String dsn = "ressource/main/xml/mietshaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Mietshaus wurde nicht gefunden!");
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
		
		mietshaus = new Mietshaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_mietshaus_sein() {
	  Assert.assertEquals(mietshaus.getName(), name);
	  Assert.assertEquals(mietshaus.getName(), "Mietshaus");
  }
  
  @Test
  public void zeitalter_muss_spaetes_mittelalter_sein() {
	  Assert.assertEquals(mietshaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(mietshaus.getZeitalter(), "Spaetes_Mittelalter");
  }
  
  @Test
  public void mietshaus_kostet_5394_muenzen() {
	  Assert.assertEquals(mietshaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(mietshaus.getMuenzen().intValue(), 5394);
  }
  
  @Test
  public void mietshaus_kostest_20274_werkzeug() {
	  Assert.assertEquals(mietshaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(mietshaus.getWerkzeug().intValue(), 20274);
  }
  
  @Test
  public void mietshaus_kostet_keine_daimanten() {
	  Assert.assertEquals(mietshaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(mietshaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void mietshaus_ist_2_lang() {
	  Assert.assertEquals(mietshaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(mietshaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void mietshaus_ist_2_breit() {
	  Assert.assertEquals(mietshaus.getBreite().intValue(), breite);
	  Assert.assertEquals(mietshaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_mietshaus_ist_7_Stunden_20_Minuten() {
	  Assert.assertEquals(mietshaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(mietshaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(mietshaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(mietshaus.getBauzeit().get(Calendar.MINUTE), 20);
	  Assert.assertEquals(mietshaus.getBauzeit().get(Calendar.HOUR), 7);
	  Assert.assertEquals(mietshaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void mietshaus_hat_205_bewohner() {
	  Assert.assertEquals(mietshaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(mietshaus.getBewohner().intValue(), 205);
  }
  
  @Test
  public void mietshaus_einnahme_ist_440_muenzen() {
	  Assert.assertEquals(mietshaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(mietshaus.getMuenz_einnahmen().intValue(), 440);
  }
  
  @Test
  public void mietshaus_hat_alle_28800_sec_einnahmen() {
	  Assert.assertEquals(mietshaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(mietshaus.getEinnahme_dauer().intValue(), 28800);
  }
  
  @Test
  public void mietshaus_benoetigt_strasse() {
	  Assert.assertEquals(mietshaus.isStrasse_benoetigt(), true);
  }

}
