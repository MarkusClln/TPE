package ZugPack;

import StreckePack.Strecke;

public class Zug implements Runnable {
	char zug;
	boolean bewegen;
	int position;
	Strecke str;
	
	public Zug(char zug, int position, Strecke str) {
		this.zug = zug;
		this.bewegen = true;
		this.str = str;
		this.position = position;
	}
	
	public void waitZug() {
		synchronized(this){
			try{ 
				wait();
				bewegen = false;
			}catch(InterruptedException e){}
		}
	}
	
	public void notifyZug() {
		synchronized(this) {
			this.notify();
		}
	}
	
	public void run() {
		while(bewegen){
			bewegeZug();

		}
	}
	
	public void bewegeZug(){
		int i;
		char c;
		for(i = position; i < str.toString().length(); i++){
			c = str.toString().charAt(i);
			if(c == '-'){
				c = zug;
			
				System.out.println(c);
			}
			if(str.toString().charAt(i) == '|'){
				waitZug();
			}
			c = '-';
			
			position++;
			System.out.println(c);
		}
		
	}
}