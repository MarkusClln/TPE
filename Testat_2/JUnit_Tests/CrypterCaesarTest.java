package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Private.CrypterCaesar;
import Public.Crypter;
import Public.CrypterException;
import Public.CrypterFactory;
import Public.EnumFactory;
import Public.Key;

public class CrypterCaesarTest extends StringMethodsForTests{

	@Test
	public void testCrypterCaesarKeyOfString() {
		boolean check = false;
		Key<String> key = new Key<>("K");
		String str = "K";
		if(key.getKey().equals(str)){
			check = true;
		}
		assertTrue(check);
	}

	@Test
	public void testReset() {
		//nicht implementiert!
	}
	
	@Test
	public void testThrowsCrypterExceptionKeyToLong() throws CrypterException {
		  boolean thrown = false;
		  Key<String> key = new Key<>("KK");
		  CrypterFactory CF = new CrypterFactory();
		  try{ 
		  Crypter c = CF.getCrypter(EnumFactory.CAESAR, key);
		  } catch (CrypterException e){
			  thrown = true;
			}
		  assertTrue(thrown);
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
	public void testThrowsCrypterExceptionWrongSignForKey() throws CrypterException {
		  boolean thrown = false;
		  Key<String> key = new Key<>("6");
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
		Key<String> key = new Key<String>("C");
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.CAESAR, key);
 		String string="CAESAR";
        String erg = stringVerschluesselung(string,c);
        String expected = "FDHVDU";
        
        assertTrue(erg.equals(expected));
	}

	@Test
	public void testEntschluesseln() throws CrypterException {
		Key<String> key = new Key<String>("C");
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.CAESAR, key);
 		String string="FDHVDU";
        String erg = stringEntschluesselung(string,c);
        String expected = "CAESAR";
        
        assertTrue(erg.equals(expected));
	}

}
