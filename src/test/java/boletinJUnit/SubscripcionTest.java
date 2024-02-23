package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubscripcionTest {

	Subscripcion sub;

	@BeforeEach
	void setUp() {
		sub = new Subscripcion(10, 1);

	}

	@AfterEach
	void tearDown() {
		sub = null;
	}

	@Test
	void testPrecioPorMes() {
		assertEquals(sub.precioPorMes(), 10);
	}
	
	@Test
	void testPrecioNegativo() {
		sub = new Subscripcion(-1,10);
		assertTrue(sub.precioPorMes() < 0);
	}

	@Test
	void testSubNegativa() {
		sub = new Subscripcion(10,-1);
		assertTrue(sub.precioPorMes() < 0);
	}
	
	@Test
	void testRestoCero() {
		sub = new Subscripcion(5,13);
		assertTrue(sub.precioPorMes() >0);
	}
	
	@Test
	void testCancel() {
		sub.cancel();
		assertEquals(sub.precioPorMes(), 0);
	}

}
