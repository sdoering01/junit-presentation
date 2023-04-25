package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class SehenswürdigkeitenListeTest {

	@Test
	void testGetListeGeordnet() throws IllegalUhrzeitException {
		Sehenswürdigkeit sw1 = new Sehenswürdigkeit("Dom", new Uhrzeit("12:30"));
		Sehenswürdigkeit sw2 = new Sehenswürdigkeit("Rathaus", new Uhrzeit("11:00"));
		Sehenswürdigkeit sw3 = new Sehenswürdigkeit("Schlossgarten", new Uhrzeit("11:30"));
		SehenswürdigkeitenListe swl = new SehenswürdigkeitenListe();
		swl.fügeSehenswürdigkeitHinzu(sw1, sw2, sw3);
		List<Sehenswürdigkeit> liste = swl.getListeGeordnet();
		
		Sehenswürdigkeit[] soll = new Sehenswürdigkeit[] {sw2, sw3, sw1};
		Sehenswürdigkeit[] ist = liste.toArray(new Sehenswürdigkeit[3]);
		assertArrayEquals(soll, ist);
	}
	
	@Test
	void testSucheNachNamen() throws IllegalUhrzeitException {
		Sehenswürdigkeit sw1 = new Sehenswürdigkeit("Dom", new Uhrzeit("12:30"));
		Sehenswürdigkeit sw2 = new Sehenswürdigkeit("Rathaus", new Uhrzeit("11:00"));
		Sehenswürdigkeit sw3 = new Sehenswürdigkeit("Schlossgarten", new Uhrzeit("11:30"));
		SehenswürdigkeitenListe swl = new SehenswürdigkeitenListe();
		swl.fügeSehenswürdigkeitHinzu(sw1, sw2, sw3);
		
		assertEquals(sw1, swl.sucheNachNamen("Dom"));
		
		// Fehler absichtlich provoziert; Namen z.B. auf "Existiert nicht" ändern fixt den Test.
		Sehenswürdigkeit swSuche = swl.sucheNachNamen("Rathaus");
		// Hole Fehlermeldung über Supplier<String>
		Supplier<String> fehlerSupplier = () -> String.format("Sehenswürdigkeit mit Namen '%s' existiert irrtümlicherweise", swSuche.getName());
		assertNull(swSuche, fehlerSupplier);
	}

}
