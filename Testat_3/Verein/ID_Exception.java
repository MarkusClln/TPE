package Verein;

public class ID_Exception extends Exception{
 String s;
 /**
  * Erstellt eine ID_Exception in welche die Fehlermeldung geschrieben werden kann
  * @param s Eingegebene Fehlermeldung
  */
 public ID_Exception(String s) {
  super(s);
  this.s = s;
 }
}