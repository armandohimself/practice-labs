package practice.evennumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for EvenNumbers challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: EvenNumbers2.java, EvenNumbers3.java, etc.
 *
 * Override target with: PRACTICE_TARGET=EvenNumbers2 ./gradlew test
 */
@DisplayName("EvenNumbers Challenge Tests")
class EvenNumbersTest {

    private EvenNumbers solution;

    @BeforeEach
    void setUp() throws Exception {
        // Automatically resolve to the latest implementation
        solution = TargetResolver.resolve("practice.evennumbers", "EvenNumbers");
    }

    @Test
    @DisplayName("Sample Test Case 1: Basic case with even numbers before X")
    void testSampleCase1() {
        int[] A = {1, 4, 2, 6, 3};
        int result = solution.evenNumbers(A, 5, 6);
        assertEquals(2, result, "Should find 2 even numbers (4, 2) before X=6");
    }

    @Test
    @DisplayName("Sample Test Case 2: Multiple even numbers before X")
    void testSampleCase2() {
        int[] A = {2, 4, 6, 10, 8, 10, 12, 14};
        int result = solution.evenNumbers(A, 8, 10);
        assertEquals(3, result, "Should find 3 even numbers (2, 4, 6) before first occurrence of X=10");
    }

    @Test
    @DisplayName("Sample Test Case 3: No even numbers before X")
    void testSampleCase3() {
        int[] A = {3, 5, 7, 9, 2, 4, 6, 8};
        int result = solution.evenNumbers(A, 8, 2);
        assertEquals(0, result, "Should find 0 even numbers before X=2");
    }

    @Test
    @DisplayName("Edge Case: X is the first element")
    void testXIsFirstElement() {
        int[] A = {5, 2, 4, 6, 8};
        int result = solution.evenNumbers(A, 5, 5);
        assertEquals(0, result, "Should return 0 when X is the first element");
    }

    @Test
    @DisplayName("Edge Case: X is the last element")
    void testXIsLastElement() {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int result = solution.evenNumbers(A, 7, 7);
        assertEquals(3, result, "Should count all even numbers (2, 4, 6) when X is the last element");
    }

    @Test
    @DisplayName("Edge Case: All odd numbers before X")
    void testAllOddBeforeX() {
        int[] A = {1, 3, 5, 7, 10, 2, 4};
        int result = solution.evenNumbers(A, 7, 10);
        assertEquals(0, result, "Should return 0 when all numbers before X are odd");
    }

    @Test
    @DisplayName("Edge Case: All even numbers before X")
    void testAllEvenBeforeX() {
        int[] A = {2, 4, 6, 8, 5, 1, 3};
        int result = solution.evenNumbers(A, 7, 5);
        assertEquals(4, result, "Should count all 4 even numbers before X");
    }

    @Test
    @DisplayName("Edge Case: Single element array")
    void testSingleElement() {
        int[] A = {7};
        int result = solution.evenNumbers(A, 1, 7);
        assertEquals(0, result, "Should return 0 for single element array where element is X");
    }

    @Test
    @DisplayName("Edge Case: Two elements, X is second")
    void testTwoElementsXSecond() {
        int[] A = {4, 5};
        int result = solution.evenNumbers(A, 2, 5);
        assertEquals(1, result, "Should count 1 even number before X");
    }

    @Test
    @DisplayName("Edge Case: Large array with many even numbers")
    void testLargeArray() {
        int[] A = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 1, 3, 5};
        int result = solution.evenNumbers(A, 13, 1);
        assertEquals(10, result, "Should count all 10 even numbers before X=1");
    }

    @Test
    @DisplayName("Edge Case: X appears multiple times")
    void testXMultipleOccurrences() {
        int[] A = {2, 5, 4, 5, 6, 5, 8};
        int result = solution.evenNumbers(A, 7, 5);
        assertEquals(1, result, "Should stop at first occurrence of X and count only 1 even number (2)");
    }
}
