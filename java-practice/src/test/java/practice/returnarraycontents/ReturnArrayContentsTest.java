package practice.returnarraycontents;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReturnArrayContentsTest {
    Lab rac = new Lab();

    /**
     * given input {1,2,3,4,5}, arrayToString should return 1 2 3 4 5.
     */
    @Test
    public void arrayStringTest1(){
        int[] input = {1,2,3,4,5};
        String expected = "1 2 3 4 5";
        String actual = rac.arrayToString(input).trim();
        assertEquals(actual, expected);
    }
    /**
     * given input {9,8,7}, arrayToString should return 9 8 7.
     */
    @Test
    public void arrayStringTest2(){
        int[] input = {9,8,7};
        String expected = "9 8 7";
        String actual = rac.arrayToString(input).trim();
        assertEquals(actual, expected);
    }
}
