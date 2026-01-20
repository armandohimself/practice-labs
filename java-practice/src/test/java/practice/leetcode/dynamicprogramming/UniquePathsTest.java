package practice.leetcode.dynamicprogramming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {
    private UniquePaths solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "UniquePaths"); }
    @Test
    void test() { assertEquals(28, solution.uniquePaths(3, 7)); }
}
