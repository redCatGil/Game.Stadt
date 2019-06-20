package redCat.Churchill.Stadt.Bauwerke.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Toolbox {

	public Toolbox() {
		// TODO Auto-generated constructor stub
	}
	
	public static int ermittleStunden(int zeit) {
		int stunden;
		stunden = zeit/3600;
		return stunden;
	}
	
	public static int ermittleMinuten(int zeit) {
		int minuten;
		zeit = zeit - (ermittleStunden(zeit)*3600);
		minuten = zeit / 60;
		return minuten;
	}
	
	public static int ermittleSekunden(int zeit) {
		int sekunden;
		sekunden = zeit - (ermittleStunden(zeit)*3600);
		sekunden = sekunden - (ermittleMinuten(sekunden)*60);
		return sekunden;
	}
	
	
	/**
	 * Diese Funktion wandelt die in einen int als Sekunden gespeicherte Zeit in einen String um.
	 * @param zeit - Zeit in Sekunden 
	 * @return String - umgewandelte Zeit als String
	 */
	public static String intToTime(int zeit){
		String wert = null;
		if (zeit <= 60) {
			wert = zeit + "sec";
		} else {
			if (zeit < 3600) {
				wert =  Toolbox.ermittleMinuten(zeit) + ":" + Toolbox.ermittleSekunden(zeit) + " min" ;
			}
			else {
				wert = Toolbox.ermittleStunden(zeit) + ":" + Toolbox.ermittleMinuten(zeit) +
						":" + Toolbox.ermittleSekunden(zeit) + " h";
			}
		}
		return wert;
	}
	
	
	/**
	 * Diese Funktion wandelt die Zeit in einem Kalenderobjekt in einen String um.
	 * @param cal - Kalenderobjekt, in dem die Zeit enthalten ist
	 * @return String - Zeit als String
	 */
	public static String TimeToString(GregorianCalendar cal) {
		if (cal.get(Calendar.HOUR) == 0 && cal.get(Calendar.MINUTE) == 0) {
			return new String(cal.get(Calendar.SECOND) + " sec");
		} else {
			if (cal.get(Calendar.HOUR) == 0) {
				return new String(cal.get(Calendar.MINUTE) + " min" );
			}
			else {
				return new String(cal.get(Calendar.HOUR) + ":" +cal.get(Calendar.MINUTE) + " h" );
			}
		}
	}
	
	
	public static String DateTimeToString(Date date) {
		Calendar cal =Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
		cal.setTime(date);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int std = cal.get(Calendar.HOUR_OF_DAY);
		if ((std == 0) && (min == 0)) {
			return new String(sec + " sec");
		} else {
			if (std == 0) {
				return new String(min + ":" + sec + " min");
			} else {
				return new String(std + ":" + min + ":" + sec + " h");
			}
		}
	}
	
	public static Wohngebaeude WogAuswahl(int wert) {
		switch (wert) {
		case 0:
			return new Huette();

		case 1:
			return new Langhaus();

		case 2:
			return new Pfahlbau();

		case 3:
			return new StrohgedecktesHaus();

		case 4:
			return new Chalet();

		case 5:
			return new Villa();

		case 6:
			return new Domizil();

		case 7:
			return new Ziegeldachhaus();

		case 8:
			return new Schindelhaus();

		case 9:
			return new Fachwerkhaus();

		case 10:
			return new Stadthaus();

		case 11:
			return new Sandsteinhaus();

		case 12:
			return new Herrenhaus();

		case 13:
			return new Landgut();

		case 14:
			return new Gutshaus();

		case 15:
			return new Mietshaus();

		case 16:
			return new Arkadenhaus();
			
		case 17:
			return new Kolonialhaus();

		case 18:
			return new Landhaus();
			
		case 19:
			return new Mansarddach_Haus();
			
		case 20:
			return new Residenz();
			
		case 21:
			return new Pension();

		default:
			return null;
		}

	}
	
	public static Produktionsgebaeude ProdAuswahl(int prod) {
		switch (prod) {
		case 0: return new Jagdlager();
		
		case 1: return new Toepferei();
		
		case 2: return new Obstplantage();
		
		case 3: return new Nutztiergehege();
		
		case 4: return new Schmiede();
		
		case 5: return new Schneiderei();
		
		case 6: return new Ziegenzucht();
		
		case 7: return new Metzgerei();
		
		case 8: return new Gerberei();
		
		case 9: return new Baeckerei();
		
		case 10: return new Windmuehle();
		
		case 11: return new Alchemistenlabor();
		
		case 12: return new Gewuerzhandlung();
		
		case 13: return new Brauerei();
		
		case 14: return new Kueferei();
		
		case 15: return new Tabakplantage();
		
		case 16: return new Segelmacher();
		
		case 17: return new Parfuem_Destillerie();
		
		case 18: return new Uhrmacher();
		
		case 19: return new Stellmacher();
		
		case 20: return new Chemiefabrik();
			
		default: return null;
		}
		
	}
	
	public static Guetergebaeude GueterAuswahl(int gueter) {
		switch (gueter) {
		case 0: return new Weingut();
		case 1: return new Saegemuehle();
		case 2: return new Steinmetz();
		case 3: return new Faerberei();
		case 4: return new Marmorsteinmetz();
		case 5: return new Weberei();
		case 6: return new Kalksteinmetz();
		case 7: return new Juwelier();
		case 8: return new Ebenholzwerkstatt();
		case 9: return new Imkerei();
		
		
		default: return null;
		}
	}

}
