package practice.leetcode.intervals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {
    private MergeIntervals solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.intervals", "MergeIntervals"); }
    @Test
    void test() { assertNotNull(solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})); }
}
