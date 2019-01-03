package redCat.Churchill.Stadt.Bauwerke.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import redCat.Churchill.Stadt.Bauwerke.api.Gebaeude_api;
import redCat.Churchill.Stadt.Enumeration.*;
import redCat.Churchill.Stadt.Tools.Bauwerke_Tools;



public class Gebaeude implements Gebaeude_api {
	private String name;
	private String zeitalter;
	private Integer muenzen;
	private Integer werkzeug;
	private Integer personen;
	private Integer diamanten;
	private Integer laenge;
	private Integer breite;
	private GregorianCalendar bauzeit;
	private boolean strasse_benoetigt;
	
	/* ***********************************************************************************************
	 * 
	 *  Konstruktoren
	 * 
	 * *********************************************************************************************** 
	 */
	
	/**
	 * leerer Standardkonstruktor - es werden keine Werte gesetzt
	 */
	public Gebaeude()
	{
		//leerer Konstruktor
	}
	
	/**
	 * Konstruktor für einige Attribute:
	 * 
	 * @param name
	 * @param zeitalter
	 * @param muenzen
	 * @param werkzeug
	 * @param personen
	 * @param diamanten
	 * @param laenge
	 * @param breite
	 * @param strasse
	 */
	public Gebaeude(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten, int laenge, int breite,
			boolean strasse) {
		
		this.setName(name);
		this.setZeitalter(zeitalter);
		this.setMuenzen(new Integer(muenzen));
		this.setWerkzeug(new Integer(werkzeug));
		this.setPersonen(new Integer(personen));
		this.setDiamanten(new Integer(diamanten));
		this.setLaenge(new Integer(laenge));
		this.setBreite(new Integer(breite));
		this.setStrasse_benoetigt(strasse);
		
	}
	
