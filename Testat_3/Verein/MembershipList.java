package Verein;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import MemberPack.Member;

public class MembershipList<K, V> extends HashMap<K, V> implements Map<K, V> {

	public V put(Member member) {
		return put((K) new Integer(member.getMitglieder_ID()), (V) member);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
