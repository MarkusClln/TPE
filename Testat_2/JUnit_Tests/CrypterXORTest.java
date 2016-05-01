package JUnit_Tests;
/**
* @author Jens Windisch (1526760)
* @author Markus Cöllen()
*/
import static org.junit.Assert.*;

import org.junit.Test;

import Private.CrypterXOR;
import Public.Crypter;
import Public.CrypterException;
import Public.CrypterFactory;
import Public.EnumFactory;
import Public.Key;

public class CrypterXORTest extends StringMethodsForTests{


	@Test
	public void testCrypterXORKeyOfString() {
		boolean check = false;
		Key<String> key = new Key<>("TPERULES");
		String str = "TPERULES";
		if(key.getKey().equals(str)){
			check = true;
		}
		assertTrue(check);
	}

	@Test
	public void testReset() throws CrypterException {
		
		Key<String> key = new Key<String>("TPERULES");
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.XOR, key);
 		String erg=""+c.verschluesseln('A');
 		c.reset();
 		erg= erg+c.verschluesseln('A');
        String expected = "UU";  // UU weil A jeweils immer mit T verschlüsselt wird, aufgrund des Resetaufrufs
        assertTrue(erg.equals(expected));
	}
	
	@Test
	public void testThrowsCrypterExceptionEmptyKey() throws CrypterException {
		  boolean thrown = false;
		  Key<String> key = new Key<>("");
		  CrypterFactory CF = new CrypterFactory();
		  try{ 
		  Crypter c = CF.getCrypter(EnumFactory.CAESAR, key);
		  } catch (CrypterException e){
			  thrown = true;
			}
		  assertTrue(thrown);
	}

	@Test
	public void testVerschluesseln() throws CrypterException {
		Key<String> key = new Key<String>("TPERULES");
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.XOR, key);
 		String string="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String erg = stringVerschluesselung(string,c);
        String expected = "URFVPJB[]ZN^XBJCEBVF@ZRKMJ";
        
        assertTrue(erg.equals(expected));
	}

	@Test
	public void testEntschluesseln() throws CrypterException {
		Key<String> key = new Key<String>("TPERULES");
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.XOR, key);
 		String string="URFVPJB[]ZN^XBJCEBVF@ZRKMJ";
        String erg = stringEntschluesselung(string,c);
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        assertTrue(erg.equals(expected));
	}

	


}
