package practice.arraysareequal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;




public class ArraysAreEqualTest {
    

    
    private ArraysAreEqualSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.arraysareequal", "ArraysAreEqual");
    }

/**
     * {0,1,2,3,4} is equal to {0,1,2,3,4}, so equal should return true.
     */
    @Test
    public void equalTest1(){
        int[] input1 = {0,1,2,3,4};
        int[] input2 = {0,1,2,3,4};
        boolean expected = true;
        boolean actual = solution.equal(input1, input2);
        assertEquals(expected, actual);
    }
    /**
     * {4,4,4,4,4} is not equal to {0,1,2,3,4}, so equal should return false.
     */
    @Test
    public void equalTest2(){
        int[] input1 = {4,4,4,4,4};
        int[] input2 = {0,1,2,3,4};
        boolean expected = false;
        boolean actual = solution.equal(input1, input2);
        assertEquals(expected, actual);
    }

    /**
     * {0,1,2,3,5} is not equal to {0,1,2,3,4}, so equal should return false.
     */
    @Test
    public void equalTest3(){
        int[] input1 = {0,1,2,3,5};
        int[] input2 = {0,1,2,3,4};
        boolean expected = false;
        boolean actual = solution.equal(input1, input2);
        assertEquals(expected, actual);
    }
}

