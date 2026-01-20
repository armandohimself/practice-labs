package practice.leetcode.intervals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalTest {
    private InsertInterval solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.intervals", "InsertInterval"); }
    @Test
    void test() { assertNotNull(solution.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})); }
}
