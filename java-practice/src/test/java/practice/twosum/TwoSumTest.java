package practice.twosum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for TwoSum challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: TwoSum2.java, TwoSum3.java, etc.
 *
 * Override target with: PRACTICE_TARGET=TwoSum2 ./gradlew test
 */
@DisplayName("TwoSum Challenge Tests")
class TwoSumTest {

    private TwoSum solution;

    @BeforeEach
    void setUp() throws Exception {
        // Automatically resolve to the latest implementation
        solution = TargetResolver.resolve("practice.twosum", "TwoSum");
    }

    @Test
    @DisplayName("Sample Test Case 1: Basic case [2,7,11,15], target 9")
    void testSampleCase1() {
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        assertArrayEquals(new int[]{0, 1}, result, "Should return [0, 1] because 2 + 7 = 9");
    }

    @Test
    @DisplayName("Sample Test Case 2: [1,3,4,2], target 6")
    void testSampleCase2() {
        int[] nums = {1, 3, 4, 2};
        int[] result = solution.twoSum(nums, 6);
        assertArrayEquals(new int[]{2, 3}, result, "Should return [2, 3] because 4 + 2 = 6");
    }

    @Test
    @DisplayName("Sample Test Case 3: Duplicate values [3,2,3], target 6")
    void testSampleCase3() {
        int[] nums = {3, 2, 3};
        int[] result = solution.twoSum(nums, 6);
        assertArrayEquals(new int[]{0, 2}, result, "Should return [0, 2] because 3 + 3 = 6");
    }

    @Test
    @DisplayName("Edge Case: Two elements only")
    void testTwoElements() {
        int[] nums = {5, 10};
        int[] result = solution.twoSum(nums, 15);
        assertArrayEquals(new int[]{0, 1}, result, "Should return [0, 1] for two element array");
    }

    @Test
    @DisplayName("Edge Case: Solution at the end of array")
    void testSolutionAtEnd() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] result = solution.twoSum(nums, 11);
        assertArrayEquals(new int[]{4, 5}, result, "Should find solution at end: 5 + 6 = 11");
    }

    @Test
    @DisplayName("Edge Case: Negative numbers")
    void testNegativeNumbers() {
        int[] nums = {-3, 4, 3, 90};
        int[] result = solution.twoSum(nums, 0);
        assertArrayEquals(new int[]{0, 2}, result, "Should handle negative numbers: -3 + 3 = 0");
    }

    @Test
    @DisplayName("Edge Case: All negative numbers")
    void testAllNegativeNumbers() {
        int[] nums = {-10, -5, -3, -1};
        int[] result = solution.twoSum(nums, -8);
        assertArrayEquals(new int[]{1, 2}, result, "Should work with all negatives: -5 + -3 = -8");
    }

    @Test
    @DisplayName("Edge Case: Zero in array")
    void testWithZero() {
        int[] nums = {0, 4, 3, 0};
        int[] result = solution.twoSum(nums, 0);
        assertArrayEquals(new int[]{0, 3}, result, "Should handle zeros: 0 + 0 = 0");
    }

    @Test
    @DisplayName("Edge Case: Large numbers")
    void testLargeNumbers() {
        int[] nums = {1000000, 2000000, 3000000};
        int[] result = solution.twoSum(nums, 5000000);
        assertArrayEquals(new int[]{1, 2}, result, "Should handle large numbers: 2000000 + 3000000 = 5000000");
    }

    @Test
    @DisplayName("Edge Case: Solution at beginning")
    void testSolutionAtBeginning() {
        int[] nums = {10, 5, 100, 200, 300};
        int[] result = solution.twoSum(nums, 15);
        assertArrayEquals(new int[]{0, 1}, result, "Should find solution at beginning: 10 + 5 = 15");
    }

    @Test
    @DisplayName("Edge Case: Middle elements sum to target")
    void testMiddleElements() {
        int[] nums = {1, 2, 7, 15, 4, 3};
        int[] result = solution.twoSum(nums, 22);
        assertArrayEquals(new int[]{2, 3}, result, "Should find middle elements: 7 + 15 = 22");
    }

    @Test
    @DisplayName("Performance: Larger array")
    void testLargerArray() {
        int[] nums = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int[] result = solution.twoSum(nums, 28);
        assertArrayEquals(new int[]{3, 9}, result, "Should efficiently find: 8 + 20 = 28");
    }
}
