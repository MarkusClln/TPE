package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

public class Betrag {
	
	private final double betrag;
	private final String waehrung;
	
	private Betrag(double betrag, String waehrung){
		this.betrag = betrag;
		this.waehrung = waehrung;
	}
	
	int getVorzeichen() {
		if (betrag >= 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	double addiere(Betrag b){
		double ergebnis = this.betrag + b.betrag;
		return ergebnis;
	}
	
	double subtrahiere(Betrag b){
		double ergebnis = this.betrag - b.betrag;
		return ergebnis;
	}
	
	double multipliziere(double zahl){
		double ergebnis = this.betrag * zahl;
		return ergebnis;
	}
	
	double multipliziere(int zahl){
		double ergebnis = this.betrag / zahl;
		return ergebnis;
	}
	
	double getVorkomma(){
		int vorKomma = (int) this.betrag; //int gibt nur alles vorm Komma aus
		return vorKomma;
	}
	
	double getNachkomma(){
		double nachKomma = this.betrag % 1; //der rest von betrag modulo 1 ist alles nach dem Komma
		return nachKomma;
	}
	
	double getAsDouble(){
		double doubleZahl = this.betrag;
		doubleZahl = Math.round(doubleZahl * 100)/100.0;
		return doubleZahl;
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
	
	
	
}
