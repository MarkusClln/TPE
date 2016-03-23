package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;

public class Hauptprogramm {

	public static void main(String[] args) {
		
		Waehrungen waehrungen = new Waehrungen();
		Konto konto = new Konto("hans", Waehrungen.euro, 0);
		Betrag b = new Betrag(100, Waehrungen.euro);
		//Betrag b1 = new Betrag(150, Waehrungen.yen);
		konto.buche(b);
		//konto.buche(b1);
		konto.gebuehren(0.00372);
		System.out.println(konto.toString());
		//System.out.println(Waehrung.euro.umrechnen(10000, Waehrung.yen));
		//System.out.println(b.runden(100.89732));
		
		
	}

}
/**
 * TPE = Techniken der Programmentwicklung
 * Gruppe 11
 * MC = Markus Cöllen
 * JW = Jens Windisch
 * HSMA = Hochschule Mannheim
 * SS16 = Sommersemester 2016
 * Pflichtaufgabe 01
 * 
 * Wir haben zuerst das Fach im Paketnamen angegeben (TPE). Anschließend unsere Gruppennummer (11) und unsere Initialen (MC, JW). 
 * Um Kollisionen mit anderen Entwicklern zu vermeiden, haben wir desweiteren HSMA (Hochschule Mannheim) und SS16 (Sommersemester 2016), 
 * damit es örtlich und zeitlich zugeordnet werden kann.
 * Abschließend haben wir die Nummer der Pflichtübung (01) und das Thema der Pflichtübung genannt (Devisenkonto).
 * 
 */
