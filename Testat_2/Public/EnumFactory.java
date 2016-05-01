package Public;
/**
 * @author Jens Windisch (1526760)
 * @author Markus Cöllen()
 */
import Private.*;
public enum EnumFactory {

		CAESAR(new CrypterCaesar()),
		SUBSTITUTION(new CrypterSubstitution()),
		XOR(new CrypterXOR());
		
		private Crypter crypter;
		/**
		 * Erstellt leeren Crypter für Übergabe
		 * @param crypter
		 */
		EnumFactory(Crypter crypter){
			this.crypter = crypter;
		}
		
		

	
		
		
	
}
