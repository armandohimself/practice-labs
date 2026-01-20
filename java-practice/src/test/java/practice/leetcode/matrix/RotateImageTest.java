package practice.leetcode.matrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {
    private RotateImage solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.matrix", "RotateImage"); }
    @Test
    void test() { int[][] m = {{1,2,3},{4,5,6},{7,8,9}}; solution.rotate(m); assertEquals(7, m[0][0]); }
}
