package SimulationPack;

public class Block {

	private int laenge;
	private int anfang;
	private boolean locked=false;
	private int ende;
	
	public Block(int laenge) {
		this.laenge = laenge;
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

	public void sperren() {
		this.locked = true;
	}

	public synchronized void entsperren() {
		this.locked = false;
	}
}
