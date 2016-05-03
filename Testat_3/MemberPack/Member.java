package MemberPack;
public class Member {

	private int mitglieder_ID;
	private String nachname;
	private String vorname;
	private int mitgliedsjahre;
	
	/**
	 * Erstellt ein neues Objekt vom Typ Member
	 * @param mitglieder_ID
	 * @param nachname
	 * @param vorname
	 * @param mitgliedsjahre
	 */
	public Member(int mitglieder_ID, String nachname, String vorname,
			int mitgliedsjahre) {
		this.mitglieder_ID = mitglieder_ID;
		this.nachname = nachname;
		this.vorname = vorname;
		this.mitgliedsjahre = mitgliedsjahre;
	}
	/**
	 * Gibt den nachnamen zurück
	 * @return nachname
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * Lässt den Nutzer den Nachnamen verändern
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/**
	 * Gibt den vornamen zurück
	 * @return vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * Lässt den Nutzer den Vornamen verändern
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * Gibt die Anzahl der Mitgliedsjahre zurück
	 * @return mitgliedsjahre
	 */
	public int getMitgliedsjahre() {
		return mitgliedsjahre;
	}
	/**
	 * Lässt den Nutzer die Mitgliedsjahre verändern
	 * @param mitgliedsjahre
	 */
	public void setMitgliedsjahre(int mitgliedsjahre) {
		this.mitgliedsjahre = mitgliedsjahre;
	}
	/**
	 * Gibt die Mitglieder ID zurück
	 * @return mitglieder_ID
	 */
	public int getMitglieder_ID() {
		return mitglieder_ID;
	}
	/**
	 * Gibt die Daten des Mitglieds formatiert in einem String aus
	 * @return String
	 */
	public String toString() {
		return "ID: " + mitglieder_ID + ", Nachname: " + nachname
				+ ", Vorname: " + vorname + ", Mitgliedsjahre: "
				+ mitgliedsjahre;
	}

}
