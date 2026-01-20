package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Maximum Subarray Tests")
class MaximumSubarrayTest {

    private MaximumSubarray solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "MaximumSubarray");
    }

    @Test
    @DisplayName("Example 1: [-2,1,-3,4,-1,2,1,-5,4] should return 6")
    void testExample1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, solution.maxSubArray(nums));
    }

    @Test
    @DisplayName("Example 2: [1] should return 1")
    void testExample2() {
        int[] nums = {1};
        assertEquals(1, solution.maxSubArray(nums));
    }

    @Test
    @DisplayName("Example 3: [5,4,-1,7,8] should return 23")
    void testExample3() {
        int[] nums = {5, 4, -1, 7, 8};
        assertEquals(23, solution.maxSubArray(nums));
    }

    @Test
    @DisplayName("All negative numbers should return the largest")
    void testAllNegative() {
        int[] nums = {-3, -2, -5, -1};
        assertEquals(-1, solution.maxSubArray(nums));
    }

    @Test
    @DisplayName("All positive numbers should return sum of all")
    void testAllPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(15, solution.maxSubArray(nums));
    }
}
