package practice.charcomparison;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharComparisonTest {
    CharComparison cc = new CharComparison();

    /**
     * 'cat' is before 'dog' in the dictionary, so compare should return -1.
     */
    @Test
    public void charCompareTest1(){
        char[] input1 = {'c', 'a', 't'};
        char[] input2 = {'d', 'o', 'g'};
        int expected = -1;
        int actual = cc.compare(input1, input2);
        assertEquals(actual, expected);

    }

    /**
     * 'mouse' is after 'dog' in the dictionary, so compare should return 1.
     */
    @Test
    public void charCompareTest2(){
        char[] input1 = {'m', 'o', 'u', 's', 'e'};
        char[] input2 = {'d', 'o', 'g'};
        int expected = 1;
        int actual = cc.compare(input1, input2);
        assertEquals(actual, expected);
    }

    /**
     * 'mouse' is exactly equal to 'mouse', so compare should return 0.
     */
    @Test
    public void charCompareTest3(){
        char[] input1 = {'m', 'o', 'u', 's', 'e'};
        char[] input2 = {'m', 'o', 'u', 's', 'e'};
        int expected = 0;
        int actual = cc.compare(input1, input2);
        assertEquals(actual, expected);
    }

    /**
     * 'dot' is after 'dog' in the dictionary, so compare should return 1.
     */
    @Test
    public void charCompareTest4(){
        char[] input1 = {'d', 'o', 't'};
        char[] input2 = {'d', 'o', 'g'};
        int expected = 1;
        int actual = cc.compare(input1, input2);
        assertEquals(actual, expected);

    }
}
