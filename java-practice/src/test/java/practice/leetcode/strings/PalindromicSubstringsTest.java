package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Palindromic Substrings Tests")
class PalindromicSubstringsTest {

    private PalindromicSubstrings solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "PalindromicSubstrings");
    }

    @Test
    @DisplayName("Example 1: 'abc' should return 3")
    void testExample1() {
        assertEquals(3, solution.countSubstrings("abc"));
    }

    @Test
    @DisplayName("Example 2: 'aaa' should return 6")
    void testExample2() {
        assertEquals(6, solution.countSubstrings("aaa"));
    }

    @Test
    @DisplayName("Single character should return 1")
    void testSingleCharacter() {
        assertEquals(1, solution.countSubstrings("a"));
    }

    @Test
    @DisplayName("Two same characters should return 3")
    void testTwoSame() {
        assertEquals(3, solution.countSubstrings("aa"));
    }

    @Test
    @DisplayName("'aba' should return 4")
    void testAba() {
        assertEquals(4, solution.countSubstrings("aba"));
    }
}
