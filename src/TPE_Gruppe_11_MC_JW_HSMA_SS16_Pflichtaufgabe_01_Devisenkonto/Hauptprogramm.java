package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;

public class Hauptprogramm {

	public static void main(String[] args) {
		
		Waehrungen waehrungen = new Waehrungen();
		Konto konto = new Konto("hans", Waehrungen.euro);
		Betrag b = new Betrag(100, Waehrungen.euro);
	//	Betrag b1 = new Betrag(150, Waehrungen.yen);
		konto.buche(b);
		//konto.buche(b1);
		konto.gebuehren(0.003);
		System.out.println(konto.saldo());
		System.out.println(Waehrung.euro.umrechnen(10000, Waehrung.yen));
		
		
	}

}

