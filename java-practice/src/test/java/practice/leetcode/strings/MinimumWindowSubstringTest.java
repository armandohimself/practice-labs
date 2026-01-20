package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Minimum Window Substring Tests")
class MinimumWindowSubstringTest {

    private MinimumWindowSubstring solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "MinimumWindowSubstring");
    }

    @Test
    @DisplayName("Example 1: s='ADOBECODEBANC', t='ABC' should return 'BANC'")
    void testExample1() {
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    @DisplayName("Example 2: s='a', t='a' should return 'a'")
    void testExample2() {
        assertEquals("a", solution.minWindow("a", "a"));
    }

    @Test
    @DisplayName("Example 3: s='a', t='aa' should return ''")
    void testExample3() {
        assertEquals("", solution.minWindow("a", "aa"));
    }

    @Test
    @DisplayName("No valid window should return empty string")
    void testNoValidWindow() {
        assertEquals("", solution.minWindow("abc", "d"));
    }

    @Test
    @DisplayName("Entire string is minimum window")
    void testEntireString() {
        assertEquals("abc", solution.minWindow("abc", "abc"));
    }
}
