package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperadorAritmeticoTest {

	@Test
	void testSuma() {
		OperadorAritmetico a = new OperadorAritmetico();
		int suma = a.suma(1, 1);
		assertEquals(suma, 2);
	}

	@Test
	public void testDivisionValida() throws Exception {
		OperadorAritmetico a = new OperadorAritmetico();
		int resultado = a.division(10, 2);
		assertEquals(5, resultado);
	}

	@Test
	public void testDivisionPorCero() throws Exception {
		try {
			OperadorAritmetico a = new OperadorAritmetico();
			a.division(8, 0);
			fail("Se esperaba que lanzara una excepción");
		} catch (Exception e) {
			assertTrue(e instanceof Exception);
		}

	}

}
