package SimulationPack;

public class Strecke {

	private int km;
	private int blöckeZähler=0;
	
	public char[] strecke;
	
	public int getKm() {
		return km;
	}

	
	private Block blöcke[];
	private int blöckeAnzahl = 0;

	public Strecke(int km, int blöckeAnzahl) {
		this.km = km;
		this.blöcke = new Block[blöckeAnzahl];
		this.strecke = new char[km+blöckeAnzahl];
		for(int i = 0; i<km;i++){
			strecke[i]='-';
		}
		
	}


	public void addBlock(Block block) {
		if (blöckeAnzahl >= blöcke.length) {
			// Exception
		} else {
			blöcke[blöckeAnzahl] = block;
			blöckeAnzahl++;
			block.setAnfang(blöckeZähler);
			blöckeZähler+=block.getLänge();
		}
	}

	
	public Block ZugGetBlock(int position){
		int tempPosition=0;
		for(int i=0; i<=blöcke.length-1;i++){
			tempPosition+=blöcke[i].getLänge();
			if(tempPosition>position){
				return blöcke[i];
			}
		}
		return null;
	}
	
	public synchronized void print(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		for(char s:strecke){
			System.out.print(s);
		}
		
	}

	public synchronized void sperren(){
		int temp=0;
		for(int i=0; i<blöcke.length;i++){
			
			if(blöcke[i].isColor()){
				strecke[temp]='_';
				temp+=blöcke[i].getLänge();
			}else{
				strecke[temp]='|';
				temp+=blöcke[i].getLänge();
			}
				
		}
	}

	public void leave(Block block){
		boolean check=true;
		for(int i=block.getAnfang()+1;i<block.getLänge()+block.getAnfang()-1;i++){
			if(strecke[i]!='-'){
				check=false;
				break;
			}
		}
		if(check==true){
			block.leave();
		}
	}

}
