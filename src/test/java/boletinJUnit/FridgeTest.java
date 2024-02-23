package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FridgeTest {

    private Fridge fridge;

    @BeforeEach
    public void setUp() {
        fridge = new Fridge();
    }

    @AfterEach
    public void tearDown() {
    	fridge = null;
    }

    @Test
    public void testPut() {
        String item = "apple";
        assertTrue(fridge.put(item));
        assertTrue(fridge.contains(item));
    }

    @Test
    public void testTake() throws NoSuchItemException {
        String item = "apple";

        fridge.put(item);
        assertTrue(fridge.contains(item));

        assertDoesNotThrow(() -> fridge.take(item));

        assertFalse(fridge.contains(item));
    }

    @Test
    public void testTakeNonExistentItem() {
        List<String> nonExistentItems = Arrays.asList("apple", "banana", "orange");

        for (String item : nonExistentItems) {
            assertThrows(NoSuchItemException.class, () -> fridge.take(item));
        }
    }
}
