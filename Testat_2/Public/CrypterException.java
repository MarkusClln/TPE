package Public;
/**
 * @author Jens Windisch (1526760)
 * @author Markus Cöllen()
 */
public class CrypterException extends Exception {
	String s;
	/**
	 * Erstellt eine CrypterException in welche die Fehlermeldung geschrieben werden kann
	 * @param s Eingegebene Fehlermeldung
	 */
	public CrypterException(String s) {
		super(s);
		this.s = s;
	}
}
