package practice.leetcode.binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {
    private MissingNumber solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.binary", "MissingNumber"); }
    @Test
    void test() { assertEquals(2, solution.missingNumber(new int[]{3,0,1})); }
}
