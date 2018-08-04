package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Domizil;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class DomizilTest {
	
	private Domizil domizil;
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
		String dsn = "ressource/main/xml/domizil1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Domizil wurde nicht gefunden!");
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
		
		domizil = new Domizil(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_domizil_sein() {
	  Assert.assertEquals(domizil.getName(), name);
	  Assert.assertEquals(domizil.getName(), "Domizil");
  }
  
  @Test
  public void zeitalter_muss_eisenzeit_sein() {
	  Assert.assertEquals(domizil.getZeitalter(), zeitalter);
	  Assert.assertEquals(domizil.getZeitalter(), "Eisenzeit");
  }
  
  @Test
  public void domizil_kostet_232_muenzen() {
	  Assert.assertEquals(domizil.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(domizil.getMuenzen().intValue(), 232);
  }
  
  @Test
  public void domizil_kostest_827_werkzeug() {
	  Assert.assertEquals(domizil.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(domizil.getWerkzeug().intValue(), 827);
  }
  
  @Test
  public void domizil_kostet_keine_daimanten() {
	  Assert.assertEquals(domizil.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(domizil.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void domizil_ist_2_lang() {
	  Assert.assertEquals(domizil.getLaenge().intValue(), laenge);
	  Assert.assertEquals(domizil.getLaenge().intValue(), 2);
  }
  
  @Test
  public void domizil_ist_2_breit() {
	  Assert.assertEquals(domizil.getBreite().intValue(), breite);
	  Assert.assertEquals(domizil.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_domizil_ist_30_Minuten() {
	  Assert.assertEquals(domizil.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(domizil.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(domizil.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(domizil.getBauzeit().get(Calendar.MINUTE), 30);
	  Assert.assertEquals(domizil.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(domizil.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void domizil_hat_73_bewohner() {
	  Assert.assertEquals(domizil.getBewohner().intValue(), personen);
	  Assert.assertEquals(domizil.getBewohner().intValue(), 73);
  }
  
  @Test
  public void domizileinnahme_ist_110_muenzen() {
	  Assert.assertEquals(domizil.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(domizil.getMuenz_einnahmen().intValue(), 110);
  }
  
  @Test
  public void domizil_hat_alle_14400_sec_einnahmen() {
	  Assert.assertEquals(domizil.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(domizil.getEinnahme_dauer().intValue(), 14400);
  }
  
  @Test
  public void domizil_benoetigt_strasse() {
	  Assert.assertEquals(domizil.isStrasse_benoetigt(), true);
  }

}
