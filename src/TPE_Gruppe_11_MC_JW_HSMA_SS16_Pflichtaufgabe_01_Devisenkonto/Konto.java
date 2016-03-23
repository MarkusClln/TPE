package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;
/**
 * 
 * @author Jens Windisch (1526760)
 * @author Markus Cöllen (1527307)
 * @since 23.03.2016
 */

public class Konto extends Betrag {
	private String inhaber;
	private Betrag[] konto = new Betrag[100];
	private int pointer = 0;

	/**
	 * Erstellt ein neues Objekt vom Typ Konto mit folgenden Parametern
	 * @param inhaber gibt den Inhaber des Kontos an	
	 * @param waehrung gibt die Währung des Kontos an
	 * @param guthaben gibt das aktuelle Guthaben des Kontos an
	 */
	 
	Konto(String inhaber, Waehrung waehrung, double guthaben) {
		super(guthaben, waehrung);
		this.inhaber = inhaber;
	}
	 
	/**
	 * Bucht einen übergebenen Betrag auf das Konto.
	 * Falls die Währung des übergebenen Betrages ungleich der Währung des Kontos ist,
	 * wird die Währung des Betrags umgerechnet in die Währung des Kontos
	 * @param betrag
	 */

	void buche(Betrag betrag) {

		konto[pointer] = betrag;
		if (super.getWaehrung() == betrag.getWaehrung()) {
			super.betrag = addiere(betrag);
		} else {
			super.betrag += betrag.getWaehrung().umrechnen(betrag.getBetrag(), super.getWaehrung());
		}
		this.pointer++;
	}
	
	/**
	 * toString()
	 * Gibt einen Kontoauszug auf die Konsole aus
	 * 
	 * Kontoinhaber: X Y
	 * Waehrung: W
	 * -------
	 * Buchung 1:
	 * Buchung 2:
	 * Buchung 3:
	 * -------
	 * Saldo: xx.xx W
	 * 
	 */
	
	public String toString() {
		String ausgabe = "Kontoinhaber: " + this.inhaber + "\nWährung: " + super.getWaehrung().getName()
				+ "\n-------------------------\n";
		for (int i = 0; konto[i] != null; i++) {
			ausgabe += ((double) konto[i].getBetrag()) / 100 + " " + konto[i].getWaehrung().getKuerzel() + "\n";
		}
		ausgabe += "-------------------------\n" + "Saldo: " + ((double) saldo()) / 100 + " "
				+ super.getWaehrung().getKuerzel();
		return ausgabe;
	}
	
	/**
	 * saldo()
	 * Gibt die Summe des aktuellen Kontostandes und aller getätigten Buchungen zurück
	 * @return Kontostand
	 */
	
	public long saldo() {
		return betrag;
	}

	/**
	 * gebuehren() Berechnet promille Wert und erzeugt eine Buchung mit diesem
	 * Wert
	 * 
	 * @param gebuehren
	 *            ist der Gebührensatz Bsp.: 0.003
	 */
	public void gebuehren(double gebuehren) {
		double promille = promille(gebuehren);
		promille = Math.round(promille * 100);
		Betrag betrag = new Betrag(-(promille / 10000), this.getWaehrung());
		buche(betrag);

	}
	
	public String getInhaber() {
		return this.inhaber;
	}

	public Waehrung getWaehrung() {
		return super.getWaehrung();
	}

	public long getGuthaben() {
		return super.betrag;
	}
}
