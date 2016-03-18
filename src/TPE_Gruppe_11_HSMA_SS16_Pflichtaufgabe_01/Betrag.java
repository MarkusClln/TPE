package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class Betrag {
	
	private final long betrag;
	private final Waehrung waehrung;

	public Betrag(double betrag, Waehrung waehrung){
		this.betrag = (long)(betrag*100);
		this.waehrung = waehrung;
	}
	
	int getVorzeichen() {
		if (betrag >= 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public long addiere(Betrag b){
		return (this.betrag + b.betrag);
	}
	
	double subtrahiere(Betrag b){
		return this.betrag - b.betrag;
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
	
	int getVorkomma(){
		double vorKomma= this.betrag/100;//int gibt nur alles vorm Komma aus
		return (int) vorKomma;
	}
	
	int getNachkomma(){
		return (int) this.betrag%100; //der rest von betrag modulo 1 ist alles nach dem Komma	
	}
	
	public String toString(){
		return getVorzeichen()*betrag + " " + waehrung;
	}
	
	double getAsDouble(){
		
		double doubleZahl = this.betrag;
		return (doubleZahl/100);
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
