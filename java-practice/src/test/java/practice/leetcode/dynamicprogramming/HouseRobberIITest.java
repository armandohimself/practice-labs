package practice.leetcode.dynamicprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("House Robber II Tests")
class HouseRobberIITest {
    private HouseRobberII solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "HouseRobberII");
    }

    @Test
    @DisplayName("Example 1: [2,3,2] should return 3")
    void testExample1() {
        assertEquals(3, solution.rob(new int[]{2, 3, 2}));
    }

    @Test
    @DisplayName("Example 2: [1,2,3,1] should return 4")
    void testExample2() {
        assertEquals(4, solution.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    @DisplayName("Single house [1] should return 1")
    void testSingleHouse() {
        assertEquals(1, solution.rob(new int[]{1}));
    }

    @Test
    @DisplayName("Two houses [1,2] should return 2")
    void testTwoHouses() {
        assertEquals(2, solution.rob(new int[]{1, 2}));
    }
}
