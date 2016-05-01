package JUnit_Tests;

import Public.Crypter;
import Public.CrypterException;

public class StringMethodsForTests {
	
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
	   
	    protected String stringEntschluesselung(String string, Crypter crypter){
	        String erg = "";

	        for(int i = 0; i<string.length();i++){
	            try {
	                erg = erg +crypter.entschluesseln(string.charAt(i))+"";
	            } catch (CrypterException e) {
	                e.printStackTrace();
	            }
	        }

	        return erg;
	    }
}
