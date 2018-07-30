package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.StrohgedecktesHaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class Strohgedecktes_HausTest {
	
	private StrohgedecktesHaus strohgedecktesHaus;
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
		String dsn = "ressource/main/xml/strohgedecktes_Haus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Strohgeckte Haus wurde nicht gefunden!");
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
		
		strohgedecktesHaus = new StrohgedecktesHaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_strohgedecktes_Haus_sein() {
	  Assert.assertEquals(strohgedecktesHaus.getName(), name);
	  Assert.assertEquals(strohgedecktesHaus.getName(), "strohgedecktes Haus");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(strohgedecktesHaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(strohgedecktesHaus.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void strohgedecktes_Haus_kostet_148_muenzen() {
	  Assert.assertEquals(strohgedecktesHaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(strohgedecktesHaus.getMuenzen().intValue(), 148);
  }
  
  @Test
  public void strohgedecktes_Haus_kostest_279_werkzeug() {
	  Assert.assertEquals(strohgedecktesHaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(strohgedecktesHaus.getWerkzeug().intValue(), 279);
  }
  
  @Test
  public void strohgedecktes_Haus_kostet_keine_daimanten() {
	  Assert.assertEquals(strohgedecktesHaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(strohgedecktesHaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void strohgedecktes_Haus_ist_2_lang() {
	  Assert.assertEquals(strohgedecktesHaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(strohgedecktesHaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void strohgedecktes_Haus_ist_2_breit() {
	  Assert.assertEquals(strohgedecktesHaus.getBreite().intValue(), breite);
	  Assert.assertEquals(strohgedecktesHaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_strohgedecktes_Haus_ist_5_min() {
//	  System.out.println(""+strohgedecktesHaus.getBauzeit().get(Calendar.SECOND)+" #"+strohgedecktesHaus.getBauzeit().get(Calendar.MINUTE)
//			  + "#"+ strohgedecktesHaus.getBauzeit().get(Calendar.HOUR));
	  Assert.assertEquals(strohgedecktesHaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(strohgedecktesHaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(strohgedecktesHaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  
	  Assert.assertEquals(strohgedecktesHaus.getBauzeit().get(Calendar.MINUTE), 5);
	  Assert.assertEquals(strohgedecktesHaus.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(strohgedecktesHaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void strohgedecktes_Haus_hat_27_bewohner() {
	  Assert.assertEquals(strohgedecktesHaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(strohgedecktesHaus.getBewohner().intValue(), 27);
  }
  
  @Test
  public void strohgedecktes_Haus_einnahme_ist_32_muenzen() {
	  Assert.assertEquals(strohgedecktesHaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(strohgedecktesHaus.getMuenz_einnahmen().intValue(), 32);
  }
  
  @Test
  public void strohgedecktes_Haus_hat_alle_3600_sec_einnahmen() {
	  Assert.assertEquals(strohgedecktesHaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(strohgedecktesHaus.getEinnahme_dauer().intValue(), 3600);
  }
  
  @Test
  public void strohgedecktes_Haus_benoetigt_strasse() {
	  Assert.assertEquals(strohgedecktesHaus.isStrasse_benoetigt(), true);
  }

}
