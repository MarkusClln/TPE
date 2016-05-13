package SimulationPack;

public class Zug implements Runnable{

	private int km_h;
	private char name;
	private int position;
	Strecke strecke;
	
	public Zug(int km_h,char name,int position, Strecke strecke){
		this.km_h=km_h;
		this.name=name;
		this.position=position;
		this.strecke = strecke;
		
	}
	
	@Override
	public synchronized void run() {
		while(position<strecke.getKm()-1){	
			
			
			try {
				Thread.sleep(1000/km_h);
				} catch (InterruptedException e) {
				break;
				}
			
			if(strecke.strecke[position-1]!='-'&&strecke.strecke[position-1]!='|'&&strecke.strecke[position-1]!='_'){
				try {
					while (true) {
					synchronized(this) {		    
						       this.wait();		      
					}   
						} 
					} catch (InterruptedException e) {				
			}
			}
			
			
			
			
			if(strecke.strecke[position+1]=='-'){
				move();
			}else if(strecke.strecke[position+1]=='|'){
				
			
			/*	
				try {
					while (true) {
					synchronized(this) {		    
						       this.wait();		      
					}   
						} 
					} catch (InterruptedException e) {				
			}
			*/
			
			}else if(strecke.strecke[position+1]=='_'){
				
				strecke.leave(strecke.ZugGetBlock(position));
				strecke.ZugGetBlock(position+1).enter();	
				move();
			}else{
			
				
				try {
					while (true) {
					synchronized(this) {		    
						       this.wait();		      
					}   
						} 
					} catch (InterruptedException e) {				
			}
				
				
			}
			
			
			
				
			
			
			
			
			
			
			
			
		
	}
		strecke.strecke[position]='-';
		strecke.leave(strecke.ZugGetBlock(position));
		strecke.sperren();
		strecke.print();
	}

	
	public synchronized void move(){
		if(position==1){
			strecke.ZugGetBlock(position).enter();
			strecke.sperren();
		}
		
		if(strecke.strecke[position+1]=='_'){
			strecke.strecke[position+2]=name;
			strecke.strecke[position]='-';
			position+=2;
			strecke.sperren();
		}else if(strecke.strecke[position+1]=='-'){
			strecke.strecke[position+1]=name;
			strecke.strecke[position]='-';
			position++;
		}
		
		strecke.print();
	}
	
	
	
	
	
	public char getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}	

	
	
}
