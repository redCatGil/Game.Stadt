package redCat.Churchill.Stadt.Bauwerke.impl;

import redCat.Churchill.Stadt.Bauwerke.api.Produktionsgebaeude_api;
import redCat.Churchill.Stadt.Enumeration.Gebaeude_Art_enum;

public class Produktionsgebaeude extends Gebaeude implements Produktionsgebaeude_api {
	
	private Integer in_5_Minuten;
	private Integer in_15_Minuten;
	private Integer in_1_Stunde;
	private Integer in_4_Stunden;
	private Integer in_8_Stunden;
	private Integer in_1_Tag;
	private String name_5_min;
	private String name_15_min;
	private String name_1_h;
	private String name_4_h;
	private String name_8_h;
	private String name_1_t;
	private String gebaeude_art;
	
	/* ***********************************************************************************************
	 * 
	 *  Konstruktoren
	 * 
	 * *********************************************************************************************** 
	 */
	
	public Produktionsgebaeude() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Produktionsgebäudekonstruktur
	 * Dieser Konstruktor ruft die Erzeugung eines Gebäudes auf. 
	 * 
	 * @param name           - Name des Gebäudes
	 * @param zeitalter      - Zeitalter als String
	 * @param muenzen		 - Anzahl Münzen die zur Erstellung benötigt werden
	 * @param werkzeug	     - Anzahl Werkzeug die zur Erstellung benötigt werden
	 * @param personen       - Anzahl Personen die zur Erstellung benötigt werden
	 * @param diamanten      - Anzahl Diamanten die zur Erstellung benötigt werden
	 * @param laenge         - Grundfläche des Gebäudes - Längenangabe 
	 * @param breite         - Grundfläche des Gebäudes - Breitenangabe
	 * @param zeit           - Erstellungszeit als int-Wert in Sekunden
	 * @param in_5_min		 - Anzahl der Werkzeuge, die in 5 Minuten hergestellt werden
	 * @param in_15_min      - Anzahl der Werkzeuge, die in 15 Minuten hergestellt werden
	 * @param in_1_h         - Anzahl der Werkzeuge, die in 1 Stunde hergestellt werden
	 * @param in_4_h         - Anzahl der Werkzeuge, die in 4 Stunden hergestellt werden
	 * @param in_8_h         - Anzahl der Werkzeuge, die in 8 Stunden hergestellt werden
	 * @param in_1_tag       - Anzahl der Werkzeuge, die in einem Tag hergestellt werden
	 */ 
	public Produktionsgebaeude(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten,
			int laenge, int breite, int zeit, boolean strasse, int in_5_min, int in_15_min, int in_1_h,
			int in_4_h, int in_8_h, int in_1_tag, String name_5_min, String name_15_min, String name_1_h, 
			String name_4_h, String name_8_h, String name_1_t, String gebaeude_art) {
		
		//aufruf des übergeordneten Konstruktors
		super(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, zeit, strasse);
		
		//neue Attribute setzen
		this.in_5_Minuten = new Integer(in_5_min);
		this.in_15_Minuten = new Integer(in_15_min);
		this.in_1_Stunde = new Integer(in_1_h);
		this.in_4_Stunden = new Integer(in_4_h);
		this.in_8_Stunden = new Integer(in_8_h);
		this.in_1_Tag = new Integer(in_1_tag);
		this.name_5_min = name_5_min;
		this.name_15_min = name_15_min;
		this.name_1_h = name_1_h;
		this.name_4_h = name_4_h;
		this.name_8_h = name_8_h;
		this.name_1_t = name_1_t;
		
		this.gebaeude_art = Gebaeude_Art_enum.valueOf(gebaeude_art).toString();
	}
	
	/* ***********************************************************************************************
	 * 
	 *  Getter- und Setter-Funktionen
	 * 
	 * *********************************************************************************************** 
	 */
	
