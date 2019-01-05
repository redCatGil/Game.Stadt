package redCat.Churchill.Stadt.Bauwerke.impl;

public class GueterProd {
	
	private String prodName;
	private Integer prodMenge;
	private Integer prodMuenzen;
	private Integer prodWZ;
	
	
/* ***********************************************************************************************
 * 
 *  Konstruktoren
 * 
 * *********************************************************************************************** 
 */
	
	public GueterProd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GueterProd(String prodName, Integer prodMenge, Integer prodMuenzen, Integer prodWZ) {
		super();
		this.prodName = prodName;
		this.prodMenge = prodMenge;
		this.prodMuenzen = prodMuenzen;
		this.prodWZ = prodWZ;
	}
	
	
	/* ***********************************************************************************************
	 * 
	 *  Getter- und Setter-Funktionen
	 * 
	 * *********************************************************************************************** 
	 */
	
	

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Integer getProdMenge() {
		return prodMenge;
	}

	public void setProdMenge(Integer prodMenge) {
		this.prodMenge = prodMenge;
	}

	public Integer getProdMuenzen() {
		return prodMuenzen;
	}

	public void setProdMuenzen(Integer prodMuenzen) {
		this.prodMuenzen = prodMuenzen;
	}

	public Integer getProdWZ() {
		return prodWZ;
	}

	public void setProdWZ(Integer prodWZ) {
		this.prodWZ = prodWZ;
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
		return "GueterProd [prodName=" + prodName + ", prodMenge=" + prodMenge + ", prodMuenzen=" + prodMuenzen
				+ ", prodWZ=" + prodWZ + "]";
	}
	
	
	
	

}
