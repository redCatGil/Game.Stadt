package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.ViktorianischesHaus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class Viktorianisches_HausTest {
	
	private ViktorianischesHaus viktorianischesHaus;
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
		String dsn = "ressource/main/xml/viktorianisches_haus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Viktorianisches Haus wurde nicht gefunden!");
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
		
		viktorianischesHaus = new ViktorianischesHaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_viktorianisches_haus_sein() {
	  Assert.assertEquals(viktorianischesHaus.getName(), name);
	  Assert.assertEquals(viktorianischesHaus.getName(), "Viktorianisches Haus");
  }
  
  @Test
  public void zeitalter_muss_Industriezeitalter_sein() {
	  Assert.assertEquals(viktorianischesHaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(viktorianischesHaus.getZeitalter(), "Industriezeitalter");
  }
  
  @Test
  public void viktorianisches_haus_kostet_17200_muenzen() {
	  Assert.assertEquals(viktorianischesHaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(viktorianischesHaus.getMuenzen().intValue(), 17200);
  }
  
  @Test
  public void viktorianisches_haus_kostest_65800_werkzeug() {
	  Assert.assertEquals(viktorianischesHaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(viktorianischesHaus.getWerkzeug().intValue(), 65800);
  }
  
  @Test
  public void viktorianisches_haus_kostet_keine_daimanten() {
	  Assert.assertEquals(viktorianischesHaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(viktorianischesHaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void viktorianisches_haus_ist_3_lang() {
	  Assert.assertEquals(viktorianischesHaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(viktorianischesHaus.getLaenge().intValue(), 3);
  }
  
  @Test
  public void viktorianisches_haus_ist_2_breit() {
	  Assert.assertEquals(viktorianischesHaus.getBreite().intValue(), breite);
	  Assert.assertEquals(viktorianischesHaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_viktorianisches_haus_ist_9_Stunden() {
	  Assert.assertEquals(viktorianischesHaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(viktorianischesHaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(viktorianischesHaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(viktorianischesHaus.getBauzeit().get(Calendar.MINUTE), 0);
	  Assert.assertEquals(viktorianischesHaus.getBauzeit().get(Calendar.HOUR), 9);
	  Assert.assertEquals(viktorianischesHaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void viktorianisches_haus_hat_474_bewohner() {
	  Assert.assertEquals(viktorianischesHaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(viktorianischesHaus.getBewohner().intValue(), 474);
  }
  
  @Test
  public void viktorianisches_haus_einnahme_ist_2420_muenzen() {
	  Assert.assertEquals(viktorianischesHaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(viktorianischesHaus.getMuenz_einnahmen().intValue(), 2420);
  }
  
  @Test
  public void viktorianisches_haus_hat_alle_86400_sec_einnahmen() {
	  Assert.assertEquals(viktorianischesHaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(viktorianischesHaus.getEinnahme_dauer().intValue(), 86400);
  }
  
  @Test
  public void viktorianisches_haus_benoetigt_strasse() {
	  Assert.assertEquals(viktorianischesHaus.isStrasse_benoetigt(), true);
  }

}
