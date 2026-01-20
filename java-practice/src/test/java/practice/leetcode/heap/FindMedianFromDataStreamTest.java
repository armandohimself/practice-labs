package practice.leetcode.heap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class FindMedianFromDataStreamTest {
    private FindMedianFromDataStream solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.heap", "FindMedianFromDataStream"); }
    @Test
    void test() { solution.addNum(1); solution.addNum(2); assertEquals(1.5, solution.findMedian(), 0.01); }
}
