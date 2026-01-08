package practice.isogram;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsogramTest {
    Isogram iso;
    @BeforeEach
    public void setUp(){
        iso = new Isogram();
    }

    /**
     * cat contains all its letters once, so it is an isogram.
     */
    @Test
    public void isoTest1(){
        String input = "cat";
        boolean expected = true;
        boolean actual = iso.isIsogram(input);
        assertEquals(actual, expected);
    }

    /**
     * isogram contains all of its letters once, so it is an isogram.
     */
    @Test
    public void isoTest2(){
        String input = "isogram";
        boolean expected = true;
        boolean actual = iso.isIsogram(input);
        assertEquals(actual, expected);
    }

    /**
     * uncopyrightable contains all of its letters once, so it is an isogram.
     */
    @Test
    public void isoTest3(){
        String input = "uncopyrightable";
        boolean expected = true;
        boolean actual = iso.isIsogram(input);
        assertEquals(actual, expected);
    }

    /**
     * egg has repeating letters, so it is not an isogram
     */
    @Test
    public void isoTest4(){
        String input = "egg";
        boolean expected = false;
        boolean actual = iso.isIsogram(input);
        assertEquals(actual, expected);
    }

    /**
     * java has repeating letters, so it is not an isogram
     */
    @Test
    public void isoTest5(){
        String input = "java";
        boolean expected = false;
        boolean actual = iso.isIsogram(input);
        assertEquals(actual, expected);
    }

    /**
     * programming has repeating letters, so it is not an isogram
     */
    @Test
    public void isoTest6(){
        String input = "programming";
        boolean expected = false;
        boolean actual = iso.isIsogram(input);
        assertEquals(actual, expected);
    }
}