	//***************************** Anzahl WZ in 5 Minuten ********************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getIn_5_Minuten()
	 */
	public Integer getIn_5_Minuten() {
		return in_5_Minuten;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setIn_5_Minuten(java.lang.Integer)
	 */
	public void setIn_5_Minuten(Integer in_5_Minuten) {
		this.in_5_Minuten = in_5_Minuten;
	}

	//***************************** Anzahl WZ in 15 Minuten *******************************************
	
	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getIn_15_Minuten()
	 */
	public Integer getIn_15_Minuten() {
		return in_15_Minuten;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setIn_15_Minuten(java.lang.Integer)
	 */
	public void setIn_15_Minuten(Integer in_15_Minuten) {
		this.in_15_Minuten = in_15_Minuten;
	}

	//***************************** Anzahl WZ in 1 Stunde **********************************************
	
	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getIn_1_Stunde()
	 */
	public Integer getIn_1_Stunde() {
		return in_1_Stunde;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setIn_1_Stunde(java.lang.Integer)
	 */
	public void setIn_1_Stunde(Integer in_1_Stunde) {
		this.in_1_Stunde = in_1_Stunde;
	}
	
	//***************************** Anzahl WZ in 4 Stunden **********************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getIn_4_Stunden()
	 */
	public Integer getIn_4_Stunden() {
		return in_4_Stunden;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setIn_4_Stunden(java.lang.Integer)
	 */
	public void setIn_4_Stunden(Integer in_4_Stunden) {
		this.in_4_Stunden = in_4_Stunden;
	}
	
	//***************************** Anzahl WZ in 8 Stunden **********************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getIn_8_Stunden()
	 */
	public Integer getIn_8_Stunden() {
		return in_8_Stunden;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setIn_8_Stunden(java.lang.Integer)
	 */
	public void setIn_8_Stunden(Integer in_8_Stunden) {
		this.in_8_Stunden = in_8_Stunden;
	}
	
	//***************************** Anzahl WZ in 1 Tag **************************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getIn_1_Tag()
	 */
	public Integer getIn_1_Tag() {
		return in_1_Tag;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setIn_1_Tag(java.lang.Integer)
	 */
	public void setIn_1_Tag(Integer in_1_Tag) {
		this.in_1_Tag = in_1_Tag;
	}
	
	//***************************** Name der Produktion in 5 Minuten **************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getName_5_min()
	 */
	public String getName_5_min() {
		return name_5_min;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setName_5_min(java.lang.String)
	 */
	public void setName_5_min(String name_5_min) {
		this.name_5_min = name_5_min;
	}
	
	//***************************** Name der Produktion in 15 Minuten *************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getName_15_min()
	 */
	public String getName_15_min() {
		return name_15_min;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setName_15_min(java.lang.String)
	 */
	public void setName_15_min(String name_15_min) {
		this.name_15_min = name_15_min;
	}
	
	//***************************** Name der Produktion in 1 Stunde **************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getName_1_h()
	 */
	public String getName_1_h() {
		return name_1_h;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setName_1_h(java.lang.String)
	 */
	public void setName_1_h(String name_1_h) {
		this.name_1_h = name_1_h;
	}
	
	//***************************** Name der Produktion in 4 Stunden **************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getName_4_h()
	 */
	public String getName_4_h() {
		return name_4_h;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setName_4_h(java.lang.String)
	 */
	public void setName_4_h(String name_4_h) {
		this.name_4_h = name_4_h;
	}
	
	//***************************** Name der Produktion in 8 Stunden **************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getName_8_h()
	 */
	public String getName_8_h() {
		return name_8_h;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setName_8_h(java.lang.String)
	 */
	public void setName_8_h(String name_8_h) {
		this.name_8_h = name_8_h;
	}
	
	//***************************** Name der Produktion in 1 Tag ******************************************

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#getName_1_t()
	 */
	public String getName_1_t() {
		return name_1_t;
	}

	/* (non-Javadoc)
	 * @see redCat.Game.bauwerke.impl.Produktion#setName_1_t(java.lang.String)
	 */
	public void setName_1_t(String name_1_t) {
		this.name_1_t = name_1_t;
	}
	
	//***************************** Art des Gebäudes ******************************************
	
	public String getGebaeude_art() {
		return gebaeude_art;
	}

	public void setGebaeude_art(String gebaeude_art) {
		this.gebaeude_art = Gebaeude_Art_enum.valueOf(gebaeude_art).toString();
		
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
		return super.toString()+"Produktionsgebaeude [in_5_Minuten=" + in_5_Minuten
				+ ", in_15_Minuten=" + in_15_Minuten + ", in_1_Stunde="
				+ in_1_Stunde + ", in_4_Stunden=" + in_4_Stunden
				+ ", in_8_Stunden=" + in_8_Stunden + ", in_1_Tag=" + in_1_Tag
				+ ", name_5_min=" + name_5_min + ", name_15_min=" + name_15_min
				+ ", name_1_h=" + name_1_h + ", name_4_h=" + name_4_h
				+ ", name_8_h=" + name_8_h + ", name_1_t=" + name_1_t + "]";
	}

	public Integer berechneProduktion(Integer produktion, Integer faktor) {
		double fak = faktor / 100.0;
		double prod = produktion * fak + 0.5;
		return new Integer((int) prod);
	}
	
	/**
	 * Die Funktion berechnet die Werkzeugmenge die eine Einstundenproduktion herstellt, in Bezug auf die Fläche.
	 * Es wird auf zwei Nachkommastellen gerundet.
	 */
	public Double berechneWZQuotient( ) {
		int flaeche = this.getLaenge().intValue() * this.getBreite().intValue();
		double quotient = this.in_1_Stunde.doubleValue() / flaeche;
		quotient = Math.rint(quotient * 100) / 100; 
		System.out.println("Fläche: " + flaeche + " Quotient: " + quotient);
		return new Double(quotient);
	}

	
	
	
	

}
