package practice.leetcode.dynamicprogramming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {
    private DecodeWays solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "DecodeWays"); }
    @Test
    void test() { assertEquals(2, solution.numDecodings("12")); }
}
