package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Private.CrypterCaesar;
import Private.CrypterSubstitution;
import Private.CrypterXOR;
import Public.Crypter;
import Public.CrypterException;
import Public.CrypterFactory;
import Public.EnumFactory;
import Public.Key;

public class CrypterFactoryTest{
	Key<String> keyCAE = new Key<>("C");
	Key<String> keySUB = new Key<>("UFLPWDRASJMCONQYBVTEXHZKGI");
	Key<String> keyXOR = new Key<>("TPERULES");
	
	@Test
	public void testCAESAR() throws CrypterException {
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.CAESAR, keyCAE);
		assertTrue(c instanceof CrypterCaesar);
	}
	
	@Test
	public void testSUBSTITUION() throws CrypterException {
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.SUBSTITUTION, keySUB);
		assertTrue(c instanceof CrypterSubstitution);
	}
	
	@Test
	public void testXOR() throws CrypterException {
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.XOR, keyXOR);
		assertTrue(c instanceof CrypterXOR);
	}
	
	@Test
	public void testXORFail() throws CrypterException {
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.XOR, keyXOR);
		assertFalse(c instanceof CrypterCaesar);
	}
	
	@Test
	public void testSUBSTITUIONFail() throws CrypterException {
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.SUBSTITUTION, keySUB);
		assertFalse(c instanceof CrypterXOR);
	}
	
	@Test
	public void testCAESARFail() throws CrypterException {
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.CAESAR, keyCAE);
		assertFalse(c instanceof CrypterSubstitution);
	}
	
}
