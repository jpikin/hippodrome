import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String name = "Horse_" + i;
            horses.add(new Horse(name, 30.0, 30.0));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    public void testMoveMethod(){
        List<Horse> mockHorses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mockHorses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(mockHorses);
        hippodrome.move();
        for(Horse horse : mockHorses){
            verify(horse, atLeastOnce()).move();
        }
    }

    @Test
    public void testGetWinner() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = "Horse_" + i;
            double speed = 15.0 + i*0.1;
            horses.add(new Horse(name, speed, 30.0));
        }

        Horse testHorse = horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();

        Hippodrome hippodrome = new Hippodrome(horses);
        Horse speedyDriver = hippodrome.getWinner();
        assertEquals(testHorse, speedyDriver);

        
    }


}
