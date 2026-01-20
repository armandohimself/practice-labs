package practice.leetcode.graphs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {
    private CourseSchedule solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.graphs", "CourseSchedule"); }
    @Test
    void test() { assertTrue(solution.canFinish(2, new int[][]{{1,0}})); }
}
