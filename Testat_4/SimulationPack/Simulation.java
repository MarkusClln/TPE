package SimulationPack;

import BlockPack.Block;
import StreckePack.Strecke;
import ZugPack.Zug;

public class Simulation {

	public static void main(String[] args) {
		Strecke strecke = new Strecke(70,8);
		Block block1 = new Block(10);
		Block block2 = new Block(5);
		Block block3 = new Block(10);
		Block block4 = new Block(10);
		Block block5 = new Block(15);
		Block block6 = new Block(10);
		Block block7 = new Block(5);
		Block block8 = new Block(5);
		
	
	//	Block blockTEST = new Block(70);
		
		strecke.addBlock(block1);
		strecke.addBlock(block2);
		strecke.addBlock(block3);
		strecke.addBlock(block4);
		strecke.addBlock(block5);
		strecke.addBlock(block6);
		strecke.addBlock(block7);
		strecke.addBlock(block8); 
		
	//	strecke.addBlock(blockTEST);
		
	Zug zugA = new Zug('A',6,5,strecke);
	Zug zugB = new Zug('B',10,5,strecke);
	Zug zugC = new Zug('C',20,5,strecke);
	Zug zugD = new Zug('D',30,40,strecke);
	Zug zugE = new Zug('E',60,4,strecke);
			
		Thread Zug1 = new Thread(zugA);
		Thread Zug2 = new Thread(zugB);
		Thread Zug3 = new Thread(zugC);
		Thread Zug4 = new Thread(zugD);
		Thread Zug5 = new Thread(zugE);
		
		Zug1.start();
		Zug2.start();
		Zug3.start();
		Zug4.start();
		Zug5.start();
		

	}

}
