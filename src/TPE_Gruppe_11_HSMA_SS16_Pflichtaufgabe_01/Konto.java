package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;
//import TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01.Betrag;

public class Konto extends Betrag{
	private String inhaber;
//	private Waehrung waehrung;
//	private long guthaben;
	
	private Betrag[] konto = new Betrag[100];
	private int pointer =0;
	
	 Konto(String inhaber,Waehrung waehrung, double guthaben){
		/*this.inhaber=inhaber;
		this.waehrung=waehrung;
		this.guthaben=(long)(guthaben*100);*/
		super(guthaben, waehrung);
		this.inhaber = inhaber;
	}
	
	void buche( Betrag betrag){
		
		konto[pointer]= betrag;
		if(super.getWaehrung()==betrag.getWaehrung()){
			super.betrag+=betrag.getBetrag();
			
		}else{
			long ergebnis= (long)((betrag.getWaehrung().getKurs()*betrag.getBetrag())*100);
			ergebnis *=super.getWaehrung().getKurs();
			super.betrag+=ergebnis;
			
		}
		this.pointer++;
	}
	
	public String toString(){
		String ausgabe ="Kontoinhaber: "+this.inhaber+"\nWährung: "+super.getWaehrung().getName()+"\n-------------------------\n";
		for(int i = 0; konto[i]!=null; i++){
			ausgabe+=((double)konto[i].getBetrag())/100+" "+konto[i].getWaehrung().getKuerzel()+"\n";
		}
		ausgabe+="-------------------------\n"+"Saldo: "+((double)saldo())/100+" "+super.getWaehrung().getKuerzel();
		return ausgabe;
	}
	
	
	public double saldo(){
		return super.betrag;
	}
	
	public void gebuehren(){
	//	guthaben-=saldo()*
		
	}
	
	
	public String getInhaber(){
		return this.inhaber;
	}
	public Waehrung getWaehrung(){
		return super.getWaehrung();
	}
	public long getGuthaben() {
		return super.betrag;
	}
}
