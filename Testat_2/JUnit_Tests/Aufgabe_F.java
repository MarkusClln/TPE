package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Public.Crypter;
import Public.CrypterException;
import Public.CrypterFactory;
import Public.EnumFactory;
import Public.Key;

public class Aufgabe_F extends StringMethodsForTests {
	@Test
	public void aufgabeFTest_Entschluesseln() throws CrypterException{
		
        String secretMessage = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
        Key<String> keySub = new Key<>("MNBVCXYLKJHGFDSAPOIUZTREWQ");
        Key<String> keyCaesar = new Key<>("V");
        Key<String> keyXOR = new Key<>("EINSCHLUESSEL");
        CrypterFactory CF = new CrypterFactory();
        
        //XOR
        Crypter XOR = CF.getCrypter(EnumFactory.XOR,keyXOR);
        secretMessage = stringEntschluesselung(secretMessage,XOR);

        Crypter CAE = CF.getCrypter(EnumFactory.CAESAR,keyCaesar);
        secretMessage = stringEntschluesselung(secretMessage,CAE);

        Crypter SUB = CF.getCrypter(EnumFactory.SUBSTITUTION,keySub);
        secretMessage = stringEntschluesselung(secretMessage,SUB);

        String expected = "UNDXWIEDERXEINXBLATTXERLEDIGT";
        assertTrue(expected.equals(secretMessage));
	}
	
	@Test
	public void aufgabeFTest_Verschluesseln() throws CrypterException{
	
        String secretMessage = "UNDXWIEDERXEINXBLATTXERLEDIGT";
        Key<String> keySub = new Key<>("MNBVCXYLKJHGFDSAPOIUZTREWQ");
        Key<String> keyCaesar = new Key<>("V");
        Key<String> keyXOR = new Key<>("EINSCHLUESSEL");
        CrypterFactory CF = new CrypterFactory();
        
        
       Crypter SUB = CF.getCrypter(EnumFactory.SUBSTITUTION,keySub);
        secretMessage = stringVerschluesselung(secretMessage,SUB);

        Crypter CAE = CF.getCrypter(EnumFactory.CAESAR,keyCaesar);
        secretMessage = stringVerschluesselung(secretMessage,CAE);
        
        Crypter XOR = CF.getCrypter(EnumFactory.XOR,keyXOR);
        secretMessage = stringVerschluesselung(secretMessage,XOR);

        String expected = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
        
        assertTrue(expected.equals(secretMessage));
	}
	
	
		  
/*
 * sgdk
 */
}
