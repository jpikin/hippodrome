import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HorseTest {

    @Test
    public void testConstructorWithNullName() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 30.0, 30.0);
        });
    }

    @Test
    public void testConstructorMessageWhenNameIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 30.0, 30.0);
        });
        assertEquals("Name cannot be null.", exception.getMessage());
    }

}

