package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;

/**
 * @author Jens Windisch (1526760)
 * @author Markus C�llen ()
 * @since 15.03.2016
 *  Die Klasse Waehrungen dient allein dazu,
 *  s�mtliche Waehrungen als konstante Objekte zu speichern,
 *  die �berall im Programm einfach wieder verwendet werden k�nnen,
 *  ohne das eine neue Instanziierung n�tig w�re
 */

public class Waehrungen {

	static Waehrung euro = new Waehrung("Euro", "�", 1.2690);
	static Waehrung yen = new Waehrung("Yen", "Y", 0.0091);
	static Waehrung rub = new Waehrung("Rubel", "RUB", 0.0255);
	static Waehrung chf = new Waehrung("Schweiz", "CHF", 1.0509);
	static Waehrung dollar = new Waehrung("Dollar", "$", 1.0000);

}
