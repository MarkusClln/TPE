package SimulationPack;

import GUI.Frame;

public class Strecke {

	private int laenge;
	public char strecke[];
	private Block bloecke[];
	private int bloeckeZaehler = 0;
	private int laengeCheck = 0;
	private Frame frame;
	/**
	 * Erstellt ein neues Objekt vom Typ Strecke
	 * @param laenge
	 * @param bloecke
	 * @param frame
	 */
	public Strecke(int laenge, int bloecke,Frame frame) {
		this.laenge = laenge;
		strecke = new char[laenge];
		this.bloecke = new Block[bloecke];
		initialize();
		this.frame=frame;
		frame.GUI();
	
	}
	/**
	 * Gibt die Strecke im Frame aus
	 */
	public synchronized void  print() {
		
		String s="";
		for (int i = 0; i < bloecke.length; i++) {
			if (bloecke[i].isLocked()) {
				s+="|";	
			} else
				s+="_";	
			
			for (int q = bloecke[i].getAnfang(); q < bloecke[i].getAnfang()
					+ bloecke[i].getLaenge(); q++) {
				s+=strecke[q]; 
			
			}
			
		}
		frame.setText(s);
	}
	/**
	 * Fügt die übergebenen Blöcke zur Strecke hinzu
	 * @param block
	 */
	public void addBlock(Block block) {
		if (bloeckeZaehler >= bloecke.length) {
			try{
				throw new Simulation_Exception("Zu viele Bloecke");
			}catch(Simulation_Exception e){
				e.printStackTrace();
			}
		} else if (laengeCheck+block.getLaenge()> laenge) {
		
			try{
				throw new Simulation_Exception("Strecke zu kurz");
			}catch(Simulation_Exception e){
				e.printStackTrace();
			}
		} else {
			bloecke[bloeckeZaehler] = block;
			bloeckeZaehler++;
			block.setAnfang(laengeCheck);
			laengeCheck += block.getLaenge()-1;
			block.setEnde(laengeCheck);
			laengeCheck++;
		
			
		}
	}
	/**
	 * liefert den entsprechenden Block an einer übergebenen Position zurück
	 * @param position
	 * @return
	 */
	public Block currentBlock(int position){
		for(int i = 0; i < bloecke.length; i++){
			if(position>=bloecke[i].getAnfang()&&position<=bloecke[i].getEnde()){
				return bloecke[i];
			}
		}
		return null;
	}
	
	/**
	 * Sperrt den Block an übergebener Position und greift auf die sperren Methode aus Block zu
	 * @param position
	 */
	public void sperren(int position){
		currentBlock(position).sperren();
	}
	/**
	 * Entsperrt den Block an übergebener Position und greift auf die entsperren Methode aus Block zu
	 * @param position
	 */
	public void entsperren(int position){
		
		Block temp = currentBlock(position);
		boolean isNotBlocked = true;
		if(isNotBlocked == true){
			currentBlock(position).entsperren();
		}

	}
	/**
	 * Initialisiert die Strecke
	 */
	public void initialize(){
		for(int i=0;i<strecke.length;i++){
			strecke[i]='-';
		}
	}
	
	public int getLaenge() {
		return laenge;
	}


}

