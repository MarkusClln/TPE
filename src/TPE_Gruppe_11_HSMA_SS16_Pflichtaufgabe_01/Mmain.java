package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

public class Mmain {

	public static void main(String[] args) {
		
		Waehrungen waehrungen = new Waehrungen();
		
		System.out.println(waehrungen.euro.toString());
		
		System.out.println(waehrungen.dollar.umrechnen(200, waehrungen.euro));
	}

}
