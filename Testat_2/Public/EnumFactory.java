package Public;
/**
 * @author Jens Windisch (1526760)
 * @author Markus C�llen()
 */
import Private.*;
public enum EnumFactory {

		CAESAR(new CrypterCaesar()),
		SUBSTITUTION(new CrypterSubstitution()),
		XOR(new CrypterXOR());
		
		private Crypter crypter;
		/**
		 * Erstellt leeren Crypter f�r �bergabe
		 * @param crypter
		 */
		EnumFactory(Crypter crypter){
			this.crypter = crypter;
		}
		
		

	
		
		
	
}
