package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Pfahlbau;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class PfahlbauTest {
	
	private Pfahlbau pfahlbau;
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
		String dsn = "ressource/main/xml/pfahlbau1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für den Pfahlbau wurde nicht gefunden!");
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
		
		pfahlbau = new Pfahlbau(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_pfahlbau_sein() {
	  Assert.assertEquals(pfahlbau.getName(), name);
	  Assert.assertEquals(pfahlbau.getName(), "Pfahlbau");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(pfahlbau.getZeitalter(), zeitalter);
	  Assert.assertEquals(pfahlbau.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void pfahlbau_kostet_37_muenzen() {
	  Assert.assertEquals(pfahlbau.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(pfahlbau.getMuenzen().intValue(), 37);
  }
  
  @Test
  public void pfahlbau_kostest_139_werkzeug() {
	  Assert.assertEquals(pfahlbau.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(pfahlbau.getWerkzeug().intValue(), 139);
  }
  
  @Test
  public void pfahlbau_kostet_keine_daimanten() {
	  Assert.assertEquals(pfahlbau.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(pfahlbau.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void pfahlbau_ist_2_lang() {
	  Assert.assertEquals(pfahlbau.getLaenge().intValue(), laenge);
	  Assert.assertEquals(pfahlbau.getLaenge().intValue(), 2);
  }
  
  @Test
  public void pfahlbau_ist_2_breit() {
	  Assert.assertEquals(pfahlbau.getBreite().intValue(), breite);
	  Assert.assertEquals(pfahlbau.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_pfahlbau_ist_10_sec() {
	  Assert.assertEquals(pfahlbau.getBauzeit().get(Calendar.SECOND), bauzeit);
	  Assert.assertEquals(pfahlbau.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(pfahlbau.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(pfahlbau.getBauzeit().get(Calendar.SECOND), 10);
  }
  
  @Test
  public void pfahlbau_hat_22_bewohner() {
	  Assert.assertEquals(pfahlbau.getBewohner().intValue(), personen);
	  Assert.assertEquals(pfahlbau.getBewohner().intValue(), 22);
  }
  
  @Test
  public void pfahlbaueinnahme_ist_11_muenzen() {
	  Assert.assertEquals(pfahlbau.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(pfahlbau.getMuenz_einnahmen().intValue(), 11);
  }
  
  @Test
  public void pfahlbau_hat_alle_900_sec_einnahmen() {
	  Assert.assertEquals(pfahlbau.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(pfahlbau.getEinnahme_dauer().intValue(), 900);
  }
  
  @Test
  public void pfahlbau_benoetigt_strasse() {
	  Assert.assertEquals(pfahlbau.isStrasse_benoetigt(), true);
  }

}