	/**
	 * Konstruktor, der int statt der Wrapperklasse Integer bzw. Kalender benutzt
	 * 
	 * @param name 			 - Name des Gebäudes
	 * @param zeitalter		 - Zeitalter als String
	 * @param muenzen		 - Anzahl Münzen die zur Erstellung benötigt werden
	 * @param werkzeug		 - Anzahl Werkzeug die zur Erstellung benötigt werden
	 * @param personen		 - Anzahl der Personen die durch das Gebäude gebunden werden
	 * @param diamanten		 - Anzahl Diamanten die zur Erstellung benätigt werden
	 * @param laenge		 - Grundfläche des Gebäudes - Längenangabe
	 * @param breite		 - Grundfläche des Gebäudes - Breitenangabe
	 * @param zeit			 - Erstellungszeit
	 * @param strasse		 - Wert ob das Gebäude an einer Strasse stehen muss
	 * 
	 * Nur das Attribut "zeit" wird in diesem Konstruktor in ein GregorianCalendar-Objekt umgesetzt. 
	 * Der Rest wird über den Konstruktor für einige Attribute übernommen.
	 * 
	 */
	public Gebaeude(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten, int laenge, int breite,
			int zeit, boolean strasse) {
		
		this(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, strasse);

		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY,Toolbox.ermittleStunden(zeit));
		cal.set(Calendar.HOUR,Toolbox.ermittleStunden(zeit));
		cal.set(Calendar.MINUTE,Toolbox.ermittleMinuten(zeit));
		cal.set(Calendar.SECOND,Toolbox.ermittleSekunden(zeit));
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.YEAR,2017);
		cal.set(Calendar.MONTH,Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH,1);
		this.setBauzeit(cal);
		System.out.println("Bauzeit: " + this.bauzeit.toString());
	}
	
	/**
	 * Konstruktor, der int statt der Wrapperklasse Integer.
	 * Im gegensatz zum obigen Konstruktor arbeitet dieser mit einem GregorianCalender als Bauzeit-Typ.
	 * 
	 * @param bauzeit                  - Erstellungszeit als GregorianCalender
	 * @param breite                   - Grundfläche des Gebäudes - Breitenangabe
	 * @param diamanten                - Anzahl Diamanten die zur Erstellung benätigt werden
	 * @param laenge                   - Grundfläche des Gebäudes - Längenangabe
	 * @param muenzen                  - Anzahl Münzen die zur Erstellung benötigt werden
	 * @param name                     - Name des Gebäudes
	 * @param personen                 - Anzahl der Personen die durch das Gebäude gebunden werden
	 * @param strasse_benoetigt        - Wert ob das Gebäude an einer Strasse stehen muss
	 * @param werkzeug                 - Anzahl Werkzeug die zur Erstellung benätigt werden
	 * @param zeitalter                - Zeitalter als String
	 * 
	 * Nur das Attribut "bauzeit" wird in diesem Konstruktor übergeben. 
	 * Der Rest wird über den Konstruktor für einige Attribute übernommen.
	 */ 
	public Gebaeude(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten, int laenge, int breite,
			GregorianCalendar bauzeit, boolean strasse_benoetigt) {
		
		this(name, zeitalter, muenzen, werkzeug, personen, diamanten, laenge, breite, strasse_benoetigt);
		this.bauzeit = bauzeit;

	}

	
	/* ***********************************************************************************************
	 * 
	 *  Getter- und Setter-Funktionen
	 * 
	 * *********************************************************************************************** 
	 */
	
	//***************************** Name *************************************************************
	
	/**
	 * Funktion gibt den Namen des Gebäudes zurück
	 * @return the name als String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Funktion setzt den Names des Gebäudes auf den übergebenen Wert
	 * @param name - String - the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	//***************************** Zeitalter *********************************************************
	
	/**
	 * Liefert das Zeitalter des Geb�udes als String zur�ck
	 * @return the zeitalter als String
	 */
	public String getZeitalter() {
		return zeitalter;
	}

	/**
	 * Funktion setzt das Zeitalter. Es wird dabei geprüft, ob der übergebene Wert einem Wert aus der Aufzählung
	 * entspricht. Wenn dies der Fall ist, wird der neue Wert übernommen. 
	 * <br>Im anderen Fall - also wenn der Wert nicht gültig ist - wird UNBEKANNT gesetzt.
	 * 
	 * @param zeitalter - String - the zeitalter to set
	 */
	public void setZeitalter(String zeitalter) {
		 try {
			this.zeitalter = Zeitalter.valueOf(zeitalter).name();
		} catch (IllegalArgumentException e) {
			this.zeitalter = Zeitalter.UNBEKANNT.name();
		}
	}
	
	//***************************** M�nzen *************************************************************

	/**
	 * @return the muenzen
	 */
	public Integer getMuenzen() {
		return muenzen;
	}

	/**
	 * @param muenzen the muenzen to set
	 */
	public void setMuenzen(Integer muenzen) {
		this.muenzen = muenzen;
	}

	
	//***************************** Werkzeug *************************************************************
	
	/**
	 * @return the werkzeug
	 */
	public Integer getWerkzeug() {
		return werkzeug;
	}

	/**
	 * @param werkzeug the werkzeug to set
	 */
	public void setWerkzeug(Integer werkzeug) {
		this.werkzeug = werkzeug;
	}

	//***************************** Personen *************************************************************
	
	/**
	 * @return the personen
	 */
	public Integer getPersonen() {
		return personen;
	}

	/**
	 * @param personen the personen to set
	 */
	public void setPersonen(Integer personen) {
		this.personen = personen;
	}

	//***************************** Diamanten *************************************************************
	
	/**
	 * @return the diamanten
	 */
	public Integer getDiamanten() {
		return diamanten;
	}

	/**
	 * @param diamanten the diamanten to set
	 */
	public void setDiamanten(Integer diamanten) {
		this.diamanten = diamanten;
	}

	//***************************** L�nge der Grundfl�che ******************************************************
	
	/**
	 * @return the laenge
	 */
	public Integer getLaenge() {
		return laenge;
	}

	/**
	 * @param laenge the laenge to set
	 */
	public void setLaenge(Integer laenge) {
		this.laenge = laenge;
	}
	
	//***************************** Breite der Grundfl�che ********************************************************

	/**
	 * @return the breite
	 */
	public Integer getBreite() {
		return breite;
	}

	/**
	 * @param breite the breite to set
	 */
	public void setBreite(Integer breite) {
		this.breite = breite;
	}

	//***************************** Bauzeit *************************************************************
	
	/**
	 * @return the bauzeit
	 */
	public GregorianCalendar getBauzeit() {
		return bauzeit;
	}

	/**
	 * @param bauzeit the bauzeit to set
	 */
	public void setBauzeit(GregorianCalendar bauzeit) {
		this.bauzeit = bauzeit;
	}
	
	//***************************** Strasse ben�tigt *************************************************************

	/**
	 * @return the strasse_benoetigt
	 */
	public boolean isStrasse_benoetigt() {
		return strasse_benoetigt;
	}

	/**
	 * @param strasse_benoetigt the strasse_benoetigt to set
	 */
	public void setStrasse_benoetigt(boolean strasse_benoetigt) {
		this.strasse_benoetigt = strasse_benoetigt;
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
		return "Gebaeude [name=" + name + ", zeitalter=" + zeitalter
				+ ", muenzen=" + muenzen + ", werkzeug=" + werkzeug
				+ ", personen=" + personen + ", diamanten=" + diamanten
				+ ", laenge=" + laenge + ", breite=" + breite + ", bauzeit="
				+ bauzeit + ", strasse_benoetigt=" + strasse_benoetigt + "]";
	}
	
	/* ********************************************************************************************************************************
	 *                                                                                                                                *
	 *                         eigene Funktionen und Methoden                                                                         *
	 *                                                                                                                                *
	 * ********************************************************************************************************************************                         	
	 */
	
	public Double getZeitfaktor() {
		return Bauwerke_Tools.getZeitfaktor(Zeitalter.valueOf(zeitalter));
	}
	
	public Double berechnePunkte(double gebFaktor) {
		int l = this.laenge.intValue();
		int b = this.breite.intValue();
		double zf = getZeitfaktor().doubleValue();
		double punkte = l * b * gebFaktor * zf;
		return new Double(""+punkte);
	}
	
}
