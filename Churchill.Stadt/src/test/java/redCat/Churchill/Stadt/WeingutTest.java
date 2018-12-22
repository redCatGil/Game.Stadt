package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.GueterProd;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;
import redCat.Churchill.Stadt.Bauwerke.impl.Weingut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class WeingutTest {
	
	private Weingut weingut;
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
		String dsn = "ressource/main/xml/weingut1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für das Weingut wurde nicht gefunden!");
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
		//Weingut init
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
		
		weingut = new Weingut(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, produkt, material, in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);
			           
  }
  
  @Test
  public void name_muss_weingut_sein() {
	  Assert.assertEquals(weingut.getName(), name);
	  Assert.assertEquals(weingut.getName(), "Weingut");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(weingut.getZeitalter(), zeitalter);
	  Assert.assertEquals(weingut.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void weingut_kostet_232_muenzen() {
	  Assert.assertEquals(weingut.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(weingut.getMuenzen().intValue(), 232);
  }
  
  @Test
  public void weingut_kostest_465_werkzeug() {
	  Assert.assertEquals(weingut.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(weingut.getWerkzeug().intValue(), 465);
  }
  
  @Test
  public void weingut_kostet_keine_daimanten() {
	  Assert.assertEquals(weingut.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(weingut.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void weingut_benötigt_108_personen() {
	  Assert.assertEquals(weingut.getPersonen().intValue(), personen);
	  Assert.assertEquals(weingut.getPersonen().intValue(), 108);
  }
  
  @Test
  public void weingut_ist_3_lang() {
	  Assert.assertEquals(weingut.getLaenge().intValue(), laenge);
	  Assert.assertEquals(weingut.getLaenge().intValue(), 3);
  }
  
  @Test
  public void weingut_ist_3_breit() {
	  Assert.assertEquals(weingut.getBreite().intValue(), breite);
	  Assert.assertEquals(weingut.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_weingut_ist_30_minuten() {
	  Assert.assertEquals(weingut.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(weingut.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(weingut.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(weingut.getBauzeit().get(Calendar.MINUTE), 30);
	  Assert.assertEquals(weingut.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(weingut.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void weingut_benoetigt_strasse() {
	  Assert.assertEquals(weingut.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(weingut.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void weingut_produkt_ist_wein() {
	  Assert.assertEquals(weingut.getProdukt(), produkt);
	  Assert.assertEquals(weingut.getProdukt(), "Wein");
  }
  
  @Test
  public void weingut_material_ist_trauben() {
	  Assert.assertEquals(weingut.getMaterial(), material);
	  Assert.assertEquals(weingut.getMaterial(), "Trauben");
  }
  
  @Test
  public void weingut_produziert_in_4_stunden_trauben() {
	  Assert.assertEquals(weingut.getIn4StundenName(), in4Stunden.getProdName());
	  Assert.assertEquals(weingut.getIn4StundenName(), "Trauben");
  }
  
  @Test
  public void weingut_produziert_in_4_stunden_5_wein() {
	  Assert.assertEquals(weingut.getIn4StundenMenge(), in4Stunden.getProdMenge());
	  Assert.assertEquals(weingut.getIn4StundenMenge().intValue(), 5);
  }
  
  @Test
  public void weingut_kostet_in_4_stunden_100_muenzen() {
	  Assert.assertEquals(weingut.getIn4StundenMuenzen(), in4Stunden.getProdMuenzen());
	  Assert.assertEquals(weingut.getIn4StundenMuenzen().intValue(), 100);
  }
  
  @Test
  public void weingut_kostet_in_4_stunden_100_wz() {
	  Assert.assertEquals(weingut.getIn4StundenWZ(), in4Stunden.getProdWZ());
	  Assert.assertEquals(weingut.getIn4StundenWZ().intValue(), 100);
  }
  
  @Test
  public void weingut_produziert_in_8_stunden_etwas_wein() {
	  Assert.assertEquals(weingut.getIn8StundenName(), in8Stunden.getProdName());
	  Assert.assertEquals(weingut.getIn8StundenName(), "Etwas Wein");
  }
  
  @Test
  public void weingut_produziert_in_8_stunden_10_wein() {
	  Assert.assertEquals(weingut.getIn8StundenMenge(), in8Stunden.getProdMenge());
	  Assert.assertEquals(weingut.getIn8StundenMenge().intValue(), 10);
  }
  
  @Test
  public void weingut_kostet_in_8_stunden_200_muenzen() {
	  Assert.assertEquals(weingut.getIn8StundenMuenzen(), in8Stunden.getProdMuenzen());
	  Assert.assertEquals(weingut.getIn8StundenMuenzen().intValue(), 200);
  }
  
  @Test
  public void weingut_kostet_in_8_stunden_200_wz() {
	  Assert.assertEquals(weingut.getIn8StundenWZ(), in8Stunden.getProdWZ());
	  Assert.assertEquals(weingut.getIn8StundenWZ().intValue(), 200);
  }
  
  @Test
  public void weingut_produziert_in_1_tag_viel_wein() {
	  Assert.assertEquals(weingut.getIn1TagName(), in1Tag.getProdName());
	  Assert.assertEquals(weingut.getIn1TagName(), "Viel Wein");
  }
  
  @Test
  public void weingut_produziert_in_1_tag_20_wein() {
	  Assert.assertEquals(weingut.getIn1TagMenge(), in1Tag.getProdMenge());
	  Assert.assertEquals(weingut.getIn1TagMenge().intValue(), 20);
  }
  
  @Test
  public void weingut_kostet_in_1_tag_400_muenzen() {
	  Assert.assertEquals(weingut.getIn1TagMuenzen(), in1Tag.getProdMuenzen());
	  Assert.assertEquals(weingut.getIn1TagMuenzen().intValue(), 400);
  }
  
  @Test
  public void weingut_kostet_in_1_tag_400_wz() {
	  Assert.assertEquals(weingut.getIn1TagWZ(), in1Tag.getProdWZ());
	  Assert.assertEquals(weingut.getIn1TagWZ().intValue(), 400);
  }
  
  
  @Test
  public void weingut_produziert_in_2_tagen_luxuswein() {
	  Assert.assertEquals(weingut.getIn2TagenName(), in2Tagen.getProdName());
	  Assert.assertEquals(weingut.getIn2TagenName(), "Luxuswein");
  }
  
  @Test
  public void weingut_produziert_in_2_tagen_30_wein() {
	  Assert.assertEquals(weingut.getIn2TagenMenge(), in2Tagen.getProdMenge());
	  Assert.assertEquals(weingut.getIn2TagenMenge().intValue(), 30);
  }
  
  @Test
  public void weingut_kostet_in_2_tagen_600_muenzen() {
	  Assert.assertEquals(weingut.getIn2TagenMuenzen(), in2Tagen.getProdMuenzen());
	  Assert.assertEquals(weingut.getIn2TagenMuenzen().intValue(), 600);
  }
  
  @Test
  public void weingut_kostet_in_2_tagen_600_wz() {
	  Assert.assertEquals(weingut.getIn2TagenWZ(), in2Tagen.getProdWZ());
	  Assert.assertEquals(weingut.getIn2TagenWZ().intValue(), 600);
  }
  @Test
  public void weingut_ist_normales_gebaeude() {
	  Assert.assertEquals(weingut.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(weingut.getGebaeude_art(), "Normal");
  }
 

}
