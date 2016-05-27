package SimulationPack;

public class Block {

	private int laenge;
	private int anfang;
	private boolean locked=false;
	private int ende;
	/**
	 * Erstellt ein neues Objekt vom Typ Block
	 * @param laenge
	 */
	public Block(int laenge) {
		this.laenge = laenge;
	}

	/**
	 * Sperrt den Block
	 */
	public synchronized void sperren() {
		this.locked = true;
	}
	/**
	 * Entsperrt den Block und benachrichtigt den folgenden Zug
	 */
	public synchronized void entsperren() {
		synchronized(this){
		this.locked = false;
		this.notify();
		}
	}
	
	
	public void setEnde(int ende) {
		this.ende = ende;
	}

	public int getEnde() {
		return ende;
	}

	public void setAnfang(int anfang) {
		this.anfang = anfang;
	}

	public boolean isLocked() {
		return locked;
	}

	public int getLaenge() {
		return laenge;
	}

	public int getAnfang() {
		return anfang;
	}
}
