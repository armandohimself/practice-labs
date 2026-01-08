package practice.doesnotcontain;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DoesNotContainTest {
    static DoesNotContain c;
    @BeforeAll
    public static void setUp(){
        c = new DoesNotContain();
    }
    @Test
    public void containsTest1(){
        int[] input = {0,1,2,3,4};
        int target = 5;
        boolean expected = true;
        assertEquals(expected, c.arrayDoesNotContain(input, target));
    }
    @Test
    public void containTest2(){
        int[] input = {0,1,2,3,4};
        int target = 4;
        boolean expected = false;
        assertEquals(expected, c.arrayDoesNotContain(input, target));
    }
    @Test
    public void containTest3(){
        int[] input = {8,7,3,6};
        int target = 5;
        boolean expected = true;
        assertEquals(expected, c.arrayDoesNotContain(input, target));
    }
    @Test
    public void containTest4(){
        int[] input = {9,7,7,3};
        int target = 7;
        boolean expected = false;
        assertEquals(expected, c.arrayDoesNotContain(input, target));
    }

}
