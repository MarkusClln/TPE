package Verein;
import MemberPack.Member;

public class ClubManagement extends MembershipList {
	public static void main(String[] args) {
		MembershipList<Integer, Member> verein = new MembershipList<Integer, Member>();
		Member eins = new Member(2, "Mustermann", "Hans", 16);
		Member zwei = new Member(6, "Koch", "Anette", 15);
		Member drei = new Member(5, "Simpson", "Bart", 9);
		Member vier = new Member(3, "Simpson", "Lisa", 5);
		Member fuenf = new Member(2, "Simpson", "Lisa", 5);
		verein.put(eins);
		verein.put(zwei);
		verein.put(drei);
		verein.put(vier);
		System.out.println(verein.toString());
		System.out.println("Liste 1 Länge: " + verein.size());
		verein.forEach((a, b) -> System.out.println(b));

		verein.remove(2);
		MembershipList<Integer, Member> verein2 = new MembershipList<Integer, Member>();
		verein2.putAll(verein);
		System.out.println("\nVereinsliste 2\n");
		verein2.forEach((a, b) -> System.out.println(b));

		System.out.println("\nListe1+2");
		verein2.putAll(verein);
		verein2.put(fuenf);
		verein2.forEach((a, b) -> System.out.println(b));

		System.out.println("\nID 2 in liste 1?");
		if (verein.containsKey(2)) {
			System.out.println(verein.get(2));
		} else {
			System.out.println("Nicht vorhanden in liste1!");
		}

		System.out.println("\nID2 in liste 2?");
		if (verein2.containsKey(2)) {
			System.out.println(verein2.get(2));
		} else {
			System.out.println("Nicht vorhanden in liste 2!");
		}

		System.out.println("\nID5 aus liste 2");
		System.out.println(verein2.get(5));
		System.out.println("\nVorname = günther");
		verein2.get(5).setVorname("Günther");
		System.out.println(verein2.get(5));

		System.out.println("lösche id 5 aus verein2");
		verein2.remove(5);

		System.out.println("\nListe1: ");
		verein.forEach((a, b) -> System.out.println(b));

		System.out.println("\nListe2: ");
		verein2.forEach((a, b) -> System.out.println(b));

		verein.clear();
		verein2.clear();
		System.out.println("Liste1 länge: " + verein.size());
		System.out.println(("Liste2 länge:" + verein2.size()));
	}
}
