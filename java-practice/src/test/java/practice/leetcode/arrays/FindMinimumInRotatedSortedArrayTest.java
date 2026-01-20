package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Find Minimum in Rotated Sorted Array Tests")
class FindMinimumInRotatedSortedArrayTest {

    private FindMinimumInRotatedSortedArray solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "FindMinimumInRotatedSortedArray");
    }

    @Test
    @DisplayName("Example 1: [3,4,5,1,2] should return 1")
    void testExample1() {
        int[] nums = {3, 4, 5, 1, 2};
        assertEquals(1, solution.findMin(nums));
    }

    @Test
    @DisplayName("Example 2: [4,5,6,7,0,1,2] should return 0")
    void testExample2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, solution.findMin(nums));
    }

    @Test
    @DisplayName("Example 3: [11,13,15,17] should return 11")
    void testExample3() {
        int[] nums = {11, 13, 15, 17};
        assertEquals(11, solution.findMin(nums));
    }

    @Test
    @DisplayName("Single element [5] should return 5")
    void testSingleElement() {
        int[] nums = {5};
        assertEquals(5, solution.findMin(nums));
    }

    @Test
    @DisplayName("Two elements rotated [2,1] should return 1")
    void testTwoElementsRotated() {
        int[] nums = {2, 1};
        assertEquals(1, solution.findMin(nums));
    }

    @Test
    @DisplayName("Two elements not rotated [1,2] should return 1")
    void testTwoElementsNotRotated() {
        int[] nums = {1, 2};
        assertEquals(1, solution.findMin(nums));
    }
}
