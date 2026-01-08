package practice.containsduplicates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;




public class ContainsDuplicatesTest {
    

    
    private ContainsDuplicatesSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.containsduplicates", "ContainsDuplicates");
    }

/**
     * The array {1, 2, 3, 4, 5} does not contain any duplicates, so containsDuplicate should return false.
     */
    @Test
    public void containsDuplicatesTest1(){
        int[] nums = {1, 2, 3, 4, 5};
        boolean target = false;
        assertEquals(target, solution.containsDuplicate(nums));
    }
    /**
     * The array {1, 2, 2, 3, 4, 5} contains duplicates, so containsDuplicate should return true.
     */
    @Test
    public void containsDuplicatesTest2(){
        int[] nums = {1, 2, 2, 3, 4, 5};
        boolean target = true;
        assertEquals(target, solution.containsDuplicate(nums));
    }
    /**
     * The array {1, 1, 1, 1, 1} contains duplicates, so containsDuplicate should return true.
     */
    @Test
    public void containsDuplicatesTest3(){
        int[] nums = {1, 1, 1, 1, 1};
        boolean target = true;
        assertEquals(target, solution.containsDuplicate(nums));
    }
    /**
     * The array {5,8,3,4,5,0} contains duplicates, so containsDuplicate should return true.
     */
    @Test
    public void containsDuplicatesTest4(){
        int[] nums = {5,8,3,4,5,0};
        boolean target = true;
        assertEquals(target, solution.containsDuplicate(nums));
    }
}
