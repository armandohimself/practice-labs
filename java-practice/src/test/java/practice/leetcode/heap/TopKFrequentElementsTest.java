package practice.leetcode.heap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {
    private TopKFrequentElements solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.heap", "TopKFrequentElements"); }
    @Test
    void test() { assertNotNull(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2)); }
}
