package practice.leetcode.intervals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingIntervalsTest {
    private NonOverlappingIntervals solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.intervals", "NonOverlappingIntervals"); }
    @Test
    void test() { assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}})); }
}
