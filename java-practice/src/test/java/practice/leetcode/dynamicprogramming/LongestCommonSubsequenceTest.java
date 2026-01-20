package practice.leetcode.dynamicprogramming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence solution;
    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "LongestCommonSubsequence");
    }
    @Test
    void test1() { assertEquals(3, solution.longestCommonSubsequence("abcde", "ace")); }
    @Test
    void test2() { assertEquals(3, solution.longestCommonSubsequence("abc", "abc")); }
}
