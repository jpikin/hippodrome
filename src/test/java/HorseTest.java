import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

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
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "   ", "\n"})
    public void testConstructorWhenNameIsEmptyOrWhitespace(String illegalName) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(illegalName, 30.0, 30.0);});
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "   ", "\n"})
    public void testConstructorMessageWhenNameIsEmptyOrWhitespace(String illegalName) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(illegalName, 30.0, 30.0);});

        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    public void testConstructorNegativeSpeed(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Jan", -30.0, 30.0);
        });
    }

    @Test
    public void testConstructorMessageNegativeSpeed(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Jan", -30.0, 30.0);
        });
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    public void testConstructorNegativeDistance(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Jan", 30.0, -30.0);
        });
    }

    @Test
    public void testConstructorMessageNegativeDistance(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Jan", 30.0, -30.0);
        });
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    public void testGetName(){
        Horse horse = new Horse("Jan", 30.0, 30.0);
        assertEquals("Jan", horse.getName());
    }
    @Test
    public void testGetSpeed(){
        Horse horse = new Horse("Jan", 30.0, 30.0);
        assertEquals(30.0, horse.getSpeed());
    }

    @Test
    public void testGetDistance(){
        Horse horse = new Horse("Jan", 30.0, 30.0);
        assertEquals(30.0, horse.getDistance());
    }

    @Test
    public void testMove(){
        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            new Horse("Jan", 30.0, 30.1).move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

}

