package practice.insertposition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;




public class InsertPositionTest {
    

    
    private InsertPositionSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.insertposition", "InsertPosition");
    }

/**
     * In the array {1, 3, 5, 6}, 4 would be inserted at index 2.
     */
    @Test
    public void testSearchInsert1() {
        int[] nums = {1, 3, 5, 6};
        int target = 4;

        assertEquals(2, solution.searchInsert(nums, target));
    }
    /**
     * In the array {1, 3, 5, 6}, 2 would be inserted at index 1.
     */
    @Test
    public void testSearchInsert2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        assertEquals(1, solution.searchInsert(nums, target));
    }
    /**
     * In the array {1, 3, 5, 6}, 7 would be inserted at index 4.
     */
    @Test
    public void testSearchInsert3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;

        assertEquals(4, solution.searchInsert(nums, target));
    }
    /**
     * In the array {2}, 1 would be inserted at index 0.
     */
    @Test
    public void testSearchInsert4() {
        int[] nums = {2};
        int target = 1;

        assertEquals(0, solution.searchInsert(nums, target));
    }
    /**
     * In the array {1, 3, 5, 6, 8}, 7 would be inserted at index 4.
     */
    @Test
    public void testSearchInsert5() {
        int[] nums = {1, 3, 5, 6, 8};
        int target = 7;

        assertEquals(4, solution.searchInsert(nums, target));
    }
}