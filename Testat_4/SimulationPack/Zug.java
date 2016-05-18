package SimulationPack;

public class Zug implements Runnable {

	private char name;
	private int position;
	private int speed;
	private Strecke strecke;
	private boolean interrupted=false;

	
	public Zug(char name, int position, int speed, Strecke strecke){
		this.name = name;
		this.position= position;
		this.speed=speed;
		this.strecke=strecke;
		strecke.strecke[position]=name;
		strecke.sperren(position);
		
	
	
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
			} else

			if (crash()) {
				interrupt();
			} else if (position == strecke.currentBlock(position).getEnde()) {
				if (locked()) {
					waitBlock();

				} else {
					strecke.sperren(position + 1);
					strecke.entsperren(position);
					wakeUpBlock();
					move();

				}

			} else if (freeWay()) {
				move();
			}

		}
	}
	

	public boolean freeWay(){
		if(strecke.strecke[this.position+1]=='-'){
			return true;
		}else return false;
	}

	public boolean locked(){
		if(strecke.currentBlock(this.position+1).isLocked()){
			return true;
		}else return false;

	}
	
	public boolean crash(){
		if(strecke.strecke[this.position-1]!='-'&&strecke.strecke[this.position-1]!='_'&&strecke.strecke[this.position-1]!='|'){
			return true;
		}else return false;
	}

	public void move(){
		
		strecke.strecke[this.position]='-';
		position++;
		strecke.strecke[this.position]=this.name;
		strecke.print();
	}

	public synchronized void waitBlock(){
	
		try {
			while (true) {
				synchronized (this) {
					System.out.println(Thread.currentThread().getName());
					this.wait();
				}
			}
		} catch (InterruptedException e) {

		}
	}

	public synchronized void wakeUpBlock(){
		synchronized (this) {
			this.notifyAll();
		}
		
	}

}
