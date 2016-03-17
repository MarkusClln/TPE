package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class Betrag {
	
	private final double betrag;
	private final String waehrung;

	public Betrag(double betrag, String waehrung){
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
	
	public double addiere(Betrag b){
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
	
	double prozent(double prozentsatz){
		double prozentwert = this.betrag * prozentsatz;
		return prozentwert;
	}
	
	double promille(double promillesatz){
		double promillewert = (this.betrag * promillesatz)/1000;
		return promillewert;
	}
	
	double getVorkomma(){
		int vorKomma = (int) this.betrag; //int gibt nur alles vorm Komma aus
		return vorKomma;
	}
	
	double getNachkomma(){
		double nachKomma = (this.betrag * 100) % 100; //der rest von betrag modulo 1 ist alles nach dem Komma
		return nachKomma;
	}
	
	public String toString(){
		return getVorzeichen()*betrag + " " + waehrung;
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
