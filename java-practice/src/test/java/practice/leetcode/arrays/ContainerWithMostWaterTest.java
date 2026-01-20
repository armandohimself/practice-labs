package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Container With Most Water Tests")
class ContainerWithMostWaterTest {

    private ContainerWithMostWater solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "ContainerWithMostWater");
    }

    @Test
    @DisplayName("Example 1: [1,8,6,2,5,4,8,3,7] should return 49")
    void testExample1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, solution.maxArea(height));
    }

    @Test
    @DisplayName("Example 2: [1,1] should return 1")
    void testExample2() {
        int[] height = {1, 1};
        assertEquals(1, solution.maxArea(height));
    }

    @Test
    @DisplayName("Two different heights [1,2] should return 1")
    void testTwoDifferentHeights() {
        int[] height = {1, 2};
        assertEquals(1, solution.maxArea(height));
    }

    @Test
    @DisplayName("Descending heights [9,8,7,6,5,4,3,2,1] should work")
    void testDescendingHeights() {
        int[] height = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(20, solution.maxArea(height));
    }

    @Test
    @DisplayName("All same heights [5,5,5,5] should return 15")
    void testAllSameHeights() {
        int[] height = {5, 5, 5, 5};
        assertEquals(15, solution.maxArea(height));
    }
}
