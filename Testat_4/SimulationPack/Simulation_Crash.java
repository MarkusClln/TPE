package SimulationPack;

import GUI.Frame;

public class Simulation_Crash {
	public static void main(String[] args) {
		Frame frame = new Frame();
		Strecke strecke = new Strecke(70,2,frame);
		
		Block block1 = new Block(30);
		Block block2 = new Block(40);
	
		
		strecke.addBlock(block1);
		strecke.addBlock(block2);
	
		Zug zugA = new Zug('A',1,5,strecke);
		Zug zugB = new Zug('B',5,15,strecke);
		Zug zugC = new Zug('C',10,5,strecke);
		Zug zugD = new Zug('D',15,10,strecke);
		Zug zugE = new Zug('E',20,6,strecke);
			
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
		
		try{
			Zug1.join();
			Zug2.join();
			Zug3.join();
			Zug4.join();
			Zug5.join();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		frame.ende();
	
	}
}
