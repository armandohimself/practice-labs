package practice.leetcode.graphs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class GraphValidTreeTest {
    private GraphValidTree solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.graphs", "GraphValidTree"); }
    @Test
    void test() { assertTrue(solution.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}})); }
}
