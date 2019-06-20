package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Pension;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class PeinsionTest {
	
	private Pension pension;
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
		String dsn = "ressource/main/xml/pension1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Pension wurde nicht gefunden!");
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
		
		pension = new Pension(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_pension_sein() {
	  Assert.assertEquals(pension.getName(), name);
	  Assert.assertEquals(pension.getName(), "Pension");
  }
  
  @Test
  public void zeitalter_muss_industriezeitalter_sein() {
	  Assert.assertEquals(pension.getZeitalter(), zeitalter);
	  Assert.assertEquals(pension.getZeitalter(), "Industriezeitalter");
  }
  
  @Test
  public void pension_kostet_14300_muenzen() {
	  Assert.assertEquals(pension.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(pension.getMuenzen().intValue(), 14300);
  }
  
  @Test
  public void pension_kostest_54800_werkzeug() {
	  Assert.assertEquals(pension.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(pension.getWerkzeug().intValue(), 54800);
  }
  
  @Test
  public void pension_kostet_keine_daimanten() {
	  Assert.assertEquals(pension.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(pension.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void pension_ist_3_lang() {
	  Assert.assertEquals(pension.getLaenge().intValue(), laenge);
	  Assert.assertEquals(pension.getLaenge().intValue(), 3);
  }
  
  @Test
  public void pension_ist_2_breit() {
	  Assert.assertEquals(pension.getBreite().intValue(), breite);
	  Assert.assertEquals(pension.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_pension_ist_7_stunden_50_minuten() {
	  pension.getBauzeit().set(Calendar.AM_PM, Calendar.AM);
	  Assert.assertEquals(pension.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(pension.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(pension.getBauzeit().get(Calendar.HOUR_OF_DAY), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(pension.getBauzeit().get(Calendar.MINUTE), 50);
	  Assert.assertEquals(pension.getBauzeit().get(Calendar.HOUR_OF_DAY), 7);
	  Assert.assertEquals(pension.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void pension_hat_380_bewohner() {
	  Assert.assertEquals(pension.getBewohner().intValue(), personen);
	  Assert.assertEquals(pension.getBewohner().intValue(), 380);
  }
  
  @Test
  public void einnahme_pension_ist_1050_muenzen() {
	  Assert.assertEquals(pension.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(pension.getMuenz_einnahmen().intValue(), 1050);
  }
  
  @Test
  public void pension_hat_alle_28800_sec_einnahmen() {
	  Assert.assertEquals(pension.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(pension.getEinnahme_dauer().intValue(), 28800);
  }
  
  @Test
  public void pension_benoetigt_strasse() {
	  Assert.assertEquals(pension.isStrasse_benoetigt(), true);
  }

}
