package SimulationPack;


public class Zug implements Runnable {

	private char name;
	private int position;
	private int speed;
	private Strecke strecke;
	private boolean interrupted = false;

	public Zug(char name, int position, int speed, Strecke strecke) {
		this.name = name;
		this.position = position;
		this.speed = speed;
		this.strecke = strecke;
		if (strecke.strecke[position] != '-') {
			try {
				throw new Simulation_Exception("Dort fährt schon ein Zug");
			} catch (Simulation_Exception e) {
				e.printStackTrace();
			}
		} else {
			strecke.strecke[position] = name;
			strecke.sperren(position);
		}
	}

	public void interrupt() {
		interrupted = true;
	}

	public void run() {

		while (!interrupted) {

			try {
				Thread.sleep(1000 / speed);
			} catch (InterruptedException e) {
				// EinHauchVonNichts
			}	
			if (position == strecke.getLaenge() - 1) {				//Falls der Zug am Ende angekommen ist
				strecke.strecke[position] = '-';
				strecke.entsperren(position);
				interrupted = true;
				strecke.print();
			
			} else if (position == strecke.currentBlock(position).getEnde()) {		//Ende eines Blocks angekommen
				if (locked()) {														//ist geschlossen
					
					synchronized (strecke.currentBlock(position+1)) {			
						{
							try {
								{
									strecke.currentBlock(position+1).wait();
								}
							} catch (InterruptedException e) {
								break;
							}
						}
					}
				} else if(!locked()) {												//ist offen
					strecke.sperren(position + 1);
					strecke.entsperren(position);
					move();
				}
			} else if (crash()) {
				if(position == strecke.currentBlock(position).getAnfang()){
					move();
				}else{
					interrupt();
				try {
					throw new Simulation_Exception("\nCRASH "+ name +" at Position: "+ this.position);
				} catch (Simulation_Exception e) {
					e.printStackTrace();
				}
				}
				
				
			}else if (freeWay()) {
				move();
			} else {
				interrupt();
				try {
					throw new Simulation_Exception("\nCRASH "+ name +" at Position: "+ this.position);
				} catch (Simulation_Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	public boolean freeWay() {
		if (strecke.strecke[this.position + 1] == '-') {
			return true;
		} else
			return false;
	}

	public boolean locked() {
		if (strecke.currentBlock(this.position + 1).isLocked()) {
			return true;
		} else
			return false;

	}

	public boolean crash() {
	
			if (strecke.strecke[this.position - 1] != '-') {
			return true;
			} else
			return false;
			
	}

	public void move() {

		strecke.strecke[this.position] = '-';
		position++;
		strecke.strecke[this.position] = this.name;
		strecke.print();
	}

}
