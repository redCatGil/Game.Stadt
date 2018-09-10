package redCat.Churchill.Stadt.Bauwerke.api;

public interface Produktionsgebaeude_api {

	/**
	 * @return the in_5_Minuten
	 */
	Integer getIn_5_Minuten();

	/**
	 * @param in_5_Minuten the in_5_Minuten to set
	 */
	void setIn_5_Minuten(Integer in_5_Minuten);

	/**
	 * @return the in_15_Minuten
	 */
	Integer getIn_15_Minuten();

	/**
	 * @param in_15_Minuten the in_15_Minuten to set
	 */
	void setIn_15_Minuten(Integer in_15_Minuten);

	/**
	 * @return the in_1_Stunde
	 */
	Integer getIn_1_Stunde();

	/**
	 * @param in_1_Stunde the in_1_Stunde to set
	 */
	void setIn_1_Stunde(Integer in_1_Stunde);

	/**
	 * @return the in_4_Stunden
	 */
	Integer getIn_4_Stunden();

	/**
	 * @param in_4_Stunden the in_4_Stunden to set
	 */
	void setIn_4_Stunden(Integer in_4_Stunden);

	/**
	 * @return the in_8_Stunden
	 */
	Integer getIn_8_Stunden();

	/**
	 * @param in_8_Stunden the in_8_Stunden to set
	 */
	void setIn_8_Stunden(Integer in_8_Stunden);

	/**
	 * @return the in_1_Tag
	 */
	Integer getIn_1_Tag();

	/**
	 * @param in_1_Tag the in_1_Tag to set
	 */
	void setIn_1_Tag(Integer in_1_Tag);

	/**
	 * @return the name_5_min
	 */
	String getName_5_min();

	/**
	 * @param name_5_min the name_5_min to set
	 */
	void setName_5_min(String name_5_min);

	/**
	 * @return the name_15_min
	 */
	String getName_15_min();

	/**
	 * @param name_15_min the name_15_min to set
	 */
	void setName_15_min(String name_15_min);

	/**
	 * @return the name_1_h
	 */
	String getName_1_h();

	/**
	 * @param name_1_h the name_1_h to set
	 */
	void setName_1_h(String name_1_h);

	/**
	 * @return the name_4_h
	 */
	String getName_4_h();

	/**
	 * @param name_4_h the name_4_h to set
	 */
	void setName_4_h(String name_4_h);

	/**
	 * @return the name_8_h
	 */
	String getName_8_h();

	/**
	 * @param name_8_h the name_8_h to set
	 */
	void setName_8_h(String name_8_h);

	/**
	 * @return the name_1_t
	 */
	String getName_1_t();

	/**
	 * @param name_1_t the name_1_t to set
	 */
	void setName_1_t(String name_1_t);
	
	/**
	 * @return the gebaeude_art
	 */
	String getGebaeude_art();

	/**
	 * @param gebaeude_art the gebaeude_art to set
	 */
	void setGebaeude_art(String gebaeude_art);
	
	
	/**
	 * 
	 * @param produktion as Basis
	 * @param faktor as Faktor zur Gewichtung
	 * @return gewichtete Produktion
	 */
	Integer berechneProduktion(Integer produktion, Integer faktor);
	
	/**
	 * 
	 * @return Werkzeug_Quotient 
	 */
	Double berechneWZQuotient( );

}
