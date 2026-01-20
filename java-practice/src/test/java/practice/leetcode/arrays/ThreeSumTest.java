package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("3Sum Tests")
class ThreeSumTest {

    private ThreeSum solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "ThreeSum");
    }

    @Test
    @DisplayName("Example 1: [-1,0,1,2,-1,-4] should return [[-1,-1,2],[-1,0,1]]")
    void testExample1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-1, -1, 2),
            Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(2, result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    @DisplayName("Example 2: [0,1,1] should return []")
    void testExample2() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Example 3: [0,0,0] should return [[0,0,0]]")
    void testExample3() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(0, 0, 0)
        );
        assertEquals(expected, solution.threeSum(nums));
    }

    @Test
    @DisplayName("Array with less than 3 elements should return []")
    void testLessThanThreeElements() {
        int[] nums = {1, 2};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("No valid triplets should return []")
    void testNoValidTriplets() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }
}
