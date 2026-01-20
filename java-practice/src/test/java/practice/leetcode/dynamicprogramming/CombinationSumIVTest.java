package practice.leetcode.dynamicprogramming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class CombinationSumIVTest {
    private CombinationSumIV solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "CombinationSumIV"); }
    @Test
    void test() { assertEquals(7, solution.combinationSum4(new int[]{1,2,3}, 4)); }
}
