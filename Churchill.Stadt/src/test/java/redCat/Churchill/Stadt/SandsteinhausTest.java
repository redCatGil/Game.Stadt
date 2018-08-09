package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Sandsteinhaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class SandsteinhausTest {
	
	private Sandsteinhaus sandsteinhaus;
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
		String dsn = "ressource/main/xml/sandsteinhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Sandsteinhaus wurde nicht gefunden!");
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
		
		sandsteinhaus = new Sandsteinhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_sandsteinhaus_sein() {
	  Assert.assertEquals(sandsteinhaus.getName(), name);
	  Assert.assertEquals(sandsteinhaus.getName(), "Sandsteinhaus");
  }
  
  @Test
  public void zeitalter_muss_Hochmittelalter_sein() {
	  Assert.assertEquals(sandsteinhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(sandsteinhaus.getZeitalter(), "Hochmittelalter");
  }
  
  @Test
  public void sandsteinhaus_kostet_1674_muenzen() {
	  Assert.assertEquals(sandsteinhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(sandsteinhaus.getMuenzen().intValue(), 1674);
  }
  
  @Test
  public void sandsteinhaus_kostest_6510_werkzeug() {
	  Assert.assertEquals(sandsteinhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(sandsteinhaus.getWerkzeug().intValue(), 6510);
  }
  
  @Test
  public void sandsteinhaus_kostet_keine_daimanten() {
	  Assert.assertEquals(sandsteinhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(sandsteinhaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void sandsteinhaus_ist_2_lang() {
	  Assert.assertEquals(sandsteinhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(sandsteinhaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void sandsteinhaus_ist_2_breit() {
	  Assert.assertEquals(sandsteinhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(sandsteinhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_sandsteinhaus_ist_3_Stunde_20_Minuten() {
	  Assert.assertEquals(sandsteinhaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(sandsteinhaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(sandsteinhaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(sandsteinhaus.getBauzeit().get(Calendar.MINUTE), 20);
	  Assert.assertEquals(sandsteinhaus.getBauzeit().get(Calendar.HOUR), 3);
	  Assert.assertEquals(sandsteinhaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void sandsteinhaus_hat_94_bewohner() {
	  Assert.assertEquals(sandsteinhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(sandsteinhaus.getBewohner().intValue(), 94);
  }
  
  @Test
  public void sandsteinhaus_einnahme_ist_90_muenzen() {
	  Assert.assertEquals(sandsteinhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(sandsteinhaus.getMuenz_einnahmen().intValue(), 90);
  }
  
  @Test
  public void sandsteinhaus_hat_alle_3600_sec_einnahmen() {
	  Assert.assertEquals(sandsteinhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(sandsteinhaus.getEinnahme_dauer().intValue(), 3600);
  }
  
  @Test
  public void sandsteinhaus_benoetigt_strasse() {
	  Assert.assertEquals(sandsteinhaus.isStrasse_benoetigt(), true);
  }

}
