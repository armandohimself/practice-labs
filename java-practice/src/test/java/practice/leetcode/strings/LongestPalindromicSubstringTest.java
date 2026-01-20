package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Longest Palindromic Substring Tests")
class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "LongestPalindromicSubstring");
    }

    @Test
    @DisplayName("Example 1: 'babad' should return 'bab' or 'aba'")
    void testExample1() {
        String result = solution.longestPalindrome("babad");
        assertTrue(result.equals("bab") || result.equals("aba"));
    }

    @Test
    @DisplayName("Example 2: 'cbbd' should return 'bb'")
    void testExample2() {
        assertEquals("bb", solution.longestPalindrome("cbbd"));
    }

    @Test
    @DisplayName("Single character should return itself")
    void testSingleCharacter() {
        assertEquals("a", solution.longestPalindrome("a"));
    }

    @Test
    @DisplayName("All same characters should return entire string")
    void testAllSame() {
        assertEquals("aaaa", solution.longestPalindrome("aaaa"));
    }

    @Test
    @DisplayName("No palindrome longer than 1 should return any character")
    void testNoPalindrome() {
        String result = solution.longestPalindrome("abc");
        assertEquals(1, result.length());
    }
}
