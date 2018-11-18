package redCat.Churchill.Stadt.Bauwerke.api;

import redCat.Churchill.Stadt.Bauwerke.impl.GueterProd;

public interface Guetergebaeude_api {
	
	/**
	 * @return the produkt
	 */
	String getProdukt();

	/**
	 * @param produkt the produkt to set
	 */
	void setProdukt(String produkt);
	
	/**
	 * @return the material
	 */
	String getMaterial();

	/**
	 * @param material the material to set
	 */
	void setMaterial(String material);

	/**
	 * @return the in4Stunden
	 */
	GueterProd getIn4Stunden();

	/**
	 * @param in4Stunden the in4Stunden to set
	 */
	void setIn4Stunden(GueterProd in4Stunden);

	/**
	 * @return the in8Stunden
	 */
	GueterProd getIn8Stunden();

	/**
	 * @param in8Stunden the in8Stunden to set
	 */
	void setIn8Stunden(GueterProd in8Stunden);

	/**
	 * @return the in1Tag
	 */
	GueterProd getIn1Tag();

	/**
	 * @param in1Tag the in1Tag to set
	 */
	void setIn1Tag(GueterProd in1Tag);

	/**
	 * @return the in2Tagen
	 */
	GueterProd getIn2Tagen();

	/**
	 * @param in2Tagen the in2Tagen to set
	 */
	void setIn2Tagen(GueterProd in2Tagen);
	
	/**
	 * @return the Gebaeude_art
	 */
	String getGebaeude_art();
	

	/**
	 * @param Gebaeude_Art the Gebaeude_art to set
	 */
	public void setGebaeude_art(String gebaeude_art);
	
}