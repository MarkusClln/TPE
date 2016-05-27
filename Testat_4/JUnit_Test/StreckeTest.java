package JUnit_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import GUI.Frame;
import SimulationPack.Block;
import SimulationPack.Strecke;

public class StreckeTest {
	Frame frame = new Frame();
	
	Strecke strecke = new Strecke(70, 3, frame);
	Strecke strecke2 = new Strecke(10,0,frame);
	Block block1 = new Block(30);
	Block block2 = new Block(20);
	Block block3 = new Block(20);


	@Test
	public void testAddBlock() {
		strecke.addBlock(block1);
		strecke.addBlock(block2);
		strecke.addBlock(block3);
		assertTrue(strecke.currentBlock(10).equals(block1) && strecke.currentBlock(40).equals(block2));
	}

	@Test
	public void testCurrentBlock() {
		strecke.addBlock(block1);
		assertTrue(strecke.currentBlock(10).equals(block1));
	}

	@Test
	public void testSperren() {
		strecke.addBlock(block1);
		strecke.addBlock(block2);
		strecke.sperren(10);
		assertTrue(strecke.currentBlock(10).isLocked());
	}

	@Test
	public void testEntsperren() {
		strecke.addBlock(block1);
		strecke.addBlock(block2);
		strecke.sperren(10);
		strecke.entsperren(15);
		assertTrue(!strecke.currentBlock(20).isLocked());
	}

	@Test
	public void testInitialize() {
		strecke2.initialize();
		char array[] = new char[10];
		for(int i = 0; i < 10; i++){
			array[i] = '-';
		}
		assertTrue(array[0] == strecke2.strecke[0]
				&& array[1] == strecke2.strecke[1]
				&& array[2] == strecke2.strecke[2]
				&& array[3] == strecke2.strecke[3]
				&& array[4] == strecke2.strecke[4]
				&& array[5] == strecke2.strecke[5]
				&& array[6] == strecke2.strecke[6]
				&& array[7] == strecke2.strecke[7]
				&& array[8] == strecke2.strecke[8]
				&& array[9] == strecke2.strecke[9]);
	}

	@Test
	public void testGetLaenge() {
		assertTrue(strecke.getLaenge()==70);
	}

}
