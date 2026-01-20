package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Group Anagrams Tests")
class GroupAnagramsTest {

    private GroupAnagrams solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "GroupAnagrams");
    }

    @Test
    @DisplayName("Example 1: Group anagrams from mixed words")
    void testExample1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Example 2: Empty string should return [['']]")
    void testExample2() {
        String[] strs = {""};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
    }

    @Test
    @DisplayName("Example 3: Single character should return [['a']]")
    void testExample3() {
        String[] strs = {"a"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("a"), result.get(0));
    }

    @Test
    @DisplayName("All unique words should return n groups")
    void testAllUnique() {
        String[] strs = {"abc", "def", "ghi"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("All anagrams should return 1 group")
    void testAllAnagrams() {
        String[] strs = {"abc", "bca", "cab"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).size());
    }
}
