package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Public.Crypter;
import Public.CrypterException;
import Public.CrypterFactory;
import Public.EnumFactory;
import Public.Key;

public class CrypterSubstitutionTest extends StringMethodsForTests {

	
	@Test
	public void testCrypterSubstitutionKeyOfString() {
		boolean check = false;
		Key<String> key = new Key<>("UFLPWDRASJMCONQYBVTEXHZKGI");
		String str = "UFLPWDRASJMCONQYBVTEXHZKGI";
		if(key.getKey().equals(str)){
			check = true;
		}
		assertTrue(check);
	}

	public void testThrowsCrypterExceptionEmptyKey() throws CrypterException {
		  boolean thrown = false;
		  Key<String> key = new Key<>("");
		  CrypterFactory CF = new CrypterFactory();
		  try{ 
		  Crypter c = CF.getCrypter(EnumFactory.SUBSTITUTION, key);
		  } catch (CrypterException e){
			  thrown = true;
			}
		  assertTrue(thrown);
	}
	
	public void testThrowsCrypterExceptionKeyToShortOrLong() throws CrypterException {
		  boolean thrown = false;
		  Key<String> key = new Key<>("dfsdf");
		  CrypterFactory CF = new CrypterFactory();
		  try{ 
		  Crypter c = CF.getCrypter(EnumFactory.SUBSTITUTION, key);
		  } catch (CrypterException e){
			  thrown = true;
			}
		  assertTrue(thrown);
	}
	
	
	@Test
	public void testReset() {
		//Nicht implementiert!
	}

	@Test
	public void testVerschluesseln() throws CrypterException {
		Key<String> key = new Key<String>("UFLPWDRASJMCONQYBVTEXHZKGI");
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.SUBSTITUTION, key);
 		String string="WIKIPEDIAISTINFORMATIV";
        String erg = stringVerschluesselung(string,c);
        String expected = "ZSMSYWPSUSTESNDQVOUESH";
        
        assertTrue(erg.equals(expected));
	}

	@Test
	public void testEntschluesseln() throws CrypterException {
		Key<String> key = new Key<String>("UFLPWDRASJMCONQYBVTEXHZKGI");
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.SUBSTITUTION, key);
 		String string="ZSMSYWPSUSTESNDQVOUESH";
        String erg = stringEntschluesselung(string,c);
        String expected = "WIKIPEDIAISTINFORMATIV";
        
        assertTrue(erg.equals(expected));
	}

}
