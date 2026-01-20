package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Search in Rotated Sorted Array Tests")
class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "SearchInRotatedSortedArray");
    }

    @Test
    @DisplayName("Example 1: [4,5,6,7,0,1,2], target=0 should return 4")
    void testExample1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(4, solution.search(nums, 0));
    }

    @Test
    @DisplayName("Example 2: [4,5,6,7,0,1,2], target=3 should return -1")
    void testExample2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(-1, solution.search(nums, 3));
    }

    @Test
    @DisplayName("Example 3: [1], target=0 should return -1")
    void testExample3() {
        int[] nums = {1};
        assertEquals(-1, solution.search(nums, 0));
    }

    @Test
    @DisplayName("Single element found: [1], target=1 should return 0")
    void testSingleElementFound() {
        int[] nums = {1};
        assertEquals(0, solution.search(nums, 1));
    }

    @Test
    @DisplayName("Not rotated: [1,2,3,4,5], target=3 should return 2")
    void testNotRotated() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(2, solution.search(nums, 3));
    }

    @Test
    @DisplayName("Target at pivot: [4,5,6,7,0,1,2], target=4 should return 0")
    void testTargetAtPivot() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, solution.search(nums, 4));
    }
}
