package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;

import static org.junit.Assert.*;

import org.junit.Test;

public class KontoTest {

	Konto konto = new Konto("Olaf Günther", Waehrungen.euro);
	Betrag b = new Betrag(100, Waehrungen.euro);
	
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

}
