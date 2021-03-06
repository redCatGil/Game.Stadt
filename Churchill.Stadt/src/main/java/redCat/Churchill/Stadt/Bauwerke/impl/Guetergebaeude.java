package redCat.Churchill.Stadt.Bauwerke.impl;

import java.util.GregorianCalendar;

import redCat.Churchill.Stadt.Bauwerke.api.Guetergebaeude_api;
import redCat.Churchill.Stadt.Enumeration.*;

public class Guetergebaeude extends Gebaeude implements Guetergebaeude_api {
	
	private String produkt;
	private String material;
	private GueterProd in4Stunden;
	private GueterProd in8Stunden;
	private GueterProd in1Tag;
	private GueterProd in2Tagen;
	private String gebaeude_art;

	/* ***********************************************************************************************
	 * 
	 *  Konstruktoren
	 * 
	 * *********************************************************************************************** 
	 */
	

	public Guetergebaeude() {
		// TODO Auto-generated constructor stub
	}

	public Guetergebaeude(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten,
			int laenge, int breite, int zeit, boolean strasse, String produkt, String material, GueterProd in4Stunden,
			GueterProd in8Stunden, GueterProd in1Tag, GueterProd in2Tagen, String gebaeude_art) {
		
		//aufruf des übergeordneten Konstruktors
		super(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, zeit, strasse);
		
		//neue Attribute setzen
		this.init(produkt, material, in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);

	}

	public Guetergebaeude(GregorianCalendar bauzeit, Integer breite, Integer diamanten, Integer laenge, Integer muenzen,
			String name, Integer personen, boolean strasse_benoetigt, Integer werkzeug, String zeitalter, String produkt, String material, GueterProd in4Stunden,
			GueterProd in8Stunden, GueterProd in1Tag, GueterProd in2Tagen, String gebaeude_art) {
		
		//aufruf des übergeordneten Konstruktors
		super(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, bauzeit, strasse_benoetigt);
		
		//neue Attribute setzen
		this.init(produkt, material, in4Stunden, in8Stunden, in1Tag, in2Tagen, gebaeude_art);

	}
	
	/* ***********************************************************************************************
	 * 
	 *  Getter- und Setter-Funktionen
	 * 
	 * *********************************************************************************************** 
	 */
	
	public String getProdukt() {
		return produkt;
	}

