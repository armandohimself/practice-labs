package practice.evenorodd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for EvenOrOdd challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: EvenOrOdd2.java, EvenOrOdd3.java, etc.
 */
@DisplayName("EvenOrOdd Challenge Tests")
class EvenOrOddTest {

    private EvenOrOddSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.evenorodd", "EvenOrOdd");
    }

    /**
     * Because 4 is even, decide(4) should return "Even".
     */
    @Test
    @DisplayName("4 should return 'Even'")
    public void evenTest1() {
        assertEquals("Even", solution.decide(4));
    }

    /**
     * Because 0 is even, decide(0) should return "Even".
     */
    @Test
    @DisplayName("0 should return 'Even'")
    public void evenTest2() {
        assertEquals("Even", solution.decide(0));
    }

    /**
     * Because 12 is even, decide(12) should return "Even".
     */
    @Test
    @DisplayName("12 should return 'Even'")
    public void evenTest3() {
        assertEquals("Even", solution.decide(12));
    }

    /**
     * Because 3 is odd, decide(3) should return "Odd".
     */
    @Test
    @DisplayName("3 should return 'Odd'")
    public void oddTest1() {
        assertEquals("Odd", solution.decide(3));
    }

    /**
     * Because -5 is odd, decide(-5) should return "Odd".
     */
    @Test
    @DisplayName("-5 should return 'Odd'")
    public void oddTest2() {
        assertEquals("Odd", solution.decide(-5));
    }
}
