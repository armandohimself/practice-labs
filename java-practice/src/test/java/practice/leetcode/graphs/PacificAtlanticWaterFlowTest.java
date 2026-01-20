package practice.leetcode.graphs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class PacificAtlanticWaterFlowTest {
    private PacificAtlanticWaterFlow solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.graphs", "PacificAtlanticWaterFlow"); }
    @Test
    void test() { assertNotNull(solution.pacificAtlantic(new int[][]{{1,2},{2,1}})); }
}
