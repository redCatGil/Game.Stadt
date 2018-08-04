package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Schindelhaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class SchindelhausTest {
	
	private Schindelhaus schindelhaus;
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
		String dsn = "ressource/main/xml/schindelhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Schindelhaus wurde nicht gefunden!");
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
		
		schindelhaus = new Schindelhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_schindelhaus_sein() {
	  Assert.assertEquals(schindelhaus.getName(), name);
	  Assert.assertEquals(schindelhaus.getName(), "Schindelhaus");
  }
  
  @Test
  public void zeitalter_muss_fruehes_Mittelalter_sein() {
	  Assert.assertEquals(schindelhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(schindelhaus.getZeitalter(), "Fruehes_Mittelalter");
  }
  
  @Test
  public void schindelhaus_kostet_929_muenzen() {
	  Assert.assertEquals(schindelhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(schindelhaus.getMuenzen().intValue(), 929);
  }
  
  @Test
  public void schindelhaus_kostest_3626_werkzeug() {
	  Assert.assertEquals(schindelhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(schindelhaus.getWerkzeug().intValue(), 3626);
  }
  
  @Test
  public void schindelhaus_kostet_keine_daimanten() {
	  Assert.assertEquals(schindelhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(schindelhaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void schindelhaus_ist_2_lang() {
	  Assert.assertEquals(schindelhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(schindelhaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void schindelhaus_ist_2_breit() {
	  Assert.assertEquals(schindelhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(schindelhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_schindelhaus_ist_1_Stunde_50_Minuten() {
	  Assert.assertEquals(schindelhaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(schindelhaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(schindelhaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(schindelhaus.getBauzeit().get(Calendar.MINUTE), 50);
	  Assert.assertEquals(schindelhaus.getBauzeit().get(Calendar.HOUR), 1);
	  Assert.assertEquals(schindelhaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void schindelhaus_hat_111_bewohner() {
	  Assert.assertEquals(schindelhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(schindelhaus.getBewohner().intValue(), 111);
  }
  
  @Test
  public void schindelhauseinnahme_ist_240_muenzen() {
	  Assert.assertEquals(schindelhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(schindelhaus.getMuenz_einnahmen().intValue(), 240);
  }
  
  @Test
  public void schindelhaus_hat_alle_28800_sec_einnahmen() {
	  Assert.assertEquals(schindelhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(schindelhaus.getEinnahme_dauer().intValue(), 28800);
  }
  
  @Test
  public void schindelhaus_benoetigt_strasse() {
	  Assert.assertEquals(schindelhaus.isStrasse_benoetigt(), true);
  }

}
