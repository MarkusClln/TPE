package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;
//import TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01.Betrag;

public class Konto{
	private String inhaber;
	private Waehrung waehrung;
	private long guthaben;
	
	private Betrag[] konto = new Betrag[100];
	private int pointer =0;
	
	 Konto(String inhaber,Waehrung waehrung, long guthaben){
		this.inhaber=inhaber;
		this.waehrung=waehrung;
		this.guthaben=guthaben;
		 
		/* super(guthaben, waehrung);
		this.inhaber = inhaber;*/
	}
	
	void buche( Betrag betrag){
		
		konto[pointer]= betrag;
		if(this.waehrung==betrag.getWaehrung()){
			guthaben+=betrag.getBetrag();
			
		}else{
			long ergebnis= (long)(betrag.getWaehrung().getKurs()*betrag.getBetrag())*100;
			ergebnis *=this.waehrung.getKurs();
			guthaben+=ergebnis;
			
		}
		this.pointer++;
	}
	
	public String toString(){
		String ausgabe ="Kontoinhaber: "+this.inhaber+"\nWährung: "+this.waehrung.getName()+"\n-------------------------\n";
		for(int i = 0; konto[i]!=null; i++){
			ausgabe+=((double)konto[i].getBetrag())/100+" "+konto[i].getWaehrung().getKuerzel()+"\n";
		}
		ausgabe+="-------------------------\n"+((double)this.guthaben)/100+" "+this.waehrung.getKuerzel();
		return ausgabe;
	}
	
	
	public double saldo(){
		return guthaben;
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
