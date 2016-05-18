package StreckePack;

import BlockPack.Block;

public class Strecke {

	private int laenge;
	public char strecke[];
	private Block bloecke[];
	private int bloeckeZaehler = 0;
	private int laengeCheck = 0;
	
	public Strecke(int laenge, int bloecke) {
		this.laenge = laenge;
		strecke = new char[laenge];
		this.bloecke = new Block[bloecke];
		initialize();
	
	
	}

	public synchronized void  print() {
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n");
		for (int i = 0; i < bloecke.length; i++) {
			if (bloecke[i].isLocked()) {
				System.out.print('|');
			} else
				System.out.print('_');
			
			for (int q = bloecke[i].getAnfang(); q < bloecke[i].getAnfang()
					+ bloecke[i].getLaenge(); q++) {
				System.out.print(strecke[q]);
			
			}

		}
	}

	public void addBlock(Block block) {
		if (bloeckeZaehler >= bloecke.length) {
			// Exception zu Viele Blöcke

		} else if (laengeCheck+block.getLaenge()> laenge) {
			// Exception Länge zu lang
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
		
		/*for(int i= temp.getAnfang()+1; i <= temp.getAnfang()+1+temp.getLaenge();i++){
			if(strecke[i]!='-'){
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				isNotBlocked=false;
				break;
			}
		}*/
		
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

	public synchronized void wakeUp(){
		notifyAll();
	}
}

