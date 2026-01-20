package practice.leetcode.matrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class SetMatrixZeroesTest {
    private SetMatrixZeroes solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.matrix", "SetMatrixZeroes"); }
    @Test
    void test() { int[][] m = {{1,1,1},{1,0,1},{1,1,1}}; solution.setZeroes(m); assertEquals(0, m[1][0]); }
}
