package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Stadthaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class StadthausTest {
	
	private Stadthaus stadthaus;
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
		String dsn = "ressource/main/xml/stadthaus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Stadthaus wurde nicht gefunden!");
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
		
		stadthaus = new Stadthaus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_stadthaus_sein() {
	  Assert.assertEquals(stadthaus.getName(), name);
	  Assert.assertEquals(stadthaus.getName(), "Stadthaus");
  }
  
  @Test
  public void zeitalter_muss_Hochmittelalter_sein() {
	  Assert.assertEquals(stadthaus.getZeitalter(), zeitalter);
	  Assert.assertEquals(stadthaus.getZeitalter(), "Hochmittelalter");
  }
  
  @Test
  public void stadthaus_kostet_2604_muenzen() {
	  Assert.assertEquals(stadthaus.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(stadthaus.getMuenzen().intValue(), 2604);
  }
  
  @Test
  public void stadthaus_kostest_9765_werkzeug() {
	  Assert.assertEquals(stadthaus.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(stadthaus.getWerkzeug().intValue(), 9765);
  }
  
  @Test
  public void stadthaus_kostet_keine_daimanten() {
	  Assert.assertEquals(stadthaus.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(stadthaus.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void stadthaus_ist_2_lang() {
	  Assert.assertEquals(stadthaus.getLaenge().intValue(), laenge);
	  Assert.assertEquals(stadthaus.getLaenge().intValue(), 2);
  }
  
  @Test
  public void stadthaus_ist_2_breit() {
	  Assert.assertEquals(stadthaus.getBreite().intValue(), breite);
	  Assert.assertEquals(stadthaus.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_stadthaus_ist_4_Stunde_40_Minuten() {
	  Assert.assertEquals(stadthaus.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(stadthaus.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(stadthaus.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(stadthaus.getBauzeit().get(Calendar.MINUTE), 40);
	  Assert.assertEquals(stadthaus.getBauzeit().get(Calendar.HOUR), 4);
	  Assert.assertEquals(stadthaus.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void stadthaus_hat_156_bewohner() {
	  Assert.assertEquals(stadthaus.getBewohner().intValue(), personen);
	  Assert.assertEquals(stadthaus.getBewohner().intValue(), 156);
  }
  
  @Test
  public void stadthaus_einnahme_ist_340_muenzen() {
	  Assert.assertEquals(stadthaus.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(stadthaus.getMuenz_einnahmen().intValue(), 340);
  }
  
  @Test
  public void stadthaus_hat_alle_28800_sec_einnahmen() {
	  Assert.assertEquals(stadthaus.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(stadthaus.getEinnahme_dauer().intValue(), 28800);
  }
  
  @Test
  public void stadthaus_benoetigt_strasse() {
	  Assert.assertEquals(stadthaus.isStrasse_benoetigt(), true);
  }

}
