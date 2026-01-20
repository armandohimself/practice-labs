package practice.leetcode.binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class CountingBitsTest {
    private CountingBits solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.binary", "CountingBits"); }
    @Test
    void test() { assertArrayEquals(new int[]{0,1,1}, solution.countBits(2)); }
}
