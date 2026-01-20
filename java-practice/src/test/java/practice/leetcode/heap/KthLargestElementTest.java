package practice.leetcode.heap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementTest {
    private KthLargestElement solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.heap", "KthLargestElement"); }
    @Test
    void test() { assertEquals(5, solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2)); }
}
