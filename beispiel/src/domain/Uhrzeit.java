package domain;

public class Uhrzeit implements Comparable<Uhrzeit>{
	private short stunden;
	private short minuten;
	
	public Uhrzeit(short stunden, short minuten) throws IllegalUhrzeitException {
		validiereStunden(stunden);
		validiereMinuten(minuten);
		this.stunden = stunden;
		this.minuten = minuten;
	}
	
	public Uhrzeit(String uhrzeit) throws IllegalUhrzeitException {
		String[] teile = uhrzeit.split(":", 2);
		if (teile.length != 2) {
			throw new IllegalUhrzeitException("Uhrzeit muss ':' enthalten (Format hh:mm)");
		}
		
		short stunden, minuten;
		try {
			stunden = Short.parseShort(teile[0]);
			minuten = Short.parseShort(teile[1]);
		} catch (NumberFormatException ex) {
			throw new IllegalUhrzeitException("Stunden und Minuten müssen numerisch sein (Format hh:mm)");
		}
		
		validiereStunden(stunden);
		validiereMinuten(minuten);
		this.stunden = stunden;
		this.minuten = minuten;
	}
	
	public short getStunden() {
		return this.stunden;
	}
	
	public short getMinuten() {
		return this.minuten;
	}
	
	private static void validiereStunden(short stunden) throws IllegalUhrzeitException {
		if (stunden < 0 || stunden >= 24) {
			throw new IllegalUhrzeitException("Stunden müssen zwischen 0 und 23 sein");
		}
	}
	
	private static void validiereMinuten(short minuten) throws IllegalUhrzeitException {
		// Absichtlicher Fehler: Muss eigentlich `>= 60` sein
		if (minuten < 0 || minuten > 60) {
			throw new IllegalUhrzeitException("Minuten müssen zwischen 0 und 59 sein");
		}
	}

	@Override
	public int compareTo(Uhrzeit o) {
		if (this.stunden != o.stunden) {
			return this.stunden - o.stunden;
		}
		if (this.minuten != o.minuten) {
			return this.minuten - o.minuten;
		}
		return 0;
	}
}
