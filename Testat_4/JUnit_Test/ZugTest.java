package JUnit_Test;

import static org.junit.Assert.*;

import org.junit.Test;
import SimulationPack.*;
import GUI.Frame;

public class ZugTest {
	Frame frame = new Frame();
	Strecke strecke = new Strecke(70, 3, frame);
	Block block1 = new Block(30);
	Block block2 = new Block(20);
	Block block3 = new Block(20);
	Zug zugA = new Zug('A',1,5,strecke);
	Zug zugB = new Zug('B',5,15,strecke);

	@Test
	public void testInterrupt() {
//		assertTrue();
	}

	@Test
	public void testRun() {
		fail("Not yet implemented");
	}

	@Test
	public void testFreeWay() {
		fail("Not yet implemented");
	}

	@Test
	public void testLocked() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrash() {
		fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

}
