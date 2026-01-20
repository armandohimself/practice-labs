package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Valid Anagram Tests")
class ValidAnagramTest {

    private ValidAnagram solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "ValidAnagram");
    }

    @Test
    @DisplayName("Example 1: 'anagram' and 'nagaram' should return true")
    void testExample1() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    @DisplayName("Example 2: 'rat' and 'car' should return false")
    void testExample2() {
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    @DisplayName("Different lengths should return false")
    void testDifferentLengths() {
        assertFalse(solution.isAnagram("abc", "abcd"));
    }

    @Test
    @DisplayName("Empty strings should return true")
    void testEmptyStrings() {
        assertTrue(solution.isAnagram("", ""));
    }

    @Test
    @DisplayName("Same string should return true")
    void testSameString() {
        assertTrue(solution.isAnagram("hello", "hello"));
    }

    @Test
    @DisplayName("Single character anagram should work")
    void testSingleCharacter() {
        assertTrue(solution.isAnagram("a", "a"));
        assertFalse(solution.isAnagram("a", "b"));
    }
}
