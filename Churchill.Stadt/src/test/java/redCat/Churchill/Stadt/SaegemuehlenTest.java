package redCat.Churchill.Stadt;

import org.testng.annotations.Test;

import redCat.Churchill.Stadt.Bauwerke.impl.GueterProd;
import redCat.Churchill.Stadt.Bauwerke.impl.Saegemuehle;
import redCat.Churchill.Stadt.Bauwerke.impl.Toolbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


public class SaegemuehlenTest {
	
	private Saegemuehle saegemuehle;
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
		String dsn = "ressource/main/xml/saegemuehle1.xml";
		FileInputStream inFile;
	  
		try {
			inFile = new FileInputStream(dsn);
			 props.loadFromXML(inFile);
		//File nicht gefunden
		} catch (FileNotFoundException e) {
			System.err.println("Die XML-Datei für die Sägemühle wurde nicht gefunden!");
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
		//Sägemühlen init
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
		
		saegemuehle = new Saegemuehle(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse, produkt, material, in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);
			           
  }
  
  @Test
  public void name_muss_saegemuehle_sein() {
	  Assert.assertEquals(saegemuehle.getName(), name);
	  Assert.assertEquals(saegemuehle.getName(), "Sägemühle");
  }
  
  @Test
  public void zeitalter_muss_bronzezeit_sein() {
	  Assert.assertEquals(saegemuehle.getZeitalter(), zeitalter);
	  Assert.assertEquals(saegemuehle.getZeitalter(), "Bronzezeit");
  }
  
  @Test
  public void saegemuehle_kostet_232_muenzen() {
	  Assert.assertEquals(saegemuehle.getMuenzen().intValue(), muenzen);
	  Assert.assertEquals(saegemuehle.getMuenzen().intValue(), 232);
  }
  
  @Test
  public void saegemuehle_kostest_465_werkzeug() {
	  Assert.assertEquals(saegemuehle.getWerkzeug().intValue(), werkzeug);
	  Assert.assertEquals(saegemuehle.getWerkzeug().intValue(), 465);
  }
  
  @Test
  public void saegemuehle_kostet_keine_daimanten() {
	  Assert.assertEquals(saegemuehle.getDiamanten().intValue(), diamanten);
	  Assert.assertEquals(saegemuehle.getDiamanten().intValue(), 0);
  }
  
  @Test
  public void saegemuehle_benötigt_108_personen() {
	  Assert.assertEquals(saegemuehle.getPersonen().intValue(), personen);
	  Assert.assertEquals(saegemuehle.getPersonen().intValue(), 108);
  }
  
  @Test
  public void saegemuehle_ist_3_lang() {
	  Assert.assertEquals(saegemuehle.getLaenge().intValue(), laenge);
	  Assert.assertEquals(saegemuehle.getLaenge().intValue(), 3);
  }
  
  @Test
  public void saegemuehle_ist_3_breit() {
	  Assert.assertEquals(saegemuehle.getBreite().intValue(), breite);
	  Assert.assertEquals(saegemuehle.getBreite().intValue(), 3);
  }
  
  @Test
  public void bauzeit_saegemuehle_ist_30_minuten() {
	  Assert.assertEquals(saegemuehle.getBauzeit().get(Calendar.SECOND), Toolbox.ermittleSekunden(bauzeit));
	  Assert.assertEquals(saegemuehle.getBauzeit().get(Calendar.MINUTE), Toolbox.ermittleMinuten(bauzeit));
	  Assert.assertEquals(saegemuehle.getBauzeit().get(Calendar.HOUR), Toolbox.ermittleStunden(bauzeit));
	  Assert.assertEquals(saegemuehle.getBauzeit().get(Calendar.MINUTE), 30);
	  Assert.assertEquals(saegemuehle.getBauzeit().get(Calendar.HOUR), 0);
	  Assert.assertEquals(saegemuehle.getBauzeit().get(Calendar.SECOND), 0);
  }
  
  @Test
  public void saegemuehle_benoetigt_strasse() {
	  Assert.assertEquals(saegemuehle.isStrasse_benoetigt(), strasse);
	  Assert.assertEquals(saegemuehle.isStrasse_benoetigt(), true);
  }
  
  @Test
  public void saegemuehle_produkt_ist_holz() {
	  Assert.assertEquals(saegemuehle.getProdukt(), produkt);
	  Assert.assertEquals(saegemuehle.getProdukt(), "Holz");
  }
  
  @Test
  public void saegemuehle_material_ist_baum() {
	  Assert.assertEquals(saegemuehle.getMaterial(), material);
	  Assert.assertEquals(saegemuehle.getMaterial(), "Baum");
  }
  
  @Test
  public void saegemuehle_produziert_in_4_stunden_holzstuecke() {
	  Assert.assertEquals(saegemuehle.getIn4StundenName(), in4Stunden.getProdName());
	  Assert.assertEquals(saegemuehle.getIn4StundenName(), "Holzstücke");
  }
  
