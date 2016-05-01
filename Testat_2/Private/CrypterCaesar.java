package Private;

/**
 * @author Jens Windisch (1526760)
 * @author Markus Cöllen()
 */
import Public.Crypter;
import Public.CrypterException;
import Public.Key;

public class CrypterCaesar implements Crypter {

	private final char key;
	private final char WRONGKEY = 'Z';
	private final int ASCIITOZERO = 65;
	private final int ASCIITOUPPERCASE = 32;
	private final int ALPHABETLETTERS = 26;
	private final char LETTER_A = 'A';
	private final char LETTER_Z = 'Z';

	/**
	 * Erstellt einen CrypterCaesar falls kein Key übergeben wird. Key wird auf
	 * Z gesetzt, das keine Änderung erfolgt.
	 */
	public CrypterCaesar() {
		this.key = WRONGKEY; // Falls kein Key übergeben wird, bei Z bleibt
								// alles gleich
	}

	/**
	 * Erstellt ein Objekt vom Typ CrypterCaesar
	 * 
	 * @param key
	 * @throws CrypterException,
	 *             wenn Key leer ist, größer als 1 Zeichen lang ist oder nicht
	 *             zwischen A und Z liegt.
	 * 
	 */
	public CrypterCaesar(Key<String> key) throws CrypterException {
		if (key.getKey().equals("")) {
			throw new CrypterException("Key ist leer");
		} else if (key.getKey().length() > 1) {
			throw new CrypterException("Key ist zu lang! Key muss genau 1 Zeichen lang sein!");
		} else {
			
			if (key.getKey().charAt(0) >= LETTER_A && key.getKey().charAt(0) <= LETTER_Z) {
				this.key = key.getKey().toString().charAt(0);
			} else

				throw new CrypterException("Key muss zwischen A und Z liegen!");

		}
	}

	public void reset() {
		// not implemented yet
	}

	/**
	 * Dient zum Verschlüsseln eins Zeichens
	 * 
	 * @param klartextZeichen
	 * @return Setzt den ASCII-Wert des Zeichens um 65 runter, damit die
	 *         Buchstaben A-Z die Werte 0-25 haben. Der übergebene Key wird
	 *         ebenfalls in diesen Wertebereich gesetzt und aufaddiert.
	 *         Anschließend wird das Ergebnis modolo 26 genommen und wieder auf
	 *         den korrekten ASCII-Wert gesetzt.
	 * @throws CrypterException:
	 *             Falls ein falscher Parameter übergeben wird, wird eine
	 *             CrypterException geschmissen.
	 */
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		if ((klartextZeichen >= LETTER_A && klartextZeichen <= LETTER_Z)) {
			return (char) ((((klartextZeichen - ASCIITOZERO) + (key - (ASCIITOZERO - 1))) % ALPHABETLETTERS)
					+ ASCIITOZERO);
		} else {
			throw new CrypterException("Kein gültiges Zeichen!");
		}
	}

	/**
	 * Dient zum Entschlüsseln eines Zeichens
	 * 
	 * @param cypherTextZeichen
	 * @return Die Berechnung setzt den ASCII-Wert des übergebenen Zeichens in
	 *         den Wertebereich 0-25, den Key ebenfalls, subtrahiert den Key vom
	 *         Parameter und setzt anschließend das ergebnis wieder auf den
	 *         richtigen ASCII-Wert. Falls Parameter - key <= 0 wird die
	 *         Berechnung auf 26 aufaddiert, um in den korrekten Bereich zu
	 *         gelangen.
	 */
	public char entschluesseln(char cypherTextZeichen) throws CrypterException {
		if (cypherTextZeichen - key <= 0) {
			return (char) (ALPHABETLETTERS + ((cypherTextZeichen - ASCIITOZERO) - (key - (ASCIITOZERO - 1)))
					+ ASCIITOZERO);
		} else
			return (char) (((cypherTextZeichen - ASCIITOZERO) - (key - (ASCIITOZERO - 1))) + ASCIITOZERO);

	}

}