	public void setProdukt(String produkt) {
		this.produkt = produkt;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * @return the in4Stunden
	 */
	public GueterProd getIn4Stunden() {
		return in4Stunden;
	}
	
	
	/**
	 * @param in4Stunden the in4Stunden to set
	 */
	public void setIn4Stunden(GueterProd in4Stunden) {
		this.in4Stunden = in4Stunden;
	}

	/**
	 * @return the in8Stunden
	 */
	public GueterProd getIn8Stunden() {
		return in8Stunden;
	}

	/**
	 * @param in8Stunden the in8Stunden to set
	 */
	public void setIn8Stunden(GueterProd in8Stunden) {
		this.in8Stunden = in8Stunden;
	}

	/**
	 * @return the in1Tag
	 */
	public GueterProd getIn1Tag() {
		return in1Tag;
	}

	/**
	 * @param in1Tag the in1Tag to set
	 */
	public void setIn1Tag(GueterProd in1Tag) {
		this.in1Tag = in1Tag;
	}

	/**
	 * @return the in2Tagen
	 */
	public GueterProd getIn2Tagen() {
		return in2Tagen;
	}

	/**
	 * @param in2Tagen the in2Tagen to set
	 */
	public void setIn2Tagen(GueterProd in2Tagen) {
		this.in2Tagen = in2Tagen;
	}
	
	/*  
	 * Get-Methoden für 4-Stunden-Produktion - aufgeteilt in einzelne Attribute 
	 */
	
	public String getIn4StundenName( ) {
		return in4Stunden.getProdName();
	}

	public Integer getIn4StundenMuenzen() {
		return in4Stunden.getProdMuenzen();
	}
	
	public Integer getIn4StundenWZ() {
		return in4Stunden.getProdWZ();
	}
	
	public Integer getIn4StundenMenge() {
		return in4Stunden.getProdMenge();
	}
	
	/*  
	 * Set-Methoden für 4-Stunden-Produktion - aufgeteilt in einzelne Attribute 
	 */
	
//	public void setIn4StundenName(String name) {
//		this.in4Stunden.setProdName(name);
//	}
//	
//	public void setIn4StundenMuenzen(Integer muenzen) {
//		this.in4Stunden.setProdMuenzen(muenzen);
//	}
//	
//	public void setIn4StundenWZ(Integer wz) {
//		this.in4Stunden.setProdWZ(wz);
//	}
//	
//	public void setIn4StundenMenge(Integer menge) {
//		this.in4Stunden.setProdMenge(menge);
//	}
	
	/*  
	 * Get-Methoden für 8-Stunden-Produktion - aufgeteilt in einzelne Attribute 
	 */
	
	public String getIn8StundenName( ) {
		return in8Stunden.getProdName();
	}

	public Integer getIn8StundenMuenzen() {
		return in8Stunden.getProdMuenzen();
	}
	
	public Integer getIn8StundenWZ() {
		return in8Stunden.getProdWZ();
	}
	
	public Integer getIn8StundenMenge() {
		return in8Stunden.getProdMenge();
	}
	
	/*  
	 * Set-Methoden für 8-Stunden-Produktion - aufgeteilt in einzelne Attribute 
	 */
	
//	public void setIn8StundenName(String name) {
//		this.in8Stunden.setProdName(name);
//	}
//	
//	public void setIn8StundenMuenzen(Integer muenzen) {
//		this.in8Stunden.setProdMuenzen(muenzen);
//	}
//	
//	public void setIn8StundenWZ(Integer wz) {
//		this.in8Stunden.setProdWZ(wz);
//	}
//	
//	public void setIn8StundenMenge(Integer menge) {
//		this.in8Stunden.setProdMenge(menge);
//	}
	
	/*  
	 * Get-Methoden für 1-Tag-Produktion - aufgeteilt in einzelne Attribute 
	 */
	
	public String getIn1TagName( ) {
		return in1Tag.getProdName();
	}

	public Integer getIn1TagMuenzen() {
		return in1Tag.getProdMuenzen();
	}
	
	public Integer getIn1TagWZ() {
		return in1Tag.getProdWZ();
	}
	
	public Integer getIn1TagMenge() {
		return in1Tag.getProdMenge();
	}
	
	/*  
	 * Set-Methoden für 1-Tag-Produktion - aufgeteilt in einzelne Attribute 
	 */
	
//	public void setIn1TagName(String name) {
//		this.in1Tag.setProdName(name);
//	}
//	
//	public void setIn1TagMuenzen(Integer muenzen) {
//		this.in1Tag.setProdMuenzen(muenzen);
//	}
//	
//	public void setIn1TagWZ(Integer wz) {
//		this.in1Tag.setProdWZ(wz);
//	}
//	
//	public void setIn1TagMenge(Integer menge) {
//		this.in1Tag.setProdMenge(menge);
//	}
	
	/*  
	 * Get-Methoden für 2-Tag-Produktion - aufgeteilt in einzelne Attribute 
	 */
	
	public String getIn2TagenName( ) {
		return in2Tagen.getProdName();
	}

	public Integer getIn2TagenMuenzen() {
		return in2Tagen.getProdMuenzen();
	}
	
	public Integer getIn2TagenWZ() {
		return in2Tagen.getProdWZ();
	}
	
	public Integer getIn2TagenMenge() {
		return in2Tagen.getProdMenge();
	}

	public String getGebaeude_art() {
		return gebaeude_art;
	}
	
	/*  
	 * Set-Methoden für 2-Tagen-Produktion - aufgeteilt in einzelne Attribute 
	 */
	
//	public void setIn2TagenName(String name) {
//		this.in2Tagen.setProdName(name);
//	}
//	
//	public void setIn2TagenMuenzen(Integer muenzen) {
//		this.in2Tagen.setProdMuenzen(muenzen);
//	}
//	
//	public void setIn2TagenWZ(Integer wz) {
//		this.in2Tagen.setProdWZ(wz);
//	}
//	
//	public void setIn2TagenMenge(Integer menge) {
//		this.in2Tagen.setProdMenge(menge);
//	}
//
//	public String getGebaeude_art() {
//		return gebaeude_art;
//	}
//
	public void setGebaeude_art(String gebaeude_art) {
		try {
			this.gebaeude_art = Gebaeude_Art_enum.valueOf(gebaeude_art).toString();
		} catch (Exception e) {
			this.gebaeude_art = "UNBEKANNT";
		}
	}

	/* ********************************************************************************************************************************
	 *                                                                                                                                *
	 *                         überschriebene Funktionen und Methoden                                                                 *
	 *                                                                                                                                *
	 * ********************************************************************************************************************************                         	
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString()+"Guetergebaeude [produkt=" + produkt + ", material=" + material + ", in4Stunden=" + in4Stunden
				+ ", in8Stunden=" + in8Stunden + ", in1Tag=" + in1Tag + ", in2Tagen=" + in2Tagen + ", gebaeude_art="
				+ gebaeude_art + "]";
	}

	/* ********************************************************************************************************************************
	 *                                                                                                                                *
	 *                         eigene Funktionen und Methoden                                                                         *
	 *                                                                                                                                *
	 * ********************************************************************************************************************************                         	
	 */
	
	private void init(String produkt, String material, GueterProd in4Stunden,GueterProd in8Stunden, GueterProd in1Tag, GueterProd in2Tagen, String gebaeude_art) 
	{
		this.setProdukt(produkt);
		this.setMaterial(material);
		this.setIn4Stunden(in4Stunden);
		this.setIn8Stunden(in8Stunden);
		this.setIn1Tag(in1Tag);
		this.setIn2Tagen(in2Tagen);
		this.setGebaeude_art(gebaeude_art);
		
	}
	

}
