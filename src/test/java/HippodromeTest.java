import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HippodromeTest {

    @Test
    public void testConstructorWhenArgumentIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(null);
        });
    }

    @Test
    public void testConstructorMessageWhenArgumentIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(null);
        });
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    public void testConstructorWhenArgumentIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           new Hippodrome(new ArrayList<>());
        });
    }

    @Test
    public void testConstructorMessageWhenArgumentIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(new ArrayList<>());
        });
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

}
