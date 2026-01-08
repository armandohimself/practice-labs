package practice.introtooop;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BirdTest {
    /**
     * If ageMonths is less than 3, birds should say "Tweet".
     */
    @Test
    public void birdTest1(){
        Bird b1 = new Bird();
        b1.ageMonths = 0;
        String expected = "Tweet";
        String actual = b1.sound();
        assertEquals(actual, expected);
    }
    /**
     * If ageMonths is less than 3, birds should say "Chirp".
     */
    @Test
    public void birdTest2(){
        Bird b1 = new Bird();
        b1.ageMonths = 4;
        String expected = "Chirp";
        String actual = b1.sound();
        assertEquals(actual, expected);
    }
    /**
     * If ageMonths is less than 3, birds should say "Chirp".
     */
    @Test
    public void birdTest3(){
        Bird b1 = new Bird();
        b1.ageMonths = 3;
        String expected = "Chirp";
        String actual = b1.sound();
        assertEquals(actual, expected);
    }
}
