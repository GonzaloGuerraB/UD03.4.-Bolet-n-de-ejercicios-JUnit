package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilaTest {

	Pila pila;
	
	@BeforeEach
	void setUp() throws Exception {
		pila = new Pila();

	}

	@AfterEach
	void tearDown() throws Exception {
		pila = null;
	}

	@Test
    public void testPush() {
        pila.push(5);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testPushOutOfRange() {
        pila.push(1);
        assertTrue(pila.isEmpty());
    }

    @Test
    public void testPop() {
        pila.push(10);
        assertEquals(10, pila.pop());
        assertTrue(pila.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        assertNull(pila.pop());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(pila.isEmpty());
        pila.push(7);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testTop() {
        pila.push(15);
        assertEquals(15, pila.top());
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testTopEmptyStack() {
        assertNull(pila.top());
    }
}
