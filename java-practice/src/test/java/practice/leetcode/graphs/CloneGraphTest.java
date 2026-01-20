package practice.leetcode.graphs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {
    private CloneGraph solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.graphs", "CloneGraph"); }
    @Test
    void test() { assertNull(solution.cloneGraph(null)); }
}
