package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Arbeiterhaus;
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


public class ArbeiterhausTest {
	
	private Arbeiterhaus arbeiterhaus;
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
		String dsn = "ressource/main/xml/arbeiterhaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Arbeiterhaus wurde nicht gefunden!");
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
		
		arbeiterhaus = new Arbeiterhaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_arbeiterhaus_sein() {
	  Assert.assertEquals(arbeiterhaus.getName(), name);
	  Assert.assertEquals(arbeiterhaus.getName(), "Arbeiterhaus");
  }
  
  @Test
  public void zeitalter_muss_Industriezeitalter_sein() {
	  Assert.assertEquals(arbeiterhaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(arbeiterhaus.getZeitalter(), "Industriezeitalter");
  }
  
  @Test
  public void arbeiterhaus_kostet_11400_muenzen() {
	  Assert.assertEquals(arbeiterhaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(arbeiterhaus.getMuenzen().intValue(), 11400);
  }
  
  @Test
  public void arbeiterhaus_kostest_43900_werkzeug() {
	  Assert.assertEquals(arbeiterhaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(arbeiterhaus.getWerkzeug().intValue(), 43900);
  }
  
  @Test
  public void arbeiterhaus_kostet_keine_daimanten() {
	  Assert.assertEquals(arbeiterhaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(arbeiterhaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void arbeiterhaus_ist_3_lang() {
	  Assert.assertEquals(arbeiterhaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(arbeiterhaus.getLaenge().intValue(), 3);
  }
  
  @Test
  public void arbeiterhaus_ist_2_breit() {
	  Assert.assertEquals(arbeiterhaus.getBreite().intValue(), breite);
	  Assert.assertEquals(arbeiterhaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_arbeiterhaus_ist_6_Stunde_40_Minuten() {
	  Assert.assertEquals(arbeiterhaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(arbeiterhaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(arbeiterhaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(arbeiterhaus.getBauzeit().get(Calendar.MINUTE), 40);
	  Assert.assertEquals(arbeiterhaus.getBauzeit().get(Calendar.HOUR), 6);
	  Assert.assertEquals(arbeiterhaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void arbeiterhaus_hat_285_bewohner() {
	  Assert.assertEquals(arbeiterhaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(arbeiterhaus.getBewohner().intValue(), 285);
  }
  
  @Test
  public void arbeiterhaus_einnahme_ist_340_muenzen() {
	  Assert.assertEquals(arbeiterhaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(arbeiterhaus.getMuenz_einnahmen().intValue(), 340);
  }
  
  @Test
  public void arbeiterhaus_hat_alle_3600_sec_einnahmen() {
	  Assert.assertEquals(arbeiterhaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(arbeiterhaus.getEinnahme_dauer().intValue(), 3600);
  }
  
  @Test
  public void arbeiterhaus_benoetigt_strasse() {
	  Assert.assertEquals(arbeiterhaus.isStrasse_benoetigt(), true);
  }

}
