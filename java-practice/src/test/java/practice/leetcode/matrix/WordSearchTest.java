package practice.leetcode.matrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {
    private WordSearch solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.matrix", "WordSearch"); }
    @Test
    void test() { assertTrue(solution.exist(new char[][]{{'A','B'},{'C','D'}}, "ABCD")); }
}
