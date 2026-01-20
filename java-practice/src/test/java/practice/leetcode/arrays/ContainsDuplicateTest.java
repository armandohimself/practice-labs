package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Contains Duplicate Tests")
class ContainsDuplicateTest {

    private ContainsDuplicate solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "ContainsDuplicate");
    }

    @Test
    @DisplayName("Example 1: [1,2,3,1] should return true")
    void testExample1() {
        int[] nums = {1, 2, 3, 1};
        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("Example 2: [1,2,3,4] should return false")
    void testExample2() {
        int[] nums = {1, 2, 3, 4};
        assertFalse(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("Example 3: [1,1,1,3,3,4,3,2,4,2] should return true")
    void testExample3() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("Single element should return false")
    void testSingleElement() {
        int[] nums = {1};
        assertFalse(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("Empty array should return false")
    void testEmptyArray() {
        int[] nums = {};
        assertFalse(solution.containsDuplicate(nums));
    }

    @Test
    @DisplayName("Two identical elements should return true")
    void testTwoIdentical() {
        int[] nums = {5, 5};
        assertTrue(solution.containsDuplicate(nums));
    }
}
