package ZugPack;

import BlockPack.Block;
import SimulationPack.Simulation_Exception;
import StreckePack.Strecke;

public class Zug implements Runnable {

	private char name;
	private int position;
	private int speed;
	private Strecke strecke;
	private boolean interrupted = false;
	private Block nextblock;

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
			if (position == strecke.getLaenge() - 1) {
				strecke.strecke[position] = '-';
				strecke.entsperren(position);
				interrupted = true;
				strecke.print();
			
			} else if (position == strecke.currentBlock(position).getEnde()) {
				if (locked()) {
					
						synchronized (strecke) {
						while(strecke.currentBlock(position+1).isLocked()){
							try {
							this.wait();
						} catch (InterruptedException e) {
							break;
						}
						}
					}
				} else if(!locked()) {
					strecke.sperren(position + 1);
					strecke.entsperren(position);
					strecke.wakeUp();
					move();
				}
			} else if (crash()) {
				if(position == strecke.currentBlock(position).getEnde()&&strecke.currentBlock(position+1).isLocked()){
					System.out.println("hallo");
				}else{
				interrupt();
				try {
					throw new Simulation_Exception("\nCRASH "+ Thread.currentThread().getName());
				} catch (Simulation_Exception e) {
					e.printStackTrace();
				}
				}
				
				
			}else if (freeWay()) {
				move();
			} else {
				interrupt();
				try {
					throw new Simulation_Exception("\nCRASH "+ Thread.currentThread().getName());
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
		if (strecke.strecke[this.position - 1] != '-' && strecke.strecke[this.position - 1] != '_'
				&& strecke.strecke[this.position - 1] != '|') {
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
