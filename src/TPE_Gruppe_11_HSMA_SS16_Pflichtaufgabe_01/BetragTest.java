package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class BetragTest {

	

	@Test
	public void testGetVorzeichen() {
		Betrag b = new Betrag(-5, "€");
		int erg = b.getVorzeichen();
		assertTrue(erg == -1);
		
		Betrag b2 = new Betrag(5, "€");
		int erg2 = b2.getVorzeichen();
		assertTrue(erg2 == 1);
	}

	@Test
	public void testAddiere() {
		Betrag b = new Betrag(5, "€");
		Betrag b2 = new Betrag(7, "€");
		double erg = b.addiere(b2);
		assertTrue(erg == 12);
		
	}

	@Test
	public void testSubtrahiere() {
		Betrag b = new Betrag(7, "€");
		Betrag b2 = new Betrag(9, "€");
		double erg = b.subtrahiere(b2);
		assertTrue(erg == -2);
	}

	@Test
	public void testMultipliziereDouble() {
		Betrag b = new Betrag(2, "€");
		
		double erg = b.multipliziere(2.6);
		assertTrue(erg == 5.2);
	}

	@Test
	public void testProzent() {
		Betrag b = new Betrag(10, "€");
		double erg = b.prozent(0.2);
		assertTrue(erg == 2);
	}

	@Test
	public void testPromille() {  //Fehler
		Betrag b = new Betrag(10, "€");
		double erg = b.prozent(0.2);
		assertTrue(erg == 0.002);
	}

	@Test
	public void testGetVorkomma() {
		Betrag b = new Betrag(12.32, "€");
		double erg = b.getVorkomma();
		assertTrue(erg == 12);
	}

	@Test
	public void testGetNachkomma() { //Fehler
		Betrag b = new Betrag(12.32, "€");
		double erg = b.getNachkomma();
		assertTrue(erg == 32);
	}


	@Test
	public void testGetAsDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
