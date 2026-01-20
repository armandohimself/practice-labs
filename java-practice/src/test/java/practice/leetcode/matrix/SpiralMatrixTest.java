package practice.leetcode.matrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixTest {
    private SpiralMatrix solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.matrix", "SpiralMatrix"); }
    @Test
    void test() { assertNotNull(solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})); }
}
