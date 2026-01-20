package practice.leetcode.binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class NumberOf1BitsTest {
    private NumberOf1Bits solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.binary", "NumberOf1Bits"); }
    @Test
    void test() { assertEquals(3, solution.hammingWeight(11)); }
}
