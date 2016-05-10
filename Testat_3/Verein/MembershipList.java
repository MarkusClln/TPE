package Verein;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import MemberPack.Member;

public class MembershipList<K, V> extends HashMap<K, V> implements Map<K, V> {
	/**
	 * Eigene put Methode die als Parameter nur einen Member hat.
	 * Ruft ueberschriebene Put-Methode auf.
	 */
	public V put(Member member) {
		return put((K) new Integer(member.getMitglieder_ID()), (V) member);
	}
	/**
	 * Ruft die toString Methode der HashMap auf
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	/**
	 * Put(K,V) ueberschrieben, damit geprüft wird ob Key schon vorhanden ist.
	 */
	@Override
	public V put(K Key, V Value){
		if(this.containsKey(Key)){
			return  null;
		}else{
			return super.put(Key, Value);
		}
	}
}
