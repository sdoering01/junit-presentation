package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

class UhrzeitTest {

	@Test
	void testStundenMinutenKonstruktor() throws IllegalUhrzeitException {
		Uhrzeit u1 = new Uhrzeit((short) 12, (short) 30);
		assertEquals(12, u1.getStunden());
		assertEquals(30, u1.getMinuten());
		
		Uhrzeit u2 = new Uhrzeit((short) 18, (short) 57);
		assertEquals(18, u2.getStunden());
		assertEquals(57, u2.getMinuten());
		
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit((short) -1, (short) 15));
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit((short) 2, (short) 60));
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit((short) 1139, (short) -21));
	}
	
	@Test
	void testStringKonstruktor() throws IllegalUhrzeitException {
		Uhrzeit u1 = new Uhrzeit("12:30");
		assertEquals(12, u1.getStunden());
		assertEquals(30, u1.getMinuten());
		
		Uhrzeit u2 = new Uhrzeit("18:57");
		assertEquals(18, u2.getStunden());
		assertEquals(57, u2.getMinuten());
		
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit(""));
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit("1200"));
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit("24:00"));
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit("-1:18"));
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit("12:841"));
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit("129:-2"));
		assertThrows(IllegalUhrzeitException.class, () -> new Uhrzeit("Viertel vor acht"));
	}

	@Test
	void testCompareTo() throws IllegalUhrzeitException {
		Uhrzeit u1 = new Uhrzeit("12:30");
		Uhrzeit u2 = new Uhrzeit("12:30");
		assertEquals(0, u1.compareTo(u2));
		
		Uhrzeit u3 = new Uhrzeit("11:30");
		Uhrzeit u4 = new Uhrzeit("11:20");
		assertTrue(u3.compareTo(u4) > 0);
		
		Uhrzeit u5 = new Uhrzeit("10:00");
		Uhrzeit u6 = new Uhrzeit("11:00");
		assertTrue(u5.compareTo(u6) < 0);
		
		Uhrzeit u7 = new Uhrzeit("11:00");
		Uhrzeit u8 = new Uhrzeit("10:59");
		BooleanSupplier bs = () -> u7.compareTo(u8) > 0;
		assertTrue(bs);
	}
	
	@Test
	void testGetTotalMinuten() throws IllegalUhrzeitException {
		// Beispiel für Test Driven Development (TDD)
		Uhrzeit u1 = new Uhrzeit("12:30");
		assertEquals(750, u1.getGesamtMinuten());
	}

}
