package SimulationPack;

public class Zug implements Runnable {

	private char name;
	private int position;
	private int speed;
	private Strecke strecke;
	private boolean interrupted = false;

	/**
	 * Erstellt ein neues Objekt vom Typ Zug
	 * 
	 * @param name
	 * @param position
	 * @param speed
	 * @param strecke
	 */
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

	/**
	 * Unterbricht die Fahrt des Zuges Unterbricht den Thread
	 */
	public void interrupt() {
		interrupted = true;
	}

	/**
	 * Lässt den Zug fahren
	 */
	public void run() {

		while (!interrupted) {

			try {
				Thread.sleep(1000 / speed);
			} catch (InterruptedException e) {
				// EinHauchVonNichts
			}
			/*
			 * Wenn die Position des Zuges am Ende der Strecke ist, wird der Zug
			 * Name mit '-' überschrieben und der Block entsperrt und die
			 * Zugfahrt wird unterbrochen
			 */
			if (position == strecke.getLaenge() - 1) { // Falls der Zug am Ende
														// angekommen ist
				strecke.strecke[position] = '-';
				strecke.entsperren(position);
				interrupted = true;
				strecke.print();

			} else if (position == strecke.currentBlock(position).getEnde()) {
				/*
				 * Wenn das Ende eines Blockes gesperrt ist, muss der Zug warten
				 */
				if (locked()) { // ist geschlossen

					synchronized (strecke.currentBlock(position + 1)) {
						{
							try {
								{
									strecke.currentBlock(position + 1).wait();
								}
							} catch (InterruptedException e) {
								break;
							}
						}
					}
				} else if (!locked()) {
					/*
					 * Wenn nicht gesperrt ist, dürfte der Zug fahren
					 */
					strecke.sperren(position + 1);
					strecke.entsperren(position);
					move();
				}
			} else if (crash()) {
				//Falls es einen Crash gibt werden die beteiligten Züge unterbrochen
				if (position == strecke.currentBlock(position).getAnfang()) {
					move();
				} else {
					interrupt();
					try {
						throw new Simulation_Exception("\nCRASH " + name + " at Position: " + this.position);
					} catch (Simulation_Exception e) {
						e.printStackTrace();
					}
				}
				//Wenn der Weg frei ist, kann der Zug fahren, ansonsten gibt es einen Crash
			} else if (freeWay()) {
				move();
			} else {
				interrupt();
				try {
					throw new Simulation_Exception("\nCRASH " + name + " at Position: " + this.position);
				} catch (Simulation_Exception e) {
					e.printStackTrace();
				}
			}
			Thread.yield();
		}
	}
	/**
	 * Überprüft ob der Weg frei ist
	 * @return
	 */
	public boolean freeWay() {
		if (strecke.strecke[this.position + 1] == '-') {
			return true;
		} else
			return false;
	}
	/**
	 * Überprüft ob der nächste Block gesperrt ist
	 * @return
	 */
	public boolean locked() {
		if (strecke.currentBlock(this.position + 1).isLocked()) {
			return true;
		} else
			return false;

	}
	/**
	 * Überprüft ob es zu einem Crash kommt
	 * @return
	 */
	public boolean crash() {

		if (strecke.strecke[this.position - 1] != '-') {
			return true;
		} else
			return false;

	}
	/**
	 * Lässt den Zug auf der Strecke fahren
	 */
	public void move() {

		strecke.strecke[this.position] = '-';
		position++;
		strecke.strecke[this.position] = this.name;
		strecke.print();
	}

}
