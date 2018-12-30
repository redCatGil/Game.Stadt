package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.GueterProd;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.Weberei;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class WebereiTest {
	
	private Weberei weberei;
	private String name;
	private String zeitalter;
	private int muenzen;
	private int werkzeug;
	private int personen;
	private int diamanten;
	private int laenge;
	private int breite;
	private int bauzeit;
	private String produkt;
	private String material;
	private GueterProd in4Stunden;
	private GueterProd in8Stunden;
	private GueterProd in1Tag;
	private GueterProd in2Tagen;
	private boolean strasse;
	private String gebaeude_art;
	
  
  @BeforeMethod
  public void beforeMethod() {
		Properties props = new Properties();
		String dsn = "ressource/main/xml/weberei1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Weberei wurde nicht gefunden!");
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
		//Weberei init
	    GueterProd gut;
		name = props.getProperty("Name");
		zeitalter = props.getProperty("Zeitalter");
		System.out.println("Münzen: " + props.getProperty("Muenzen"));
		muenzen = new Integer(props.getProperty("Muenzen")).intValue();
		werkzeug = new Integer(props.getProperty("Werkzeug")).intValue();
		diamanten = new Integer(props.getProperty("Diamanten")).intValue();
		laenge = new Integer(props.getProperty("Laenge")).intValue();
		breite = new Integer(props.getProperty("Breite")).intValue();
		bauzeit = new Integer(props.getProperty("Bauzeit")).intValue();
		personen = new Integer(props.getProperty("Personen")).intValue();
		produkt = props.getProperty("Produkt");
		material = props.getProperty("Material");
		gut = new GueterProd();
		gut.setProdName(props.getProperty("4hName"));
		gut.setProdMenge(new Integer(props.getProperty("4hMenge")));
		gut.setProdMuenzen(new Integer(props.getProperty("4hMuenzen")));
		gut.setProdWZ(new Integer(props.getProperty("4hWZ")));
		in4Stunden = gut; 
	//	System.out.println("in 4 h:" + in4Stunden.toString());
		gut = new GueterProd();
		gut.setProdName(props.getProperty("8hName"));
		gut.setProdMenge(new Integer(props.getProperty("8hMenge")));
		gut.setProdMuenzen(new Integer(props.getProperty("8hMuenzen")));
		gut.setProdWZ(new Integer(props.getProperty("8hWZ")));
		in8Stunden = gut;
		gut = new GueterProd();
		gut.setProdName(props.getProperty("1tName"));
		gut.setProdMenge(new Integer(props.getProperty("1tMenge")));
		gut.setProdMuenzen(new Integer(props.getProperty("1tMuenzen")));
		gut.setProdWZ(new Integer(props.getProperty("1tWZ")));
		in1Tag = gut;
		gut = new GueterProd();
		gut.setProdName(props.getProperty("2tName"));
		gut.setProdMenge(new Integer(props.getProperty("2tMenge")));
		gut.setProdMuenzen(new Integer(props.getProperty("2tMuenzen")));
		gut.setProdWZ(new Integer(props.getProperty("2tWZ")));
		in2Tagen = gut; 
		
		gebaeude_art = props.getProperty("Geb_Art");
		if (props.getProperty("Strasse").compareToIgnoreCase("true") == 0) {
			  strasse = true;

		  } else {
			  strasse = false;
		  }
		
		weberei = new Weberei(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, produkt, material, in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);
			           
  }
  
  @Test
  public void name_muss_weberei_sein() {
	  Assert.assertEquals(weberei.getName(), name);
	  Assert.assertEquals(weberei.getName(), "Weberei");
  }
  
  @Test
  public void zeitalter_muss_eisenzeit_sein() {
	  Assert.assertEquals(weberei.getZeitalter(), zeitalter);
	  Assert.assertEquals(weberei.getZeitalter(), "Eisenzeit");
  }
  
  @Test
  public void weberei_kostet_1500_muenzen() {
	  Assert.assertEquals(weberei.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(weberei.getMuenzen().intValue(), 1500);
  }
  
  @Test
  public void weberei_kostest_2400_werkzeug() {
	  Assert.assertEquals(weberei.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(weberei.getWerkzeug().intValue(), 2400);
  }
  
  @Test
  public void weberei_kostet_keine_daimanten() {
	  Assert.assertEquals(weberei.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(weberei.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void weberei_benötigt_230_personen() {
	  Assert.assertEquals(weberei.getPersonen().intValue(), personen);
	  Assert.assertEquals(weberei.getPersonen().intValue(), 230);
  }
  
  @Test
  public void weberei_ist_4_lang() {
	  Assert.assertEquals(weberei.getLaenge().intValue(), laenge);
	  Assert.assertEquals(weberei.getLaenge().intValue(), 4);
  }
  
  @Test
  public void weberei_ist_3_breit() {
	  Assert.assertEquals(weberei.getBreite().intValue(), breite);
	  Assert.assertEquals(weberei.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_weberei_ist_eine_Stunde_30_minuten() {
	  Assert.assertEquals(weberei.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(weberei.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(weberei.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(weberei.getBauzeit().get(Calendar.MINUTE), 30);
	  Assert.assertEquals(weberei.getBauzeit().get(Calendar.HOUR), 1);
	  Assert.assertEquals(weberei.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void weberei_benoetigt_strasse() {
	  Assert.assertEquals(weberei.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(weberei.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void weberei_produkt_ist_stoff() {
	  Assert.assertEquals(weberei.getProdukt(), produkt);
	  Assert.assertEquals(weberei.getProdukt(), "Stoff");
  }
  
  @Test
  public void weberei_material_ist_wolle() {
	  Assert.assertEquals(weberei.getMaterial(), material);
	  Assert.assertEquals(weberei.getMaterial(), "Wolle");
  }
  
  @Test
  public void weberei_produziert_in_4_stunden_gefaerbte_laken() {
	  Assert.assertEquals(weberei.getIn4StundenName(), in4Stunden.getProdName());
	  Assert.assertEquals(weberei.getIn4StundenName(), "Einfacher Stoff");
  }
  
  @Test
  public void weberei_produziert_in_4_stunden_5_stoff() {
	  Assert.assertEquals(weberei.getIn4StundenMenge(), in4Stunden.getProdMenge());
	  Assert.assertEquals(weberei.getIn4StundenMenge().intValue(), 5);
  }
  
  @Test
  public void weberei_kostet_in_4_stunden_200_muenzen() {
	  Assert.assertEquals(weberei.getIn4StundenMuenzen(), in4Stunden.getProdMuenzen());
	  Assert.assertEquals(weberei.getIn4StundenMuenzen().intValue(), 200);
  }
  
  @Test
  public void weberei_kostet_in_4_stunden_200_wz() {
	  Assert.assertEquals(weberei.getIn4StundenWZ(), in4Stunden.getProdWZ());
	  Assert.assertEquals(weberei.getIn4StundenWZ().intValue(), 200);
  }
  
  @Test
  public void weberei_produziert_in_8_stunden_normaler_stoff() {
	  Assert.assertEquals(weberei.getIn8StundenName(), in8Stunden.getProdName());
	  Assert.assertEquals(weberei.getIn8StundenName(), "Normaler Stoff");
  }
  
  @Test
  public void weberei_produziert_in_8_stunden_10_stoff() {
	  Assert.assertEquals(weberei.getIn8StundenMenge(), in8Stunden.getProdMenge());
	  Assert.assertEquals(weberei.getIn8StundenMenge().intValue(), 10);
  }
  
  @Test
  public void weberei_kostet_in_8_stunden_400_muenzen() {
	  Assert.assertEquals(weberei.getIn8StundenMuenzen(), in8Stunden.getProdMuenzen());
	  Assert.assertEquals(weberei.getIn8StundenMuenzen().intValue(), 400);
  }
  
  @Test
  public void weberei_kostet_in_8_stunden_400_wz() {
	  Assert.assertEquals(weberei.getIn8StundenWZ(), in8Stunden.getProdWZ());
	  Assert.assertEquals(weberei.getIn8StundenWZ().intValue(), 400);
  }
  
  @Test
  public void weberei_produziert_in_1_tag_feiner_stoff() {
	  Assert.assertEquals(weberei.getIn1TagName(), in1Tag.getProdName());
	  Assert.assertEquals(weberei.getIn1TagName(), "Feiner Stoff");
  }
  
  @Test
  public void weberei_produziert_in_1_tag_20_stoff() {
	  Assert.assertEquals(weberei.getIn1TagMenge(), in1Tag.getProdMenge());
	  Assert.assertEquals(weberei.getIn1TagMenge().intValue(), 20);
  }
  
  @Test
  public void weberei_kostet_in_1_tag_800_muenzen() {
	  Assert.assertEquals(weberei.getIn1TagMuenzen(), in1Tag.getProdMuenzen());
	  Assert.assertEquals(weberei.getIn1TagMuenzen().intValue(), 800);
  }
  
  @Test
  public void weberei_kostet_in_1_tag_800_wz() {
	  Assert.assertEquals(weberei.getIn1TagWZ(), in1Tag.getProdWZ());
	  Assert.assertEquals(weberei.getIn1TagWZ().intValue(), 800);
  }
  
  
  @Test
  public void weberei_produziert_in_2_tagen_hervorragender_stoff() {
	  Assert.assertEquals(weberei.getIn2TagenName(), in2Tagen.getProdName());
	  Assert.assertEquals(weberei.getIn2TagenName(), "Hervorragender Stoff");
  }
  
  @Test
  public void weberei_produziert_in_2_tagen_30_stoff() {
	  Assert.assertEquals(weberei.getIn2TagenMenge(), in2Tagen.getProdMenge());
	  Assert.assertEquals(weberei.getIn2TagenMenge().intValue(), 30);
  }
  
  @Test
  public void weberei_kostet_in_2_tagen_1200_muenzen() {
	  Assert.assertEquals(weberei.getIn2TagenMuenzen(), in2Tagen.getProdMuenzen());
	  Assert.assertEquals(weberei.getIn2TagenMuenzen().intValue(), 1200);
  }
  
  @Test
  public void weberei_kostet_in_2_tagen_1200_wz() {
	  Assert.assertEquals(weberei.getIn2TagenWZ(), in2Tagen.getProdWZ());
	  Assert.assertEquals(weberei.getIn2TagenWZ().intValue(), 1200);
  }
  @Test
  public void weberei_ist_normales_gebaeude() {
	  Assert.assertEquals(weberei.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(weberei.getGebaeude_art(), "Normal");
  }
 

}
