package Private;
/**
 * @author Jens Windisch (1526760)
 * @author Markus Cöllen()
 */
import Public.Crypter;
import Public.CrypterException;
import Public.Key;

public class CrypterSubstitution implements Crypter {
	private final int KEYSIZE = 26;
	private final int ASCIITOZERO = 65;
	private char[] array = new char[KEYSIZE];
	
	
	public CrypterSubstitution() {

	}

	/**
	 * Erstellt ein Objekt vom Typ CrypterSubstitution
	 * 
	 * @param key
	 * @throws CrypterException
	 *             , falls Key leer ist oder nicht genau 26 Zeichen lang ist.
	 *             Key wird durchlaufen und in einem Array gespeichert.
	 */
	public CrypterSubstitution(Key<String> key) throws CrypterException {
		if (key.getKey().equals("")) {
			throw new CrypterException("Key ist leer!");
		} else {
			if ((key.getKey()).length() == KEYSIZE) {
				for (int i = 0; i < KEYSIZE; i++) {
					array[i] = key.getKey().charAt(i);
				}
			} else {
				throw new CrypterException("Falscher Key! Key muss genau 26 Zeichen lang sein!");
			}
		}
	}

	public void reset() {

	}

	/**
	 * Dient zur verschlüsseln eines chars
	 * 
	 * @param klartextZeichen
	 * @return Gibt den char an der Position array[klartextZeichen-65] zurück
	 * 
	 */
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		return array[klartextZeichen - ASCIITOZERO];
	}

	/**
	 * Dient zum entschlüsseln eines chars
	 * 
	 * @param cypherTextZeichen
	 * @return durchsucht das Array nach dem übergebenen char und gibt die
	 *         Position des Arrays+65 zurück
	 */
	public char entschluesseln(char cypherTextZeichen) throws CrypterException {
		for (int i = 0; i < KEYSIZE; i++) {
			if (array[i] == cypherTextZeichen) {
				return (char) (i + ASCIITOZERO);
			}
		}
		return '0';
	}

}
