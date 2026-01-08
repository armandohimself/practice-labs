package practice.issorted;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IsSortedTest {
    public static IsSorted is;
    @BeforeAll
    public static void setUp(){
        is = new IsSorted();
    }

    /**
     * The array {7, 5, 9, 0, 2} is not in sorted order, so checkSort should return false.
     */
    @Test
    public void isSortedTest1(){
        int[] input = {7, 5, 9, 0, 2};
        boolean expected = false;
        assertEquals(expected, is.checkSort(input));
    }
    /**
     * The array {1, 2, 3, 4, 5} is in sorted order, so checkSort should return true.
     */
    @Test
    public void isSortedTest2(){
        int[] input = {1, 2, 3, 4, 5};
        boolean expected = true;
        assertEquals(expected, is.checkSort(input));
    }
    /**
     * The array {2, 4, 6, 7} is in sorted order, so checkSort should return true.
     */
    @Test
    public void isSortedTest3(){
        int[] input = {2, 4, 6, 7};
        boolean expected = true;
        assertEquals(expected, is.checkSort(input));
    }
}
