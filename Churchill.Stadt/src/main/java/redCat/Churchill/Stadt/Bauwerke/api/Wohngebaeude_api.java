package redCat.Churchill.Stadt.Bauwerke.api;

public interface Wohngebaeude_api {

	/**
	 * @return the bewohner
	 */
	Integer getBewohner();

	/**
	 * @param bewohner the bewohner to set
	 */
	void setBewohner(Integer bewohner);

	/**
	 * @return the muenz_einnahmen
	 */
	Integer getMuenz_einnahmen();

	/**
	 * @param muenz_einnahmen the muenz_einnahmen to set
	 */
	void setMuenz_einnahmen(Integer muenz_einnahmen);

	/**
	 * @return the einnahme_dauer
	 */
	Integer getEinnahme_dauer();

	/**
	 * @param einnahme_dauer the einnahme_dauer to set
	 */
	void setEinnahme_dauer(Integer einnahme_dauer);

	/**
	 * Diese Funktion berechnet die erwirtschaftete M�nzmenge unter Verwendung eines Faktors. Es wird normal gerundet.
	 * Es wird dabei eine Erstellungsperiode unterstellt.
	 * 
	 * @param faktor - double-Wert der zu 1 addiert wird
	 * @return Integer - modifizierter Ertragswert
	 */
	Integer getModEinnahmen(double faktor);

	/**
	 * Diese Funktion berechnet die erwirtschaftete M�nzmenge zu einer bestimmten Zeiteinheit. Hierzu wird die vorgegebene Zeit ins Verh�ltnis
	 * zur angegebenen Zeit gesetzt und die M�nzmenge mit diesem Faktor bewertet.
	 * Evtl. Modifikatoren werden hierbei nicht ber�cksichtigt.
	 * 
	 * @param zeit - int-Wert der zu bewertende Zeit in Sekunden angibt
	 * @return Integer - die Anzahl von M�nzen die in der angegebenen Zeit produziert wird
	 */
	Integer berechneMuenzenInZeit(int zeit);

}