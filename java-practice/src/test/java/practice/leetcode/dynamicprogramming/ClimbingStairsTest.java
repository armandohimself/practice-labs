package practice.leetcode.dynamicprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Climbing Stairs Tests")
class ClimbingStairsTest {
    private ClimbingStairs solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "ClimbingStairs");
    }

    @Test
    @DisplayName("Example 1: n=2 should return 2")
    void testExample1() {
        assertEquals(2, solution.climbStairs(2));
    }

    @Test
    @DisplayName("Example 2: n=3 should return 3")
    void testExample2() {
        assertEquals(3, solution.climbStairs(3));
    }

    @Test
    @DisplayName("n=1 should return 1")
    void testOne() {
        assertEquals(1, solution.climbStairs(1));
    }

    @Test
    @DisplayName("n=5 should return 8")
    void testFive() {
        assertEquals(8, solution.climbStairs(5));
    }
}
