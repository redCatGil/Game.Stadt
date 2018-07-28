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
	 * Konstruktor, der int statt der Wrapperklasse Integer bzw. Kalender benutzt
	 * 
	 * @param name 			 - Name des Geb�udes
	 * @param zeitalter		 - Zeitalter als String
	 * @param muenzen		 - Anzahl M�nzen die zur Erstellung ben�tigt werden
	 * @param werkzeug		 - Anzahl Werkzeug die zur Erstellung ben�tigt werden
	 * @param personen		 - Anzahl der Personen die durch das Geb�ude gebunden werden
	 * @param diamanten		 - Anzahl Diamanten die zur Erstellung ben�tigt werden
	 * @param laenge		 - Grundfl�che des Geb�udes - L�ngenangabe
	 * @param breite		 - Grundfl�che des Geb�udes - Breitenangabe
	 * @param zeit			 - Erstellungszeit
	 * @param strasse		 - Wert ob das Geb�ude an einer Strasse stehen muss
	 * 
	 */
	public Gebaeude(String name, String zeitalter, int muenzen, int werkzeug, int personen, int diamanten, int laenge, int breite,
			int zeit, boolean strasse) {
		this.name = name;
		
		try {
			this.zeitalter = Zeitalter.valueOf(zeitalter).name();
		} catch (IllegalArgumentException e) {
			this.zeitalter = Zeitalter.UNBEKANNT.name();
		}
		
		this.muenzen = new Integer(muenzen);
		this.werkzeug = new Integer(werkzeug);
		this.personen = new Integer(personen);
		this.diamanten = new Integer(diamanten);
		this.laenge = new Integer(laenge);
		this.breite = new Integer(breite);
		this.strasse_benoetigt = strasse;
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY,Toolbox.ermittleStunden(zeit));
		cal.set(Calendar.HOUR,Toolbox.ermittleStunden(zeit));
		cal.set(Calendar.MINUTE,Toolbox.ermittleMinuten(zeit));
		cal.set(Calendar.SECOND,Toolbox.ermittleSekunden(zeit));
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.YEAR,2017);
		cal.set(Calendar.MONTH,Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH,1);
		this.bauzeit = cal;
		System.out.println("Bauzeit: " + this.bauzeit.toString());
	}
	
	/**
	 * Konstruktor, der int statt der Wrapperklasse Integer.
	 * Im gegensatz zum obigen Konstruktor arbeitet dieser mit einem GregorianCalender als Bauzeit-Typ.
	 * 
	 * @param bauzeit                  - Erstellungszeit als GregorianCalender
	 * @param breite                   - Grundfl�che des Geb�udes - Breitenangabe
	 * @param diamanten                - Anzahl Diamanten die zur Erstellung ben�tigt werden
	 * @param laenge                   - Grundfl�che des Geb�udes - L�ngenangabe
	 * @param muenzen                  - Anzahl M�nzen die zur Erstellung ben�tigt werden
	 * @param name                     - Name des Geb�udes
	 * @param personen                 - Anzahl der Personen die durch das Geb�ude gebunden werden
	 * @param strasse_benoetigt        - Wert ob das Geb�ude an einer Strasse stehen muss
	 * @param werkzeug                 - Anzahl Werkzeug die zur Erstellung ben�tigt werden
	 * @param zeitalter                - Zeitalter als String
	 */ 
	public Gebaeude(GregorianCalendar bauzeit, Integer breite,
			Integer diamanten, Integer laenge, Integer muenzen, String name,
			Integer personen, boolean strasse_benoetigt, Integer werkzeug,
			String zeitalter) {
		super();
		this.bauzeit = bauzeit;
		this.breite = breite;
		this.diamanten = diamanten;
		this.laenge = laenge;
		this.muenzen = muenzen;
		this.name = name;
		this.personen = personen;
		this.strasse_benoetigt = strasse_benoetigt;
		this.werkzeug = werkzeug;
		this.zeitalter = zeitalter;
	}

	
	/* ***********************************************************************************************
	 * 
	 *  Getter- und Setter-Funktionen
	 * 
	 * *********************************************************************************************** 
	 */
	
	//***************************** Name *************************************************************
	
	/**
	 * Funktion gibt den Namen des Geb�udes zur�ck
	 * @return the name als String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Funktion setzt den Names des Geb�udes auf den �bergebenen Wert
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
	 * Funktion setzt das Zeitalter. Es wird dabei gepr�ft, ob der �bergebene Wert einem Wert aus der Aufz�hlung
	 * entspricht. Wenn dies der Fall ist, wird der neue Wert �bernommen. 
	 * <br>Im anderen Fall, bleibt der alte Wert erhalten.
	 * 
	 * @param zeitalter - String - the zeitalter to set
	 */
	public void setZeitalter(String zeitalter) {
		 try {
			this.zeitalter = Zeitalter.valueOf(zeitalter).name();
		} catch (IllegalArgumentException e) {
			//nix wird gemacht
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
	 *                         �berschriebene Funktionen und Methoden                                                                 *
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
