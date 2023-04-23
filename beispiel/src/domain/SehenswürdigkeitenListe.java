package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SehenswürdigkeitenListe {
	private List<Sehenswürdigkeit> liste = new ArrayList<>();
	
	public SehenswürdigkeitenListe() {}

	public List<Sehenswürdigkeit> getListeGeordnet() {
		return Collections.unmodifiableList(this.liste);
	}
	
	public boolean fügeSehenswürdigkeitHinzu(Sehenswürdigkeit sw) {
		int idx = 0;
		for (Sehenswürdigkeit vorhanden: this.liste) {
			if (vorhanden.getName().equals(sw.getName())) {
				return false;
			}
			if (vorhanden.getZeitpunkt().compareTo(sw.getZeitpunkt()) < 0) {
				idx++;
			}
		}
		this.liste.add(idx, sw);
		return true;
	}
	
	public boolean[] fügeSehenswürdigkeitHinzu(Sehenswürdigkeit... sw) {
		boolean[] returns = new boolean[sw.length];
		for (int i = 0; i < sw.length; i++) {
			returns[i] = fügeSehenswürdigkeitHinzu(sw[i]);
		}
		return returns;
	}
	
	public boolean löscheSehenswürdigkeit(Sehenswürdigkeit sw) {
		return this.liste.remove(sw);
	}
	
	public Sehenswürdigkeit sucheNachNamen(String name) {
		for (Sehenswürdigkeit sw: this.liste) {
			if (sw.getName().equals(name)) {
				return sw;
			}
		}
		return null;
	}
}
