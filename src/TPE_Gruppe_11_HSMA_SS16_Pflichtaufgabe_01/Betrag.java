package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

public class Betrag {
	
	double betrag;
	String waehrung;
	
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
	
	double addiere(Betrag b){
		double ergebnis;
		
	}
}
