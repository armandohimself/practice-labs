package practice.methodparameters;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParrotTest {
    Lab p = new Lab();

    /**
     * If p.copy is passed "hello", it should return "hello".
     */
    @Test
    public void parrotTestHello(){
        String input = "hello";
        String expected = "hello";
        String actual = p.copy(input);
        assertEquals(actual, expected);
    }
    /**
     * If p.copy is passed "polly", it should return "polly".
     */
    @Test
    public void parrotTestPolly(){
        String input = "polly";
        String expected = "polly";
        String actual = p.copy(input);
        assertEquals(actual, expected);
    }
}
