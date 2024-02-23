package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BoaTest {

    @Test
    public void testIsHealthy() {
        assertIsHealthy("Boa1", 5, "granola bars", true);
        assertIsHealthy("Boa2", 8, "mice", false);
        assertIsHealthy("Boa3", 10, "granola bars", true);
        assertIsHealthy("Boa4", 15, "fish", false);
    }

    private void assertIsHealthy(String name, int length, String favoriteFood, boolean expected) {
        Boa boa = new Boa(name, length, favoriteFood);
        assertEquals(expected, boa.isHealthy());
    }

    @Test
    public void testFitsInCage() {
        assertFitsInCage(5, 10, true);
        assertFitsInCage(8, 5, false);
        assertFitsInCage(12, 15, true);
        assertFitsInCage(20, 18, false);
    }

    private void assertFitsInCage(int boaLength, int cageLength, boolean expected) {
        Boa boa = new Boa("TestBoa", boaLength, "AnyFood");
        assertEquals(expected, boa.fitsInCage(cageLength));
    }
}
