package practice.average;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;




public class AverageTest {
    

    
    private AverageSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.average", "Average");
    }

/**
     * the average of {1, 3, 1, 3} should be 2.
     */
    @Test
    public void averageTest1(){
        int[] nums = {1, 3, 1, 3};
        double target = 2;
        double marginOfError = .1;
        assertEquals(target, solution.getAvg(nums), marginOfError);
    }
    /**
     * the average of {1, 2} should be 1.5.
     */
    @Test
    public void averageTest2(){
        int[] nums = {1, 2};
        double target = 1.5;
        double marginOfError = .1;
        assertEquals(target, solution.getAvg(nums), marginOfError);
    }
    /**
     * the average of {1, 2, 3} should be 2.
     */
    @Test
    public void averageTest3(){
        int[] nums = {1, 2, 3};
        double target = 2;
        double marginOfError = .1;
        assertEquals(target, solution.getAvg(nums), marginOfError);
    }
    /**
     * the average of {4, -4} should be 0.
     */
    @Test
    public void averageTest4(){
        int[] nums = {4, -4};
        double target = 0;
        double marginOfError = .1;
        assertEquals(target, solution.getAvg(nums), marginOfError);
    }
}
