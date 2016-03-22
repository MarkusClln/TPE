package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;

public class Hauptprogramm {

	public static void main(String[] args) {
		
		Waehrungen waehrungen = new Waehrungen();
		Konto konto = new Konto("hans", Waehrungen.euro, 0);
		Betrag b = new Betrag(100, Waehrungen.yen);
		Betrag b2 = new Betrag(150, Waehrungen.yen);
		konto.buche(b);
		//konto.buche(konto, b2);
		//System.out.println(waehrungen.euro.toString());
		//System.out.println(waehrungen.dollar.umrechnen(1, waehrungen.euro));
		//Betrag betrag1 = new Betrag(100.12,waehrungen.euro);
		//Betrag betrag2 = new Betrag(100,waehrungen.euro);
		//System.out.println(betrag1.getAsDouble());
		konto.buche(b);
		konto.buche(b2);
		System.out.println(konto.toString());
		
		
		
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
