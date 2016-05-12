package SimulationPack;

import StreckePack.Strecke;
import ZugPack.Zug;

public class Simulation {
	
	public static void main(String[] args) {
		
		Strecke s = new Strecke(10);
		Thread t1 = new Thread(new Zug('A', 0, s));
		t1.start();
		
	}
}
