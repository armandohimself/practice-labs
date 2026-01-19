package practice.callback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Callback challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: Callback2.java, Callback3.java, etc.
 *
 * Override target with: PRACTICE_TARGET=Callback2 ./gradlew test
 */
@DisplayName("Callback Challenge Tests")
class CallbackTest {

    private Callback solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.callback", "Callback");
    }

    // ========== MAP FUNCTION TESTS ==========

    @Test
    @DisplayName("Map: Double each number")
    void testMapDouble() {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] result = solution.map(numbers, x -> x * 2);
        assertArrayEquals(new int[]{2, 4, 6, 8, 10}, result, "Should double each number");
    }

    @Test
    @DisplayName("Map: Add 10 to each number")
    void testMapAddTen() {
        int[] numbers = {5, 10, 15};
        int[] result = solution.map(numbers, x -> x + 10);
        assertArrayEquals(new int[]{15, 20, 25}, result, "Should add 10 to each number");
    }

    @Test
    @DisplayName("Map: Square each number")
    void testMapSquare() {
        int[] numbers = {1, 2, 3, 4};
        int[] result = solution.map(numbers, x -> x * x);
        assertArrayEquals(new int[]{1, 4, 9, 16}, result, "Should square each number");
    }

    @Test
    @DisplayName("Map: Empty array")
    void testMapEmptyArray() {
        int[] numbers = {};
        int[] result = solution.map(numbers, x -> x * 2);
        assertArrayEquals(new int[]{}, result, "Should handle empty array");
    }

    @Test
    @DisplayName("Map: Negate each number")
    void testMapNegate() {
        int[] numbers = {1, -2, 3, -4};
        int[] result = solution.map(numbers, x -> -x);
        assertArrayEquals(new int[]{-1, 2, -3, 4}, result, "Should negate each number");
    }

    // ========== FILTER FUNCTION TESTS ==========

    @Test
    @DisplayName("Filter: Even numbers only")
    void testFilterEven() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] result = solution.filter(numbers, x -> x % 2 == 0);
        assertArrayEquals(new int[]{2, 4, 6}, result, "Should filter only even numbers");
    }

    @Test
    @DisplayName("Filter: Odd numbers only")
    void testFilterOdd() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] result = solution.filter(numbers, x -> x % 2 != 0);
        assertArrayEquals(new int[]{1, 3, 5}, result, "Should filter only odd numbers");
    }

    @Test
    @DisplayName("Filter: Numbers greater than 10")
    void testFilterGreaterThan() {
        int[] numbers = {5, 12, 8, 20, 3, 15};
        int[] result = solution.filter(numbers, x -> x > 10);
        assertArrayEquals(new int[]{12, 20, 15}, result, "Should filter numbers > 10");
    }

    @Test
    @DisplayName("Filter: No matches")
    void testFilterNoMatches() {
        int[] numbers = {1, 3, 5, 7};
        int[] result = solution.filter(numbers, x -> x > 100);
        assertArrayEquals(new int[]{}, result, "Should return empty array when no matches");
    }

    @Test
    @DisplayName("Filter: All matches")
    void testFilterAllMatch() {
        int[] numbers = {2, 4, 6, 8};
        int[] result = solution.filter(numbers, x -> x % 2 == 0);
        assertArrayEquals(new int[]{2, 4, 6, 8}, result, "Should return all elements when all match");
    }

    @Test
    @DisplayName("Filter: Positive numbers only")
    void testFilterPositive() {
        int[] numbers = {-5, 3, -2, 7, 0, -1, 4};
        int[] result = solution.filter(numbers, x -> x > 0);
        assertArrayEquals(new int[]{3, 7, 4}, result, "Should filter only positive numbers");
    }

    // ========== CALCULATE FUNCTION TESTS ==========

    @Test
    @DisplayName("Calculate: Addition with callback")
    void testCalculateAdd() {
        List<String> results = new ArrayList<>();
        solution.calculate(5, 10, "add", (msg, res) -> results.add(msg + res));

        assertFalse(results.isEmpty(), "Handler should be called");
        assertTrue(results.get(0).contains("15"), "Should calculate 5 + 10 = 15");
    }

    @Test
    @DisplayName("Calculate: Multiplication with callback")
    void testCalculateMultiply() {
        List<Integer> results = new ArrayList<>();
        solution.calculate(6, 7, "multiply", (msg, res) -> results.add(res));

        assertFalse(results.isEmpty(), "Handler should be called");
        assertEquals(42, results.get(0), "Should calculate 6 * 7 = 42");
    }

    @Test
    @DisplayName("Calculate: Subtraction with callback")
    void testCalculateSubtract() {
        List<Integer> results = new ArrayList<>();
        solution.calculate(20, 8, "subtract", (msg, res) -> results.add(res));

        assertFalse(results.isEmpty(), "Handler should be called");
        assertEquals(12, results.get(0), "Should calculate 20 - 8 = 12");
    }

    @Test
    @DisplayName("Calculate: Handler receives both message and result")
    void testCalculateMessageAndResult() {
        List<String> messages = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        solution.calculate(3, 4, "add", (msg, res) -> {
            messages.add(msg);
            values.add(res);
        });

        assertFalse(messages.isEmpty(), "Should receive message");
        assertFalse(values.isEmpty(), "Should receive result");
        assertEquals(7, values.get(0), "Result should be 7");
    }

    // ========== CHAIN FUNCTION TESTS ==========

    @Test
    @DisplayName("Chain: Multiple operations in sequence")
    void testChainMultipleOps() {
        Callback.IntProcessor[] processors = {
            x -> x * 2,      // 5 * 2 = 10
            x -> x + 3,      // 10 + 3 = 13
            x -> x * x       // 13 * 13 = 169
        };
        int result = solution.chain(5, processors);
        assertEquals(169, result, "Should chain: (5 * 2 + 3)^2 = 169");
    }

    @Test
    @DisplayName("Chain: Single processor")
    void testChainSingleProcessor() {
        Callback.IntProcessor[] processors = {x -> x * 10};
        int result = solution.chain(7, processors);
        assertEquals(70, result, "Should apply single processor: 7 * 10 = 70");
    }

    @Test
    @DisplayName("Chain: Empty processors array")
    void testChainEmptyProcessors() {
        Callback.IntProcessor[] processors = {};
        int result = solution.chain(42, processors);
        assertEquals(42, result, "Should return original value with no processors");
    }

    @Test
    @DisplayName("Chain: Complex sequence")
    void testChainComplexSequence() {
        Callback.IntProcessor[] processors = {
            x -> x + 5,      // 10 + 5 = 15
            x -> x * 2,      // 15 * 2 = 30
            x -> x - 10,     // 30 - 10 = 20
            x -> x / 4       // 20 / 4 = 5
        };
        int result = solution.chain(10, processors);
        assertEquals(5, result, "Should chain: ((10 + 5) * 2 - 10) / 4 = 5");
    }

    @Test
    @DisplayName("Chain: Identity transformations")
    void testChainIdentity() {
        Callback.IntProcessor[] processors = {
            x -> x,
            x -> x + 0,
            x -> x * 1
        };
        int result = solution.chain(100, processors);
        assertEquals(100, result, "Identity operations should return original value");
    }

    // ========== INTEGRATION TESTS ==========

    @Test
    @DisplayName("Integration: Map then filter")
    void testMapThenFilter() {
        int[] numbers = {1, 2, 3, 4, 5};

        // First map: double each number -> [2, 4, 6, 8, 10]
        int[] mapped = solution.map(numbers, x -> x * 2);

        // Then filter: only numbers > 5 -> [6, 8, 10]
        int[] filtered = solution.filter(mapped, x -> x > 5);

        assertArrayEquals(new int[]{6, 8, 10}, filtered, "Should map then filter correctly");
    }

    @Test
    @DisplayName("Integration: Combine map with chain")
    void testMapWithChain() {
        int[] numbers = {2, 3, 4};

        // Map using chain of operations
        int[] result = solution.map(numbers, x -> {
            Callback.IntProcessor[] processors = {
                val -> val * 2,
                val -> val + 1
            };
            return solution.chain(x, processors);
        });

        assertArrayEquals(new int[]{5, 7, 9}, result, "Should combine map with chain: (2*2+1)=5, (3*2+1)=7, (4*2+1)=9");
    }
}
