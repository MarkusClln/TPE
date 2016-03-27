package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;
/**
 * @author Jens Windisch (1526760)
 * @author Markus Cöllen (1527307)
 * @since 22.03.2016
 */

public class Betrag{
	
	protected long betrag;
	private final Waehrung waehrung;
	/**
	 * Erstellt ein neues Objekt vom Typ Betrag
	 * @param betrag gibt den Betrag des Objekts an
	 * @param waehrung gibt die Währung des Objekts an
	 */
	Betrag(double betrag, Waehrung waehrung) {

		this.betrag = (long) (betrag * 100);
		this.waehrung = waehrung;
	}

	public long getBetrag() {
		return betrag;
	}
	/**
	 * Ermittelt das Vorzeichen eines Betrages
	 * @return -1 für negatives Vorzeichen, 1 für positives Vorzeichen
	 */
	int getVorzeichen() {
		if (betrag >= 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * Addiert einen Betrag auf gegebenen Betrag
	 * @param b Betrag der dazu addiert werden soll
	 * @return Ausgangsbetrag + übergebener Betrag
	 */
	public long addiere(Betrag b) {
		return (this.betrag + b.betrag);
	}
	/**
	 * Subtrahiert einen Betrag von gegebenen Betrag
	 * @param b Betrag der subtrahiert werden soll
	 * @return Ausgangsbetrag - übergebener Betrag
	 */
	double subtrahiere(Betrag b) {
		return this.betrag - b.betrag;
	}
	/**
	 * Multipliziert einen Betrag mit einer übergebenen double Zahl
	 * @param zahl Zahl mit der der gegebene Betrag multipliziert werden soll
	 * @return Ausgangsbetrag * übergebener Betrag
	 */
	double multipliziere(double zahl) {
		double ergebnis = this.betrag * zahl;
		return ergebnis;
	}
	/**
	 * Multipliziert einen Betrag mit einer übergebenen int Zahl
	 * @param zahl Zahl mit der der gegebene Betrag multipliziert werden soll
	 * @return Ausgangsbetrag * übergebener Betrag
	 */
	double multipliziere(int zahl) {
		double ergebnis = this.betrag * zahl;
		return ergebnis;
	}
	/**
	 * Berechnet einen Prozentwert eines Wertes nach übergebenem Prozentsatz
	 * @param prozentsatz
	 * @return Betrag * prozentsatz
	 */
	long prozent(double prozentsatz) {
		double prozentwert = (this.betrag / 100) * prozentsatz;
		return (long) (prozentwert * 100);
	}
	/**
	 * Berechnet einen Promillewert eines Wertes nach übergebenem Promillesatz
	 * @param promillesatz
	 * @return Betrag * promillesatz
	 */
	long promille(double promillesatz) {
		double promillewert = ((this.betrag / 100) * promillesatz);
		return (long) (promillewert * 100);
	}
	/**
	 * Teilt den Betrag durch 100 und gibt ihn als Integer zurück
	 * @return
	 */
	int getVorkomma() {
		double vorKomma = this.betrag / 100;
		return (int) vorKomma;
	}
	/**
	 * Berechnet den Modolo 100 des Betrags und gibt dieses als Integer zurück
	 * @return
	 */
	int getNachkomma() {
		return (int) this.betrag % 100; 
										
	}

	public String toString() {
		return getVorzeichen() * betrag + " " + waehrung;
	}
	/**
	 * Gibt den Betrag als double zurück
	 * @return
	 */
	double getAsDouble() {

		double doubleZahl = this.betrag;
		return (doubleZahl / 100);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Betrag other = (Betrag) obj;
		if (Double.doubleToLongBits(betrag) != Double.doubleToLongBits(other.betrag))
			return false;
		if (waehrung == null) {
			if (other.waehrung != null)
				return false;
		} else if (!waehrung.equals(other.waehrung))
			return false;
		return true;
	}

	public Waehrung getWaehrung() {
		return this.waehrung;
	}

}
