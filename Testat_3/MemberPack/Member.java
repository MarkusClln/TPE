package MemberPack;
public class Member {

	private int mitglieder_ID;
	private String nachname;
	private String vorname;
	private int mitgliedsjahre;

	public Member(int mitglieder_ID, String nachname, String vorname,
			int mitgliedsjahre) {
		this.mitglieder_ID = mitglieder_ID;
		this.nachname = nachname;
		this.vorname = vorname;
		this.mitgliedsjahre = mitgliedsjahre;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getMitgliedsjahre() {
		return mitgliedsjahre;
	}

	public void setMitgliedsjahre(int mitgliedsjahre) {
		this.mitgliedsjahre = mitgliedsjahre;
	}

	public int getMitglieder_ID() {
		return mitglieder_ID;
	}

	public String toString() {
		return "ID: " + mitglieder_ID + ", Nachname: " + nachname
				+ ", Vorname: " + vorname + ", Mitgliedsjahre: "
				+ mitgliedsjahre;
	}

}
