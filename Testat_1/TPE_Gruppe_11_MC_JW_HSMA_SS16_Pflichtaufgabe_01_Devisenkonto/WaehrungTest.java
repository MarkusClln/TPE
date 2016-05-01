package TPE_Gruppe_11_MC_JW_HSMA_SS16_Pflichtaufgabe_01_Devisenkonto;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaehrungTest {

	@Test
	public void testUmrechnen() {
		double erg = Waehrung.euro.umrechnen(10000, Waehrung.yen);
		assertTrue(erg == 1394505);
	}

}
