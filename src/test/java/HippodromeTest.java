import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testGetHorsesMethod() {
        List<Horse> horses = listWithThirtyHorses();
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }


    private List<Horse> listWithThirtyHorses() {
        List<Horse> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String name = "Horse_" + i;
            list.add(new Horse(name, 30.0, 30.0));
        }
        return list;
    }

}
