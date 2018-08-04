package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.Chalet;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class ChaletTest {
	
	private Chalet chalet;
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
		String dsn = "ressource/main/xml/chalet1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Chalet wurde nicht gefunden!");
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
		
		chalet = new Chalet(name, zeitalter, muenzen, werkzeug, diamanten, laenge, breite,
				bauzeit, personen, einnahme, einnahmedauer);
	           
  }
  
  @Test
  public void name_muss_chalet_sein() {
	  Assert.assertEquals(chalet.getName(), name);
	  Assert.assertEquals(chalet.getName(), "Chalet");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(chalet.getZeitalter(), zeitalter);
	  Assert.assertEquals(chalet.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void chalet_kostet_111_muenzen() {
	  Assert.assertEquals(chalet.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(chalet.getMuenzen().intValue(), 111);
  }
  
  @Test
  public void chalet_kostest_344_werkzeug() {
	  Assert.assertEquals(chalet.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(chalet.getWerkzeug().intValue(), 344);
  }
  
  @Test
  public void chalet_kostet_keine_daimanten() {
	  Assert.assertEquals(chalet.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(chalet.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void chalet_ist_2_lang() {
	  Assert.assertEquals(chalet.getLaenge().intValue(), laenge);
	  Assert.assertEquals(chalet.getLaenge().intValue(), 2);
  }
  
  @Test
  public void chalet_ist_2_breit() {
	  Assert.assertEquals(chalet.getBreite().intValue(), breite);
	  Assert.assertEquals(chalet.getBreite().intValue(), 2);
  }
  
  @Test
  public void chalet_pfahlbau_ist_10_Minuten() {
	  Assert.assertEquals(chalet.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(chalet.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(chalet.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(chalet.getBauzeit().get(Calendar.MINUTE), 10);
	  Assert.assertEquals(chalet.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(chalet.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void chalet_hat_32_bewohner() {
	  Assert.assertEquals(chalet.getBewohner().intValue(), personen);
	  Assert.assertEquals(chalet.getBewohner().intValue(), 32);
  }
  
  @Test
  public void chaleteinnahme_ist_80_muenzen() {
	  Assert.assertEquals(chalet.getMuenz_einnahmen().intValue(), einnahme);
	  Assert.assertEquals(chalet.getMuenz_einnahmen().intValue(), 80);
  }
  
  @Test
  public void chalet_hat_alle_14400_sec_einnahmen() {
	  Assert.assertEquals(chalet.getEinnahme_dauer().intValue(), einnahmedauer);
	  Assert.assertEquals(chalet.getEinnahme_dauer().intValue(), 14400);
  }
  
  @Test
  public void pfahlbau_benoetigt_strasse() {
	  Assert.assertEquals(chalet.isStrasse_benoetigt(), true);
  }

}
