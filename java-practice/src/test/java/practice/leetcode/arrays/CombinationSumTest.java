package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Combination Sum Tests")
class CombinationSumTest {

    private CombinationSum solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "CombinationSum");
    }

    @Test
    @DisplayName("Example 1: candidates=[2,3,6,7], target=7 should return [[2,2,3],[7]]")
    void testExample1() {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = solution.combinationSum(candidates, 7);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(2, 2, 3)));
        assertTrue(result.contains(Arrays.asList(7)));
    }

    @Test
    @DisplayName("Example 2: candidates=[2,3,5], target=8")
    void testExample2() {
        int[] candidates = {2, 3, 5};
        List<List<Integer>> result = solution.combinationSum(candidates, 8);
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Example 3: candidates=[2], target=1 should return []")
    void testExample3() {
        int[] candidates = {2};
        List<List<Integer>> result = solution.combinationSum(candidates, 1);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Single element matching target should return [[target]]")
    void testSingleElementMatch() {
        int[] candidates = {5};
        List<List<Integer>> result = solution.combinationSum(candidates, 5);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(5), result.get(0));
    }
}
