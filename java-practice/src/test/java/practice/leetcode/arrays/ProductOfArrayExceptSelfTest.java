package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Product of Array Except Self Tests")
class ProductOfArrayExceptSelfTest {

    private ProductOfArrayExceptSelf solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "ProductOfArrayExceptSelf");
    }

    @Test
    @DisplayName("Example 1: [1,2,3,4] should return [24,12,8,6]")
    void testExample1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    @DisplayName("Example 2: [-1,1,0,-3,3] should return [0,0,9,0,0]")
    void testExample2() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    @DisplayName("Two elements [1,2] should return [2,1]")
    void testTwoElements() {
        int[] nums = {1, 2};
        int[] expected = {2, 1};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    @DisplayName("All ones [1,1,1,1] should return [1,1,1,1]")
    void testAllOnes() {
        int[] nums = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    @DisplayName("With negative numbers [-1,-2,-3] should return [6,3,2]")
    void testNegativeNumbers() {
        int[] nums = {-1, -2, -3};
        int[] expected = {6, 3, 2};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }
}
