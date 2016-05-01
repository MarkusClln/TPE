package Public;

/**
 * * Grundlegendes Interface, um Verschl®usselung durchzuf®uhren. Mit * Hilfe
 * dieses Interfaces kann man Nachrichten verschl®usseln (®uber die *
 * {@link #verschluesseln(char)} Methode) und wieder entschl®usseln (®uber die *
 * {@link #entschluesseln(char)} Methode). * * Der Eingabetext, der Zeichenweise
 * ®ubergeben wird ({@literal klarTextZeichen}) * darf nur aus den
 * Groﬂ-Buchstaben A-Z bestehen. Kleinbuchstaben werden in * Groﬂbuchstaben
 * umgewandelt, alle anderen Zeichen f®uhren zu einer Ausnahme. * * Zwischen den
 * beiden Methoden muss bei gleichem Schl®ussel folgendes gelten: *
 * {@code zeichen == decrypt(encrypt(zeichen))}. *
 */
public interface Crypter{
	/**
	 * * Setzt die Verschl®usselung zur®uck. Diese Methode ist bei einigen *
	 * Verfahren sinnvoll, bei denen eine Position im Schl®ussel verwaltet *
	 * wird, da diese beim Wechsel von Ver- auf Entschl®usselung zur®uckgesetzt *
	 * werdem muss.
	 */
	public void reset();

	/**
	 * * Verschl®usselt das gegebene Zeichen. * * @param klartextZeichen
	 * Zeichen, das verschl®usselt werden soll. * * @return verschl®usseltes
	 * Zeichen. * @throws CrypterException Wird geworfen, wenn Probleme mit der *
	 * Verschl®usselung auftreten.
	 */
	public char verschluesseln(char klartextZeichen) throws CrypterException;

	/**
	 * * Entschl®usselt das gegebenen Zeichen. * * @param cypherTextZeichen
	 * Zeichen, das entschl®usselt werden soll. 1 * @return entschl®usseltes
	 * Zeichen. * @throws CrypterException Wird geworfen, wenn Probleme mit der
	 * * Verschl®usselung auftreten.
	 */
	public char entschluesseln(char cypherTextZeichen) throws CrypterException;

	

	
}
