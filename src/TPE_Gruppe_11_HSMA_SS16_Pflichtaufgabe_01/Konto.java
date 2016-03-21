package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;
//import TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01.Betrag;

public class Konto extends Betrag {
	private String inhaber;
	private Waehrung waehrung;
	private long guthaben;
	
	long[] konto1 = new long[10];
	
	 Konto(String inhaber,Waehrung waehrung, long guthaben){
		super(guthaben, waehrung);
		this.inhaber = inhaber;
	}
	
	void buche( Betrag betrag){
		
		if(this.waehrung==betrag.getWaehrung()){
			konto1[0] = betrag.getBetrag();
			
		}else{
			long erg = Waehrung.dollar.umrechnen(betrag.getBetrag(), this.waehrung);
			konto1[0] = erg;
		
			
		}
	}
	
	public void arrayAusgabe(){
		for(int i = 0; i<konto1.length; i++){
			System.out.println("Buchung "+ i + ": " + konto1[i]);
		}
	}
	
	public double saldo(){
		int erg = 0;
		for(int i = 0; i<konto1.length; i++){
			erg += konto1[i];
		}
		return erg;
	}
	
	public void gebuehren(){
		//nicht implementiert!
		
	}
	
	
	public String getInhaber(){
		return this.inhaber;
	}
	public Waehrung getWaehrung(){
		return this.waehrung;
	}
	public long getGuthaben() {
		return guthaben;
	}
}
