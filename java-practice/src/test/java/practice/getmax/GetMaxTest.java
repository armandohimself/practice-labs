package practice.getmax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for GetMax challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: GetMax2.java, GetMax3.java, etc.
 */
@DisplayName("GetMax Challenge Tests")
class GetMaxTest {

    private GetMaxSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.getmax", "GetMax");
    }

    /**
     * The largest value of {0,1,2,3,4} should be 4.
     */
    @Test
    @DisplayName("Max of {0,1,2,3,4} should be 4")
    public void getMaxTest1() {
        int[] input = {0, 1, 2, 3, 4};
        int expected = 4;
        assertEquals(expected, solution.max(input));
    }

    /**
     * The largest value of {9,8,10,3,4} should be 10.
     */
    @Test
    @DisplayName("Max of {9,8,10,3,4} should be 10")
    public void getMaxTest2() {
        int[] input = {9, 8, 10, 3, 4};
        int expected = 10;
        assertEquals(expected, solution.max(input));
    }

    /**
     * The largest value of {-100, -383, -45, -901, -76} should be -45.
     */
    @Test
    @DisplayName("Max of {-100,-383,-45,-901,-76} should be -45")
    public void getMaxTest3() {
        int[] input = {-100, -383, -45, -901, -76};
        int expected = -45;
        assertEquals(expected, solution.max(input));
    }
}
