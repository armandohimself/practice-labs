package practice.leetcode.binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoIntegersTest {
    private SumOfTwoIntegers solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.binary", "SumOfTwoIntegers"); }
    @Test
    void test() { assertEquals(3, solution.getSum(1, 2)); }
}
