package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Arkadenhaus;
import redCat.Churchill.Stadt.Bauwerke.impl.Mansarddach_Haus;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class Mansarddach_HausTest {
	
	private Mansarddach_Haus mansarddach;
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
		String dsn = "ressource/main/xml/mansarddach_haus1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Mansarddach-Haus wurde nicht gefunden!");
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
		//Mansarddach-Haus init
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
		
		mansarddach = new Mansarddach_Haus(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_mansarddach_haus_sein() {
	  Assert.assertEquals(mansarddach.getName(), name);
	  Assert.assertEquals(mansarddach.getName(), "Mansarddach-Haus");
  }
  
  @Test
  public void zeitalter_muss_Kolonialzeit_sein() {
	  Assert.assertEquals(mansarddach.getZeitalter(), zeitalter);
	  Assert.assertEquals(mansarddach.getZeitalter(), "Kolonialzeit");
  }
  
  @Test
  public void mansarddach_haus_kostet_8700_muenzen() {
	  Assert.assertEquals(mansarddach.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(mansarddach.getMuenzen().intValue(), 8700);
  }
  
  @Test
  public void mansarddach_haus_kostest_32800_werkzeug() {
	  Assert.assertEquals(mansarddach.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(mansarddach.getWerkzeug().intValue(), 32800);
  }
  
  @Test
  public void mansarddach_haus_kostet_keine_daimanten() {
	  Assert.assertEquals(mansarddach.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(mansarddach.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void mansarddach_haus_ist_2_lang() {
	  Assert.assertEquals(mansarddach.getLaenge().intValue(), laenge);
	  Assert.assertEquals(mansarddach.getLaenge().intValue(), 2);
  }
  
  @Test
  public void mansarddach_haus_ist_2_breit() {
	  Assert.assertEquals(mansarddach.getBreite().intValue(), breite);
	  Assert.assertEquals(mansarddach.getBreite().intValue(), 2);
  }
  
  @Test
  public void bauzeit_mansarddach_haus_ist_8_Stunde_40_Minuten() {
	  Assert.assertEquals(mansarddach.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(mansarddach.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(mansarddach.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(mansarddach.getBauzeit().get(Calendar.MINUTE), 40);
	  Assert.assertEquals(mansarddach.getBauzeit().get(Calendar.HOUR), 8);
	  Assert.assertEquals(mansarddach.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void mansarddach_haus_hat_259_bewohner() {
	  Assert.assertEquals(mansarddach.getBewohner().intValue(), personen);
	  Assert.assertEquals(mansarddach.getBewohner().intValue(), 259);
  }
  
  @Test
  public void mansarddach_haus_einnahme_ist_1350_muenzen() {
	  Assert.assertEquals(mansarddach.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(mansarddach.getMuenz_einnahmen().intValue(), 1350);
  }
  
  @Test
  public void mansarddach_haus_hat_alle_86400_sec_einnahmen() {
	  Assert.assertEquals(mansarddach.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(mansarddach.getEinnahme_dauer().intValue(), 86400);
  }
  
  @Test
  public void mansarddach_haus_benoetigt_strasse() {
	  Assert.assertEquals(mansarddach.isStrasse_benoetigt(), true);
  }

}
