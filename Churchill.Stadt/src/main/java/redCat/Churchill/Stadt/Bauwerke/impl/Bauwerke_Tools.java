package redCat.Churchill.Stadt.Bauwerke.impl;

import java.util.HashMap;
import java.util.Map;

import redCat.Churchill.Stadt.Enumeration.Zeitalter;



public class Bauwerke_Tools {
	
	public static Map<Zeitalter, Number> createMap(){
		Map<Zeitalter, Number> hm = new HashMap<Zeitalter, Number>();
		
		hm.put(Zeitalter.Steinzeit,  new Double("2"));
		hm.put(Zeitalter.Bronzezeit, new Double("2.5"));
		hm.put(Zeitalter.Eisenzeit, new Double("4"));
		hm.put(Zeitalter.Fruehes_Mittelalter, new Double("10"));
		hm.put(Zeitalter.Hochmittelalter, new Double("20"));
		hm.put(Zeitalter.Spaetes_Mittelalter, new Double("30"));
		hm.put(Zeitalter.Kolonialzeit, new Double("50"));
		
		return hm;
	}
	
	public static Double getZeitfaktor(Zeitalter za) {
		Map <Zeitalter, Number> zm = createMap();
		Double zf = (Double) zm.get(za);
		return zf;
	}

}
