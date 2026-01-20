package practice.leetcode.binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class ReverseBitsTest {
    private ReverseBits solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.binary", "ReverseBits"); }
    @Test
    void test() { assertEquals(964176192, solution.reverseBits(43261596)); }
}
