package SimulationPack;

import GUI.Frame;

public class Strecke {

	private int laenge;
	public char strecke[];
	private Block bloecke[];
	private int bloeckeZaehler = 0;
	private int laengeCheck = 0;
	private Frame frame;
	public Strecke(int laenge, int bloecke,Frame frame) {
		this.laenge = laenge;
		strecke = new char[laenge];
		this.bloecke = new Block[bloecke];
		initialize();
		this.frame=frame;
		frame.GUI();
	
	}

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

	public Block currentBlock(int position){

	
		for(int i = 0; i < bloecke.length; i++){
			if(position>=bloecke[i].getAnfang()&&position<=bloecke[i].getEnde()){
				return bloecke[i];
			}
		}
		return null;
		
		

	}
	
	public void sperren(int position){
		currentBlock(position).sperren();
	}

	public void entsperren(int position){
		
		Block temp = currentBlock(position);
		boolean isNotBlocked = true;
		if(isNotBlocked == true){
			currentBlock(position).entsperren();
		}

	}

	public int getLaenge() {
		return laenge;
	}

	public void initialize(){
		
		for(int i=0;i<strecke.length;i++){
			strecke[i]='-';
		}
		
	}

}

