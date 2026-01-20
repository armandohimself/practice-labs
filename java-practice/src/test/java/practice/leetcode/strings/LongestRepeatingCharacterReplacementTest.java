package practice.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Longest Repeating Character Replacement Tests")
class LongestRepeatingCharacterReplacementTest {

    private LongestRepeatingCharacterReplacement solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.strings", "LongestRepeatingCharacterReplacement");
    }

    @Test
    @DisplayName("Example 1: s='ABAB', k=2 should return 4")
    void testExample1() {
        assertEquals(4, solution.characterReplacement("ABAB", 2));
    }

    @Test
    @DisplayName("Example 2: s='AABABBA', k=1 should return 4")
    void testExample2() {
        assertEquals(4, solution.characterReplacement("AABABBA", 1));
    }

    @Test
    @DisplayName("All same characters should return length")
    void testAllSame() {
        assertEquals(5, solution.characterReplacement("AAAAA", 0));
    }

    @Test
    @DisplayName("k=0 should find longest consecutive sequence")
    void testKZero() {
        assertEquals(2, solution.characterReplacement("AABBCC", 0));
    }

    @Test
    @DisplayName("Single character should return 1")
    void testSingleCharacter() {
        assertEquals(1, solution.characterReplacement("A", 0));
    }
}
