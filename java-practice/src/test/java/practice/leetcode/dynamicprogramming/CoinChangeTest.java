package practice.leetcode.dynamicprogramming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {
    private CoinChange solution;
    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "CoinChange");
    }
    @Test
    void test1() { assertEquals(3, solution.coinChange(new int[]{1,2,5}, 11)); }
    @Test
    void test2() { assertEquals(-1, solution.coinChange(new int[]{2}, 3)); }
}
