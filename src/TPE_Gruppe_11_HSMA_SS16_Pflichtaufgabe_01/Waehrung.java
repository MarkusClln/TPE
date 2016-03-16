package TPE_Gruppe_11_HSMA_SS16_Pflichtaufgabe_01;

public class Waehrung extends Waehrungen {
	private String name;
	private String kuerzel;
	private double kurs;

	Waehrung(String name, String kuerzel, double kurs) {
		this.name = name;
		this.kuerzel = kuerzel;
		this.kurs = kurs;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public double getKurs() {
		return kurs;
	}

	public String getName() {
		return name;
	}

	/*
	 * es muss long umrechnen(..) sein und long zurückgeben mit double
	 * funktioniert die Berechnung einwandfrei, aber laut Aufgabe ist long
	 * verlangt als Rückgabewert habs mit casten probiert, aber da wird dann nur
	 * die Stelle vorm Komma zurückgegeben
	 * 
	 */
	public double umrechnen(long betrag, String zielwaehrung) {
		double umgerechneterBetrag = 0;
		double dollar;

		dollar = (double) betrag * kurs;

		if (zielwaehrung == "€") {
			kurs = euro.getKurs();
			umgerechneterBetrag = dollar / kurs;
		} else if (zielwaehrung == "Y") {
			kurs = yen.getKurs();
			umgerechneterBetrag = dollar / kurs;
		} else if (zielwaehrung == "RUB") {
			kurs = rub.getKurs();
			umgerechneterBetrag = dollar / kurs;
		} else if (zielwaehrung == "CHF") {
			kurs = chf.getKurs();
			umgerechneterBetrag = dollar / kurs;
		} else if (zielwaehrung == "$") {
			umgerechneterBetrag = dollar;
		} else {
			System.out.println("Ungütlige Währung");
		}
		umgerechneterBetrag = Math.round(umgerechneterBetrag * 10000) / 10000.0;
		return umgerechneterBetrag;
	}

	public String toString() {
		return this.name + " " + "[" + this.kuerzel + "] " + "1 $ = " + this.kurs + " " + this.kuerzel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kuerzel == null) ? 0 : kuerzel.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waehrung other = (Waehrung) obj;
		if (kuerzel == null) {
			if (other.kuerzel != null)
				return false;
		} else if (!kuerzel.equals(other.kuerzel))
			return false;
		if (Double.doubleToLongBits(kurs) != Double.doubleToLongBits(other.kurs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
