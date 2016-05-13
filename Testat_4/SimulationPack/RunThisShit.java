package SimulationPack;

public class RunThisShit {

	public static void main(String[] args) throws Exception {
		Strecke strecke = new Strecke(70,8);
		Block block1 = new Block(10);
		Block block2 = new Block(5);
		Block block3 = new Block(10);
		Block block4 = new Block(10);
		Block block5 = new Block(15);
		Block block6 = new Block(10);
		Block block7 = new Block(5);
		Block block8 = new Block(5);
		
		
		
		
		strecke.addBlock(block1);
		strecke.addBlock(block2);
		strecke.addBlock(block3);
		strecke.addBlock(block4);
		strecke.addBlock(block5);
		strecke.addBlock(block6);
		strecke.addBlock(block7);
		strecke.addBlock(block8);
		
		
		
		
		
		
		
		
		strecke.sperren();
		Zug zugA = new Zug(5,'A',6,strecke);
		Zug zugB = new Zug(15,'B',11,strecke);
		Zug zugC = new Zug(5,'C',20,strecke);
		Zug zugD = new Zug(10,'D',30,strecke);
		Zug zugE = new Zug(6,'E',45,strecke);
		
		
		Thread Zug1 = new Thread(zugA);
		Thread Zug2 = new Thread(zugB);
		Thread Zug3 = new Thread(zugC);
		Thread Zug4 = new Thread(zugD);
		Thread Zug5 = new Thread(zugE);
		
		
		
		
		
		Zug3.start();
		Zug1.start();
		Zug2.start();
		
		Zug4.start();
		Zug5.start();
		
		
		
	}

}
		