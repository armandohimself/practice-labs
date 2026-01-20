package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Maximum Product Subarray Tests")
class MaximumProductSubarrayTest {

    private MaximumProductSubarray solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "MaximumProductSubarray");
    }

    @Test
    @DisplayName("Example 1: [2,3,-2,4] should return 6")
    void testExample1() {
        int[] nums = {2, 3, -2, 4};
        assertEquals(6, solution.maxProduct(nums));
    }

    @Test
    @DisplayName("Example 2: [-2,0,-1] should return 0")
    void testExample2() {
        int[] nums = {-2, 0, -1};
        assertEquals(0, solution.maxProduct(nums));
    }

    @Test
    @DisplayName("Single element [5] should return 5")
    void testSingleElement() {
        int[] nums = {5};
        assertEquals(5, solution.maxProduct(nums));
    }

    @Test
    @DisplayName("Two negative numbers [-2,-3] should return 6")
    void testTwoNegatives() {
        int[] nums = {-2, -3};
        assertEquals(6, solution.maxProduct(nums));
    }

    @Test
    @DisplayName("Multiple negatives [-2,3,-4] should return 24")
    void testMultipleNegatives() {
        int[] nums = {-2, 3, -4};
        assertEquals(24, solution.maxProduct(nums));
    }

    @Test
    @DisplayName("With zeros [0,2] should return 2")
    void testWithZeros() {
        int[] nums = {0, 2};
        assertEquals(2, solution.maxProduct(nums));
    }
}
