package redCat.Churchill.Stadt.Bauwerke.api;

import java.util.GregorianCalendar;

public interface Gebaeude_api {

	/**
	 * Funktion gibt den Namen des Geb�udes zur�ck
	 * @return the name als String
	 */
	String getName();

	/**
	 * Funktion setzt den Names des Geb�udes auf den �bergebenen Wert
	 * @param name - String - the name to set
	 */
	void setName(String name);

	/**
	 * Liefert das Zeitalter des Geb�udes als String zur�ck
	 * @return the zeitalter als String
	 */
	String getZeitalter();

	/**
	 * Funktion setzt das Zeitalter. Es wird dabei gepr�ft, ob der �bergebene Wert einem Wert aus der Aufz�hlung
	 * entspricht. Wenn dies der Fall ist, wird der neue Wert �bernommen. 
	 * <br>Im anderen Fall, bleibt der alte Wert erhalten.
	 * 
	 * @param zeitalter - String - the zeitalter to set
	 */
	void setZeitalter(String zeitalter);

	/**
	 * @return the muenzen
	 */
	Integer getMuenzen();

	/**
	 * @param muenzen the muenzen to set
	 */
	void setMuenzen(Integer muenzen);

	/**
	 * @return the werkzeug
	 */
	Integer getWerkzeug();

	/**
	 * @param werkzeug the werkzeug to set
	 */
	void setWerkzeug(Integer werkzeug);

	/**
	 * @return the personen
	 */
	Integer getPersonen();

	/**
	 * @param personen the personen to set
	 */
	void setPersonen(Integer personen);

	/**
	 * @return the diamanten
	 */
	Integer getDiamanten();

	/**
	 * @param diamanten the diamanten to set
	 */
	void setDiamanten(Integer diamanten);

	/**
	 * @return the laenge
	 */
	Integer getLaenge();

	/**
	 * @param laenge the laenge to set
	 */
	void setLaenge(Integer laenge);

	/**
	 * @return the breite
	 */
	Integer getBreite();

	/**
	 * @param breite the breite to set
	 */
	void setBreite(Integer breite);

	/**
	 * @return the bauzeit
	 */
	GregorianCalendar getBauzeit();

	/**
	 * @param bauzeit the bauzeit to set
	 */
	void setBauzeit(GregorianCalendar bauzeit);

	/**
	 * @return the strasse_benoetigt
	 */
	boolean isStrasse_benoetigt();

	/**
	 * @param strasse_benoetigt the strasse_benoetigt to set
	 */
	void setStrasse_benoetigt(boolean strasse_benoetigt);

	Double getZeitfaktor();

	Double berechnePunkte(double gebFaktor);

}