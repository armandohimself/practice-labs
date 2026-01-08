package practice.istheresum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

public class IsThereSumTest {
    
    private IsThereSumSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.istheresum", "IsThereSum");
    }

    /**
     * Given the input {2, 2, 3, 4, 5} and a target 4, there is a sum of 4 of 2+2.
     */
    @Test
    public void isThereSumTest1(){
        int[] input = {2, 2, 3, 4, 5};
        int target = 4;
        boolean expected = true;
        assertEquals(expected, solution.check(input, target));
    }
    /**
     * Given the input {2, 2, 3, 4, 5} and a target 5, there is a sum of 4 of 2+3.
     */
    @Test
    public void isThereSumTest2(){
        int[] input = {2, 2, 3, 4, 5};
        int target = 5;
        boolean expected = true;
        assertEquals(expected, solution.check(input, target));
    }
    /**
     * Given the input {2, 2, 3, 4, 5} and a target 11, there is no possible pair of numbers for a sum.
     */
    @Test
    public void isThereSumTest3(){
        int[] input = {2, 2, 3, 4, 5};
        int target = 11;
        boolean expected = false;
        assertEquals(expected, solution.check(input, target));
    }
    /**
     * Given the input {2, 2, 3, 4, 5} and a target 10, there no possible pair of numbers for a sum because
     * the number 5 may not be added to itself.
     */
    @Test
    public void isThereSumTest4(){
        int[] input = {2, 2, 3, 4, 5};
        int target = 10;
        boolean expected = false;
        assertEquals(expected, solution.check(input, target));
    }
}
