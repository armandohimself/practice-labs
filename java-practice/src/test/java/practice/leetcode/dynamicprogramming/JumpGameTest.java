package practice.leetcode.dynamicprogramming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {
    private JumpGame solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "JumpGame"); }
    @Test
    void test() { assertTrue(solution.canJump(new int[]{2,3,1,1,4})); }
}
