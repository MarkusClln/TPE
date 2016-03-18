package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

public class Konto extends Betrag{
	private String inhaber;
	private Waehrung waehrung;
	private long guthaben;
	
	Konto(String inhaber,Waehrung waehrung, long guthaben){
		super(guthaben, waehrung);
		this.inhaber = inhaber;
		
		
	}
	void buche(Betrag betrag){
		if(this.waehrung==betrag.getWaehrung()){
			this.addiere(betrag);
		}else{
			Waehrung.umrechnen(betrag.getBetrag(), this.waehrung);
			this.addiere(betrag);
		}
	}
	public double saldo(){
		double saldo = (double) this.guthaben;
		return saldo/100;
	}
	public void gebuehren(){
		//noch nicht Fertig
	}
	
	
	public String getInhaber(){
		return this.inhaber;
	}
	public Waehrung getWaehrung(){
		return this.waehrung;
	}
}
