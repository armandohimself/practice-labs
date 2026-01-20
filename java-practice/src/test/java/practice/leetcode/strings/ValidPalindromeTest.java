package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Valid Palindrome Tests")
class ValidPalindromeTest {

    private ValidPalindrome solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "ValidPalindrome");
    }

    @Test
    @DisplayName("Example 1: 'A man, a plan, a canal: Panama' should return true")
    void testExample1() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    @DisplayName("Example 2: 'race a car' should return false")
    void testExample2() {
        assertFalse(solution.isPalindrome("race a car"));
    }

    @Test
    @DisplayName("Example 3: ' ' should return true")
    void testExample3() {
        assertTrue(solution.isPalindrome(" "));
    }

    @Test
    @DisplayName("Empty string should return true")
    void testEmpty() {
        assertTrue(solution.isPalindrome(""));
    }

    @Test
    @DisplayName("Simple palindrome 'aba' should return true")
    void testSimplePalindrome() {
        assertTrue(solution.isPalindrome("aba"));
    }

    @Test
    @DisplayName("Non-palindrome 'abc' should return false")
    void testNonPalindrome() {
        assertFalse(solution.isPalindrome("abc"));
    }

    @Test
    @DisplayName("With numbers '0P' should return false")
    void testWithNumbers() {
        assertFalse(solution.isPalindrome("0P"));
    }
}
