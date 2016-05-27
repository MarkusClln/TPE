package JUnit_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import SimulationPack.Block;

public class BlockTest {
	
	Block block1 = new Block(10);
	@Test
	public void testSperren() {
		block1.sperren();
		assertTrue(block1.isLocked());
	}

	@Test
	public void testEntsperren() {
		block1.sperren();
		block1.entsperren();
		assertTrue(!block1.isLocked());
	}

	@Test
	public void testSetEnde() {
		block1.setEnde(20);
		assertTrue(block1.getEnde() == 20);
	}

	@Test
	public void testGetEnde() {
		block1.setEnde(20);
		assertTrue(block1.getEnde() == 20);
	}

	@Test
	public void testSetAnfang() {
		block1.setAnfang(10);
		assertTrue(block1.getAnfang() == 10);
	}

	@Test
	public void testIsLocked() {
		block1.sperren();
		assertTrue(block1.isLocked());
	}

	@Test
	public void testGetLaenge() {
		assertTrue(block1.getLaenge() == 10);
	}

	@Test
	public void testGetAnfang() {
		block1.setAnfang(10);
		assertTrue(block1.getAnfang() == 10);
	}

}
