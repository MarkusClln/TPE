package Public;



/**
 * 
 * @author jensw
 *	@author markusc
 */
public class CrypterMain {

	public static void main(String[] args) throws CrypterException {
		  Crypter c;
	        Crypter d;
	        Crypter f;
	        String geheimeBotschaft = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
	        Key<String> keySub = new Key<>("MNBVCXYLKJHGFDSAPOIUZTREWQ");
	        Key<String> keyCaesar = new Key<>("V");
	        Key<String> keyXOR = new Key<>("EINSCHLUESSEL");
	        CrypterFactory CF = new CrypterFactory();
	        
	        //XOR
	        c = CF.getCrypter(EnumFactory.XOR,keyXOR);
	        geheimeBotschaft = stringEntschluesselung(geheimeBotschaft,c);

	        System.out.println(geheimeBotschaft);

	        //Caesar
	        d = CF.getCrypter(EnumFactory.CAESAR,keyCaesar);
	        geheimeBotschaft = stringEntschluesselung(geheimeBotschaft,d);

	        System.out.println(geheimeBotschaft);

	        //SUB
	        f = CF.getCrypter(EnumFactory.SUBSTITUTION,keySub);
	        geheimeBotschaft = stringEntschluesselung(geheimeBotschaft,f);

	        System.out.println(geheimeBotschaft);
		
		
		
		
/*
		Key<String> key = new Key<>("sdfjhkfdsjk");
		Key<String> key2= new Key<>("");
		Key<String> key3= new Key<>("TPERULES");
		System.out.println(key.getKey());
		CrypterFactory CF = new CrypterFactory();
		Crypter c = CF.getCrypter(EnumFactory.CAESAR, key2);
		//Crypter cB = CF.getCrypter(EnumFactory.SUBSTITUTION, key);
		//Crypter cC = CF.getCrypter(EnumFactory.XOR, key3);

		String ergebnis="CAESAR";
		String test = "FHK@BZ";
		//ergebnis= entschluesseln(ergebnis,cC);
		ergebnis= verschluesseln(ergebnis,c);
		//ergebnis= verschluesseln(ergebnis,cB);
		System.out.println(ergebnis);
	
		//test = entschluesseln(test, cC);
		//System.out.println(test);
		
		
		
		//System.out.println(verschluesseln("Hallo", c));
		//System.out.println(entschluesseln("BUFFI", c));
	
		//System.out.println(verschluesseln("WIKIPEDIAISTINFORMATIV" , cB));
		//System.out.println(entschluesseln("ZSMSYWPSUSTESNDQVOUESH" , cB));
	
		//System.out.println(verschluesseln("ABCDEFGHIJKLMNOPQRSTUVWXYZ",cC));
		//cC.reset();
		//System.out.println(entschluesseln("URFVPJB[]ZN^XBJCEBVF@ZRKMJ",cC));*/
	}
	
	/* public void testAufgabeF() throws  Exception{


	        Crypter c;
	        Crypter d;
	        Crypter f;
	        String geheimeBotschaft = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
	        Key<String> keySub = new Key<>("MNBVCXYLKJHGFDSAPOIUZTREWQ");
	        Key<String> keyCaesar = new Key<>("V");
	        Key<String> keyXOR = new Key<>("EINSCHLUESSEL");
	        CrypterFactory CF = new CrypterFactory();
	        
	        //XOR
	        c = CF.getCrypter(EnumFactory.XOR,keyXOR);
	        geheimeBotschaft = entschluesseln(geheimeBotschaft,c);

	        System.out.println(geheimeBotschaft);

	        //Caesar
	        d = CF.getCrypter(EnumFactory.CAESAR,keyCaesar);
	        geheimeBotschaft = entschluesseln(geheimeBotschaft,d);

	        System.out.println(geheimeBotschaft);

	        //SUB
	        f = CF.getCrypter(EnumFactory.SUBSTITUTION,keySub);
	        geheimeBotschaft = entschluesseln(geheimeBotschaft,f);

	        System.out.println(geheimeBotschaft);



	    }*/
	

	 protected String stringVerschluesselung(String string, Crypter crypter){
	        String erg = "";

	        for(int i = 0; i<string.length();i++){
	            try {
	                erg = erg +crypter.verschluesseln(string.charAt(i))+"";
	            } catch (CrypterException e) {
	                e.printStackTrace();
	            }
	        }

	        return erg;
	    }
	   
	    protected static String stringEntschluesselung(String string, Crypter crypter){
	        String erg = "";

	        for(int i = 0; i<string.length();i++){
	            try {
	                erg = erg +crypter.entschluesseln(string.charAt(i))+"";
	            } catch (CrypterException e) {
	                e.printStackTrace();
	            }
	        }

	        return erg;
	    }}
