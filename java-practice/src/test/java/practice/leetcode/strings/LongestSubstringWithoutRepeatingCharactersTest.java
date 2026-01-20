package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Longest Substring Without Repeating Characters Tests")
class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "LongestSubstringWithoutRepeatingCharacters");
    }

    @Test
    @DisplayName("Example 1: 'abcabcbb' should return 3")
    void testExample1() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    @DisplayName("Example 2: 'bbbbb' should return 1")
    void testExample2() {
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    @DisplayName("Example 3: 'pwwkew' should return 3")
    void testExample3() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    @DisplayName("Empty string should return 0")
    void testEmptyString() {
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }

    @Test
    @DisplayName("Single character should return 1")
    void testSingleCharacter() {
        assertEquals(1, solution.lengthOfLongestSubstring("a"));
    }

    @Test
    @DisplayName("All unique characters should return length")
    void testAllUnique() {
        assertEquals(5, solution.lengthOfLongestSubstring("abcde"));
    }
}
