package practice.isogram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.Before;

public class IsogramTest {
    
    
    private IsogramSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.isogram", "Isogram");
    }

@Before
    public void setUp(){
        iso = new Isogram();
    }

    /**
     * cat contains all its letters once, so it is an solution.
     */
    @Test
    public void isoTest1(){
        String input = "cat";
        boolean expected = true;
        boolean actual = iso.isIsogram(input);
        assertEquals(expected, actual);
    }

    /**
     * isogram contains all of its letters once, so it is an solution.
     */
    @Test
    public void isoTest2(){
        String input = "isogram";
        boolean expected = true;
        boolean actual = iso.isIsogram(input);
        assertEquals(expected, actual);
    }

    /**
     * uncopyrightable contains all of its letters once, so it is an solution.
     */
    @Test
    public void isoTest3(){
        String input = "uncopyrightable";
        boolean expected = true;
        boolean actual = iso.isIsogram(input);
        assertEquals(expected, actual);
    }

    /**
     * egg has repeating letters, so it is not an isogram
     */
    @Test
    public void isoTest4(){
        String input = "egg";
        boolean expected = false;
        boolean actual = iso.isIsogram(input);
        assertEquals(expected, actual);
    }

    /**
     * java has repeating letters, so it is not an isogram
     */
    @Test
    public void isoTest5(){
        String input = "java";
        boolean expected = false;
        boolean actual = iso.isIsogram(input);
        assertEquals(expected, actual);
    }

    /**
     * programming has repeating letters, so it is not an isogram
     */
    @Test
    public void isoTest6(){
        String input = "programming";
        boolean expected = false;
        boolean actual = iso.isIsogram(input);
        assertEquals(expected, actual);
    }
}
