package test.java.practice.largestsum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for LargestSum challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: LargestSum2.java, LargestSum3.java, etc.
 *
 * Override target with: PRACTICE_TARGET=LargestSum2 ./gradlew test
 */
@DisplayName("LargestSum Challenge Tests")
class LargestSumTest {

    private LargestSumSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        // Automatically resolve to the latest implementation
        solution = TargetResolver.resolve("practice.largestsum", "LargestSum");
    }

    @Test
    @DisplayName("Should handle duplicates (5+5=10)")
    void testDuplicatesAllowed() {
        List<Integer> nums = Arrays.asList(5, 4, 2, 5, 0);
        assertEquals(10, solution.bigSum(nums),
            "Sum of two largest should be 5 + 5 = 10");
    }

    @Test
    @DisplayName("Should handle normal case (5+4=9)")
    void testNormalCase() {
        List<Integer> nums = Arrays.asList(0, 4, 2, 5, 0);
        assertEquals(9, solution.bigSum(nums),
            "Sum of two largest should be 5 + 4 = 9");
    }

    @Test
    @DisplayName("Should handle negative numbers")
    void testNegativeNumbers() {
        List<Integer> nums = Arrays.asList(-5, -2, -8, -1, -3);
        assertEquals(-3, solution.bigSum(nums),
            "Sum of two largest should be -1 + (-2) = -3");
    }

    @Test
    @DisplayName("Should handle mixed positive and negative")
    void testMixedNumbers() {
        List<Integer> nums = Arrays.asList(-5, 10, -2, 8, -1);
        assertEquals(18, solution.bigSum(nums),
            "Sum of two largest should be 10 + 8 = 18");
    }

    @Test
    @DisplayName("Should return 0 for null list")
    void testNullList() {
        assertEquals(0, solution.bigSum(null),
            "Should return 0 for null list");
    }

    @Test
    @DisplayName("Should return 0 for empty list")
    void testEmptyList() {
        List<Integer> nums = Collections.emptyList();
        assertEquals(0, solution.bigSum(nums),
            "Should return 0 for empty list");
    }

    @Test
    @DisplayName("Should return element for single-element list")
    void testSingleElement() {
        List<Integer> nums = Collections.singletonList(42);
        assertEquals(42, solution.bigSum(nums),
            "Should return the element itself for single-element list");
    }

    @Test
    @DisplayName("Should handle two-element list")
    void testTwoElements() {
        List<Integer> nums = Arrays.asList(3, 7);
        assertEquals(10, solution.bigSum(nums),
            "Sum should be 3 + 7 = 10");
    }

    @Test
    @DisplayName("Should handle all same values")
    void testAllSameValues() {
        List<Integer> nums = Arrays.asList(5, 5, 5, 5);
        assertEquals(10, solution.bigSum(nums),
            "Sum should be 5 + 5 = 10");
    }

    @Test
    @DisplayName("Should handle large numbers")
    void testLargeNumbers() {
        List<Integer> nums = Arrays.asList(1000000, 999999, 1, 2, 3);
        assertEquals(1999999, solution.bigSum(nums),
            "Sum should be 1000000 + 999999 = 1999999");
    }
}
