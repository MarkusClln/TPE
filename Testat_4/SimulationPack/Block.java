package SimulationPack;

public class Block {

	private int länge;
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

	public int getLänge() {
		return länge;
	}

	public Block(int länge) {
		this.länge = länge;
		
	
	}

	public void enter() {
		color = false;
	}

	public void leave() {
		color = true;
	}
}
