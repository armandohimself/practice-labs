package practice.leetcode.graphs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {
    private NumberOfIslands solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.graphs", "NumberOfIslands"); }
    @Test
    void test() { assertEquals(1, solution.numIslands(new char[][]{{'1','1'},{'1','1'}})); }
}
