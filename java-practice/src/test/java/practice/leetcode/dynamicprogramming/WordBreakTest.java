package practice.leetcode.dynamicprogramming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {
    private WordBreak solution;
    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.dynamicprogramming", "WordBreak");
    }
    @Test
    void test1() { assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet","code"))); }
    @Test
    void test2() { assertFalse(solution.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); }
}
