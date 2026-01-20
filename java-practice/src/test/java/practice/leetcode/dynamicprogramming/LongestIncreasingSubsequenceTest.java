package practice.leetcode.dynamicprogramming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Longest Increasing Subsequence Tests")
class LongestIncreasingSubsequenceTest {
    private LongestIncreasingSubsequence solution;
    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "LongestIncreasingSubsequence");
    }
    @Test
    void test1() { assertEquals(4, solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); }
    @Test
    void test2() { assertEquals(4, solution.lengthOfLIS(new int[]{0,1,0,3,2,3})); }
}
