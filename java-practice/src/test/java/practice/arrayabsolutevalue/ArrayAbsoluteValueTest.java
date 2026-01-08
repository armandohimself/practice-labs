package practice.arrayabsolutevalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;




public class ArrayAbsoluteValueTest {
    

    
    private ArrayAbsoluteValueSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.arrayabsolutevalue", "ArrayAbsoluteValue");
    }

/**
     * given an input of {1, -3, 5, -6}, the absolute value of input is {1, 3, 5, 6}.
     */
    @Test
    public void abvTest1(){
        int[] nums = {1, -3, 5, -6};
        int[] target = {1, 3, 5, 6};
        assertArrayEquals(target, solution.getArrayAbs(nums));
    }

    /**
     * given an input of {1, 3, 5, 6}, the absolute value of input is {1, 3, 5, 6}.
     */
    @Test
    public void abvTest2(){
        int[] nums = {1, 3, 5, 6};
        int[] target = {1, 3, 5, 6};
        assertArrayEquals(target, solution.getArrayAbs(nums));
    }

    /**
     * given an input of {-4, -2}, the absolute value of input is {4, 2}.
     */
    @Test
    public void abvTest3(){
        int[] nums = {-4, -2};
        int[] target = {4, 2};
        assertArrayEquals(target, solution.getArrayAbs(nums));
    }

    /**
     * given an input of {9, 5, -4, 0, 2}, the absolute value of input is {9, 5, 4, 0, 2}.
     */
    @Test
    public void abvTest4(){
        int[] nums = {9, 5, -4, 0, 2};
        int[] target = {9, 5, 4, 0, 2};
        assertArrayEquals(target, solution.getArrayAbs(nums));
    }
}
