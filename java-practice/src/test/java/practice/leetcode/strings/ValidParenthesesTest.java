package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Valid Parentheses Tests")
class ValidParenthesesTest {

    private ValidParentheses solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "ValidParentheses");
    }

    @Test
    @DisplayName("Example 1: '()' should return true")
    void testExample1() {
        assertTrue(solution.isValid("()"));
    }

    @Test
    @DisplayName("Example 2: '()[]{}' should return true")
    void testExample2() {
        assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    @DisplayName("Example 3: '(]' should return false")
    void testExample3() {
        assertFalse(solution.isValid("(]"));
    }

    @Test
    @DisplayName("Nested parentheses should work")
    void testNested() {
        assertTrue(solution.isValid("{[()]}"));
    }

    @Test
    @DisplayName("Mismatched should return false")
    void testMismatched() {
        assertFalse(solution.isValid("([)]"));
    }

    @Test
    @DisplayName("Only opening brackets should return false")
    void testOnlyOpening() {
        assertFalse(solution.isValid("((("));
    }

    @Test
    @DisplayName("Only closing brackets should return false")
    void testOnlyClosing() {
        assertFalse(solution.isValid(")))"));
    }

    @Test
    @DisplayName("Empty string should return true")
    void testEmpty() {
        assertTrue(solution.isValid(""));
    }
}
