package Private;
/**
* @author Jens Windisch (1526760)
* @author Markus Cöllen()
*/

import Public.Crypter;
import Public.CrypterException;
import Public.Key;

public class CrypterXOR implements Crypter {

	private char[] array;
	private Key<String> key;
	private int pointer = 0;
	private final int SETASCII = 64;

	public CrypterXOR() {

	}

	/**
	 * Erstellt ein neues Objekt vom Typ CrypterXOR
	 * 
	 * @param key
	 * @throws CrypterException,
	 *             falls Key leer ist. Key wird durchlaufen und in einem Array
	 *             gespeichert. Anschließend wird der Pointer auf 0 gesetzt.
	 */
	public CrypterXOR(Key<String> key) throws CrypterException {
		if (key.getKey().equals("")) {
			throw new CrypterException("Key ist leer!");
		} else {
			
			this.key = key;
			array = new char[key.getKey().length()];
			for (int i = 0; i < key.getKey().length(); i++) {
				array[i] = key.getKey().charAt(i);

			}
			reset();
		}
	}

	/**
	 * Setzt den Pointer wieder auf 0.
	 */
	public void reset() {
		this.pointer = 0;
	}

	/**
	 * @param klartextZeichen
	 * @return ASCII-Wert des übergebenen Parameters wird zwischen 0-31 gesetzt,
	 *         anschließend mit dem XOR-Operator mit dem im Array gespeicherten
	 *         Wert an aktueller Stelle, bei welchem ebenfalls der ASCII-Wert
	 *         angepasst wird, verknüpft. Abschließend wird wieder der
	 *         ASCII-Wert hochgesetzt. Danach wird der Arraypointer um 1
	 *         hochgesetzt und das erhaltene Zeichen zurückgegeben.
	 */
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		char rückgabe = (char) (((klartextZeichen - SETASCII) ^ (array[pointer] - SETASCII)) + SETASCII);
		arrayVerschiebung(array);
		return rückgabe;
	}

	/**
	 * @param cypherTextZeichen
	 * @return Der ASCII-Wert des im Array gespeicherten Wertes wird angepasst
	 *         und anschließend mit dem übergebenem Parameter, welcher ebenfalls
	 *         einen angepassten ASCII-Wert hat, verknüpft und abschließend
	 *         wieder auf den korrekten ASCII-Wert gesetzt. Danach wird der
	 *         Arraypointer um 1 hochgesetzt und das erhaltene Zeichen
	 *         zurückgegeben.
	 */
	public char entschluesseln(char cypherTextZeichen) throws CrypterException {
		char rückgabe = (char) (((array[pointer] - SETASCII) ^ (cypherTextZeichen - SETASCII)) + SETASCII);
		arrayVerschiebung(array);
		return rückgabe;
	}
	
	public void arrayVerschiebung(char[] array){
		 		if(pointer<array.length-1){
		  			pointer++;
		  		}
		  		else reset();
	}
	
}
