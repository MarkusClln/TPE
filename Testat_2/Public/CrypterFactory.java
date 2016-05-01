package Public;
/**
 * @author Jens Windisch (1526760)
 * @author Markus C�llen()
 */
import Private.*;

public class CrypterFactory{
	
	/**
	 * Greift auf die EnumFactory zu und erstellt den entsprechenden Crypter, dem ebenfalls der Key �bergeben wird
	 * @param crypter Verlangter Crypter	
	 * @param key �bergebener Key
	 * @return Gibt den erstellten Crypter samt Key zur�ck
	 * @throws CrypterException wird geschmissen wenn Crypter nicht existiert
	 */
	public Crypter getCrypter(EnumFactory crypter, Key<String> key) throws CrypterException {
		Crypter c = null;
		switch (crypter) {

		case CAESAR:
			c = new CrypterCaesar(key);
			break;
		case SUBSTITUTION:
			c = new CrypterSubstitution(key);
			break;
		case XOR:
			c = new CrypterXOR(key);
			break;
		default: throw new CrypterException("Crypter nicht existent!");
		
		}
		return c;

	}

}
