package redCat.Churchill.Stadt.Enumeration;

public enum Kaempferart {
SCHNELLE_EINHEIT,
SCHWERE_EINHEIT,
LEICHTE_EINHEIT,
ARTELLERIE_EINHEIT,
FERNKAMPF_EINHEIT;

/**
 * Die Funktion ermittelt anhand eines Integerwertes den passenden Kaempferart-Namen:
 * <br>
 * 1 = schnelle Einheit <br>
 * 2 = schwere Einheit <br>
 * 3 = leichte Einheit <br>
 * 4 = Artellerieeinheit <br>
 * 5 = Fernkampfeinheit<br>
 * 
 * sollte der Integerwert nicht gefunden werden, wird NULL zur�ckgegeben
 * 
 * @param wert - int = Einheitennummer (entspricht nicht der Kaempferart-ID des enums!)
 * @return string - Name der passenden Kaempferart-Einheit. Sollte die Nummer nicht valide sein, wird NULL 
 *                  zur�ckgegeben
 */
public String WertMitNummer(int wert) {
	switch (wert) {
	case 1:
		return Kaempferart.valueOf("SCHNELLE_EINHEIT").name();
	case 2:
		return Kaempferart.valueOf("SCHWERE_EINHEIT").name();
	case 3:
		return Kaempferart.valueOf("LEICHTE_EINHEIT").name();
	case 4:
		return Kaempferart.valueOf("ARTELLERIE_EINHEIT").name();
	case 5:
		return Kaempferart.valueOf("FERNKAMPF_EINHEIT").name();
	default:
		return null;
	}
}
}

