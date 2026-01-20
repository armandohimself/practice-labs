package practice.leetcode.dynamicprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("House Robber Tests")
class HouseRobberTest {
    private HouseRobber solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "HouseRobber");
    }

    @Test
    @DisplayName("Example 1: [1,2,3,1] should return 4")
    void testExample1() {
        assertEquals(4, solution.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    @DisplayName("Example 2: [2,7,9,3,1] should return 12")
    void testExample2() {
        assertEquals(12, solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    @DisplayName("Single house [5] should return 5")
    void testSingleHouse() {
        assertEquals(5, solution.rob(new int[]{5}));
    }

    @Test
    @DisplayName("Two houses [2,1] should return 2")
    void testTwoHouses() {
        assertEquals(2, solution.rob(new int[]{2, 1}));
    }
}
