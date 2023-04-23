package domain;

public class Sehenswürdigkeit {
	private String name;
	private Uhrzeit start;
	
	public Sehenswürdigkeit(String name, Uhrzeit start) {
		this.name = name;
		this.start = start;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Uhrzeit getZeitpunkt() {
		return this.start;
	}
}
