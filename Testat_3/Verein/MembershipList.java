package Verein;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import MemberPack.Member;

public class MembershipList<K, V> extends HashMap<K, V> implements Map<K, V> {
	/**
	 * Eigene Put Methode die nur einen Member als Parameter übernimmt
	 * @param member
	 * @return falls Member_ID schon vorhanden ist null
	 * 			andernfalls wird die put(K,V) methode aufgerufen, wobei K die ID des übergebenen Members darstellt.
	 */
	public V put(Member member) {
		if (this.containsKey(member.getMitglieder_ID())) {
			System.out.println("ID SCHON VORHANDEN!");
			return null;
		}else
		return put((K) new Integer(member.getMitglieder_ID()), (V) member);
	}
	/**
	 * Ruft die toString Methode der HashMap auf
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
