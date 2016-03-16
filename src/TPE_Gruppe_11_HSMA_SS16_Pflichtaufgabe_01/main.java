package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

public class main {

	public static void main(String[] args) {
		Waehrung euro = new Waehrung("Euro", "€", 1.2690);
		Waehrung yen = new Waehrung("Yen", "Y", 0.0091);
		Waehrung rub = new Waehrung("Rubel", "RUB", 0.0255);
		Waehrung chf = new Waehrung("Schweiz", "CHF", 1.0509);
		Waehrung dollar = new Waehrung("Dollar", "$", 1.0000);
		
		
		System.out.println(dollar.toString());
		System.out.println(dollar.umrechnen(1, "€"));
	}

}
