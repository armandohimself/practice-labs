package practice.leetcode.graphs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {
    private LongestConsecutiveSequence solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.graphs", "LongestConsecutiveSequence"); }
    @Test
    void test() { assertEquals(4, solution.longestConsecutive(new int[]{100,4,200,1,3,2})); }
}
