package StreckePack;

public class Strecke {
	
	private int laenge;
	
	
	public Strecke(int laenge){
		this.laenge = laenge;
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < laenge; i++){
			str+="-";
		}
		return str;
	}
}
