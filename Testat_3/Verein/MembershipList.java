package Verein;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import MemberPack.Member;

public class MembershipList<K, V> extends HashMap<K, V> implements Map<K, V> {

	public V put(Member member) {
		  
		  try {
		   if (this.containsKey(member.getMitglieder_ID())) {
		    throw new ID_Exception("ID schon vorhanden");
		   }else
		   return put((K) new Integer(member.getMitglieder_ID()), (V) member);
		  } catch (ID_Exception e) {
		   e.printStackTrace();
		  }
		  return null;
		 }

	@Override
	public String toString() {
		return super.toString();
	}
}
