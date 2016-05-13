package SimulationPack;

public class Strecke {

	private int km;
	private int bl�ckeZ�hler=0;
	
	public char[] strecke;
	
	public int getKm() {
		return km;
	}

	
	private Block bl�cke[];
	private int bl�ckeAnzahl = 0;

	public Strecke(int km, int bl�ckeAnzahl) {
		this.km = km;
		this.bl�cke = new Block[bl�ckeAnzahl];
		this.strecke = new char[km+bl�ckeAnzahl];
		for(int i = 0; i<km;i++){
			strecke[i]='-';
		}
		
	}


	public void addBlock(Block block) {
		if (bl�ckeAnzahl >= bl�cke.length) {
			// Exception
		} else {
			bl�cke[bl�ckeAnzahl] = block;
			bl�ckeAnzahl++;
			block.setAnfang(bl�ckeZ�hler);
			bl�ckeZ�hler+=block.getL�nge();
		}
	}

	
	public Block ZugGetBlock(int position){
		int tempPosition=0;
		for(int i=0; i<=bl�cke.length-1;i++){
			tempPosition+=bl�cke[i].getL�nge();
			if(tempPosition>position){
				return bl�cke[i];
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
		for(int i=0; i<bl�cke.length;i++){
			
			if(bl�cke[i].isColor()){
				strecke[temp]='_';
				temp+=bl�cke[i].getL�nge();
			}else{
				strecke[temp]='|';
				temp+=bl�cke[i].getL�nge();
			}
				
		}
	}

	public void leave(Block block){
		boolean check=true;
		for(int i=block.getAnfang()+1;i<block.getL�nge()+block.getAnfang()-1;i++){
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