  @Test
  public void saegemuehle_produziert_in_4_stunden_5_holz() {
	  Assert.assertEquals(saegemuehle.getIn4StundenMenge(), in4Stunden.getProdMenge());
	  Assert.assertEquals(saegemuehle.getIn4StundenMenge().intValue(), 5);
  }
  
  @Test
  public void saegemuehle_kostet_in_4_stunden_100_muenzen() {
	  Assert.assertEquals(saegemuehle.getIn4StundenMuenzen(), in4Stunden.getProdMuenzen());
	  Assert.assertEquals(saegemuehle.getIn4StundenMuenzen().intValue(), 100);
  }
  
  @Test
  public void saegemuehle_kostet_in_4_stunden_100_wz() {
	  Assert.assertEquals(saegemuehle.getIn4StundenWZ(), in4Stunden.getProdWZ());
	  Assert.assertEquals(saegemuehle.getIn4StundenWZ().intValue(), 100);
  }
  
  @Test
  public void saegemuehle_produziert_in_8_stunden_etwas_holz() {
	  Assert.assertEquals(saegemuehle.getIn8StundenName(), in8Stunden.getProdName());
	  Assert.assertEquals(saegemuehle.getIn8StundenName(), "Etwas Holz");
  }
  
  @Test
  public void saegemuehle_produziert_in_8_stunden_10_holz() {
	  Assert.assertEquals(saegemuehle.getIn8StundenMenge(), in8Stunden.getProdMenge());
	  Assert.assertEquals(saegemuehle.getIn8StundenMenge().intValue(), 10);
  }
  
  @Test
  public void saegemuehle_kostet_in_8_stunden_200_muenzen() {
	  Assert.assertEquals(saegemuehle.getIn8StundenMuenzen(), in8Stunden.getProdMuenzen());
	  Assert.assertEquals(saegemuehle.getIn8StundenMuenzen().intValue(), 200);
  }
  
  @Test
  public void saegemuehle_kostet_in_8_stunden_200_wz() {
	  Assert.assertEquals(saegemuehle.getIn8StundenWZ(), in8Stunden.getProdWZ());
	  Assert.assertEquals(saegemuehle.getIn8StundenWZ().intValue(), 200);
  }
  
  @Test
  public void saegemuehle_produziert_in_1_tag_viel_holz() {
	  Assert.assertEquals(saegemuehle.getIn1TagName(), in1Tag.getProdName());
	  Assert.assertEquals(saegemuehle.getIn1TagName(), "Viel Holz");
  }
  
  @Test
  public void saegemuehle_produziert_in_1_tag_20_holz() {
	  Assert.assertEquals(saegemuehle.getIn1TagMenge(), in1Tag.getProdMenge());
	  Assert.assertEquals(saegemuehle.getIn1TagMenge().intValue(), 20);
  }
  
  @Test
  public void saegemuehle_kostet_in_1_tag_400_muenzen() {
	  Assert.assertEquals(saegemuehle.getIn1TagMuenzen(), in1Tag.getProdMuenzen());
	  Assert.assertEquals(saegemuehle.getIn1TagMuenzen().intValue(), 400);
  }
  
  @Test
  public void saegemuehle_kostet_in_1_tag_400_wz() {
	  Assert.assertEquals(saegemuehle.getIn1TagWZ(), in1Tag.getProdWZ());
	  Assert.assertEquals(saegemuehle.getIn1TagWZ().intValue(), 400);
  }
  
  
  @Test
  public void saegemuehle_produziert_in_2_tagen_eine_menge_holz() {
	  Assert.assertEquals(saegemuehle.getIn2TagenName(), in2Tagen.getProdName());
	  Assert.assertEquals(saegemuehle.getIn2TagenName(), "Eine Menge Holz");
  }
  
  @Test
  public void saegemuehle_produziert_in_2_tagen_30_holz() {
	  Assert.assertEquals(saegemuehle.getIn2TagenMenge(), in2Tagen.getProdMenge());
	  Assert.assertEquals(saegemuehle.getIn2TagenMenge().intValue(), 30);
  }
  
  @Test
  public void saegemuehle_kostet_in_2_tagen_600_muenzen() {
	  Assert.assertEquals(saegemuehle.getIn2TagenMuenzen(), in2Tagen.getProdMuenzen());
	  Assert.assertEquals(saegemuehle.getIn2TagenMuenzen().intValue(), 600);
  }
  
  @Test
  public void saegemuehle_kostet_in_2_tagen_600_wz() {
	  Assert.assertEquals(saegemuehle.getIn2TagenWZ(), in2Tagen.getProdWZ());
	  Assert.assertEquals(saegemuehle.getIn2TagenWZ().intValue(), 600);
  }
  @Test
  public void saegemuehle_ist_normales_gebaeude() {
	  Assert.assertEquals(saegemuehle.getGebaeude_art(), gebaeude_art);
	  Assert.assertEquals(saegemuehle.getGebaeude_art(), "Normal");
  }
 

}
