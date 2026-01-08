package practice.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for FizzBuzz challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: FizzBuzz2.java, FizzBuzz3.java, etc.
 *
 * Override target with: PRACTICE_TARGET=FizzBuzz2 ./gradlew test
 */
@DisplayName("FizzBuzz Challenge Tests")
class FizzBuzzTest {

    private FizzBuzzSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        // Automatically resolve to the latest implementation
        solution = TargetResolver.resolve("practice.fizzbuzz", "FizzBuzz");
    }

    /**
     * Because 5 is divisible by 5 but not 3, return "Buzz".
     */
    @Test
    @DisplayName("5 should return 'Buzz'")
    public void FizzBuzzTest1() {
        int num = 5;
        String target = "Buzz";
        assertEquals(target, solution.FizzBuzzGen(num));
    }

    /**
     * Because 9 is divisible by 3 but not 5, return "Fizz".
     */
    @Test
    @DisplayName("9 should return 'Fizz'")
    public void FizzBuzzTest2() {
        int num = 9;
        String target = "Fizz";
        assertEquals(target, solution.FizzBuzzGen(num));
    }

    /**
     * Because 27 is divisible by 3 but not 5, return "Fizz".
     */
    @Test
    @DisplayName("27 should return 'Fizz'")
    public void FizzBuzzTest3() {
        int num = 27;
        String target = "Fizz";
        assertEquals(target, solution.FizzBuzzGen(num));
    }

    /**
     * Because 30 is divisible by both 5 and 3, return "FizzBuzz".
     */
    @Test
    @DisplayName("30 should return 'FizzBuzz'")
    public void FizzBuzzTest4() {
        int num = 30;
        String target = "FizzBuzz";
        assertEquals(target, solution.FizzBuzzGen(num));
    }

    /**
     * Because 28 is divisible by neither 5 nor 3, return "".
     */
    @Test
    @DisplayName("28 should return ''")
    public void FizzBuzzTest5() {
        int num = 28;
        String target = "";
        assertEquals(target, solution.FizzBuzzGen(num));
    }

    /**
     * Because 2 is divisible by neither 5 nor 3, return "".
     */
    @Test
    @DisplayName("2 should return ''")
    public void FizzBuzzTest6() {
        int num = 2;
        String target = "";
        assertEquals(target, solution.FizzBuzzGen(num));
    }
}
