package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

public class Konto {
	private String inhaber;
	private Waehrung waehrung;
	private long guthaben;
	Konto(String inhaber,Waehrung waehrung){
		this.inhaber = inhaber;
		this.waehrung=waehrung;
		this.guthaben=0;
	}
	void buche(Betrag betrag){
		if(this.waehrung==betrag.getWaehrung()){
			this.guthaben+=(betrag.getAsDouble()*100);
		}
	}
	
	public String getInhaber(){
		return this.inhaber;
	}
	public Waehrung getWaehrung(){
		return this.waehrung;
	}
}
