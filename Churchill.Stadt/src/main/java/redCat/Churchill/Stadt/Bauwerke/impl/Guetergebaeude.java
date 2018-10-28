package redCat.Churchill.Stadt.Bauwerke.impl;

import java.util.GregorianCalendar;

import redCat.Churchill.Stadt.Bauwerke.api.Guetergebaeude_api;

public class Guetergebaeude extends Gebaeude implements Guetergebaeude_api {
	
	private GueterProd in4Stunden;
	private GueterProd in8Stunden;
	private GueterProd in1Tag;
	private GueterProd in2Tagen;


	

	public Guetergebaeude() {
		// TODO Auto-generated constructor stub
	}

	public Guetergebaeude(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten,
			int laenge, int breite, int zeit, boolean strasse) {
		super(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, zeit, strasse);
		// TODO Auto-generated constructor stub
	}

	public Guetergebaeude(GregorianCalendar bauzeit, Integer breite, Integer diamanten, Integer laenge, Integer muenzen,
			String name, Integer personen, boolean strasse_benoetigt, Integer werkzeug, String zeitalter) {
		super(bauzeit, breite, diamanten, laenge, muenzen, name, personen, strasse_benoetigt, werkzeug, zeitalter);
		// TODO Auto-generated constructor stub
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

}
