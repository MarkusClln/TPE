package SimulationPack;

public class Block {

	private int l�nge;
	private int anfang;
	
	public int getAnfang() {
		return anfang;
	}

	public void setAnfang(int anfang) {
		this.anfang = anfang;
	}

	private boolean color = true; // true = green false = red

	

	public boolean isColor() {
		return color;
	}

	public int getL�nge() {
		return l�nge;
	}

	public Block(int l�nge) {
		this.l�nge = l�nge;
		
	
	}

	public void enter() {
		color = false;
	}

	public void leave() {
		color = true;
	}
}
