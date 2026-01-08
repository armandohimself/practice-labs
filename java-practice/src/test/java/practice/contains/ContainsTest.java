package practice.contains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsTest {
    
    private ContainsSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.contains", "Contains");
    }

    /**
     * Given an array {0,1,2,3,4} and a value 5, arrayContains should return false because the array does not contain
     * the value.
     */
    @Test
    public void containsTest1(){
        int[] input = {0,1,2,3,4};
        int target = 5;
        boolean expected = false;
        assertEquals(expected, solution.arrayContains(input, target));
    }
    /**
     * Given an array {0,1,2,3,4} and a value 5, arrayContains should return true because the array contains
     * the value.
     */
    @Test
    public void containTest2(){
        int[] input = {0,1,2,3,4};
        int target = 4;
        boolean expected = true;
        assertEquals(expected, solution.arrayContains(input, target));
    }
    /**
     * Given an array {8,7,3,6} and a value 5, arrayContains should return false because the array does not contain
     * the value.
     */
    @Test
    public void containTest3(){
        int[] input = {8,7,3,6};
        int target = 5;
        boolean expected = false;
        assertEquals(expected, solution.arrayContains(input, target));
    }
    /**
     * Given an array {9,7,7,3} and a value 7, arrayContains should return true because the array contains
     * the value.
     */
    @Test
    public void containTest4(){
        int[] input = {9,7,7,3};
        int target = 7;
        boolean expected = true;
        assertEquals(expected, solution.arrayContains(input, target));
    }

}
