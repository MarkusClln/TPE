package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;

import static org.junit.Assert.*;

import org.junit.Test;

public class KontoTest {

	Konto konto = new Konto("Olaf Günther", Waehrungen.euro);
	//private Betrag[] konto1 = new Betrag[100];
	Betrag b = new Betrag(100, Waehrungen.euro);
	Betrag b2 = new Betrag(120, Waehrungen.euro);
	Betrag b3 = new Betrag(1000, Waehrungen.yen);
	@Test
	public void testBuche() {
		konto.buche(b);
		assertTrue(konto.getKonto(0)==b);
	}

	@Test
	public void testGebuehren() {
		konto.buche(b);
		konto.gebuehren(0.003);
		assertTrue(konto.saldo()==9970);
	}
	
	@Test
	public void testToString() {
		konto.buche(b);
		konto.buche(b2);
		konto.buche(b3);
		String test = konto.toString();
		assertTrue(test.contains("Kontoinhaber: " + konto.getInhaber() + "\nWährung: " + konto.getWaehrung().getName() + "\n-------------------------\n"));
		
	}
	
	@Test
	public void testToString1() {
		
		konto.buche(b);
		konto.buche(b2);
		
		String testString = "Kontoinhaber: " 
				+ konto.getInhaber() + "\nWährung: " 
				+ konto.getWaehrung().getName()
				+ "\n-------------------------\n";
		for (int i = 0; konto.getKonto(i) != null; i++) {
			testString += konto.getKonto(i).getAsDouble()
					+ " " + konto.getKonto(i).getWaehrung().getKuerzel() 
					+ "\n";
		}
		testString += "-------------------------\n" 
				+ "Saldo: " + konto.getAsDouble() + " "
				+ konto.getWaehrung().getKuerzel();
		
		assertEquals(konto.toString(), testString);

		
	}

}
