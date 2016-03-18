package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class BetragTest {

	

	@Test
	public void testGetVorzeichen() {
		Betrag b = new Betrag(-5, Waehrung.euro);
		int erg = b.getVorzeichen();
		assertTrue(erg == -1);
		
		Betrag b2 = new Betrag(5, Waehrung.euro);
		int erg2 = b2.getVorzeichen();
		assertTrue(erg2 == 1);
	}

	@Test
	public void testAddiere() {
		Betrag b = new Betrag(5, Waehrung.euro);
		Betrag b2 = new Betrag(7, Waehrung.euro);
		assertTrue(b.addiere(b2) == 1200);
		
	}

	@Test
	public void testSubtrahiere() {
		Betrag b = new Betrag(7, Waehrung.euro);
		Betrag b2 = new Betrag(9, Waehrung.euro);
		assertTrue(b.subtrahiere(b2) == -200);
	}

	@Test
	public void testMultipliziereDouble() {
		Betrag b = new Betrag(2, Waehrung.euro);
		assertTrue(b.multipliziere(2.6) == 520);
	}

	@Test
	public void testProzent() {
		Betrag b = new Betrag(10, Waehrung.euro);
		assertTrue(b.prozent(0.2) == 200);
	}

	@Test
	public void testPromille() { 
		Betrag b = new Betrag(10, Waehrung.euro);
		assertTrue(b.promille(0.2) == 0.2);
	}

	@Test
	public void testGetVorkomma() {
		Betrag b = new Betrag(12.32, Waehrung.euro);
		assertTrue(b.getVorkomma() == 12);
	}

	@Test
	public void testGetNachkomma() { 
		Betrag b = new Betrag(12.52, Waehrung.euro);
		assertTrue(b.getNachkomma() == 52);
	}


	@Test
	public void testGetAsDouble() {
		Betrag b = new Betrag(12.52, Waehrung.euro);
		assertTrue(b.getAsDouble()==12.52);
	}

	@Test
	public void testEqualsObject() {
		Betrag b = new Betrag(12.52, Waehrung.euro);
		Betrag b1 = new Betrag(12.52, Waehrung.euro);
		Betrag b2 = new Betrag(12.52, Waehrung.yen);
		assertTrue(b.equals(b1));
		assertFalse(b.equals(b2));
	}

}
