package practice.evennumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for EvenNumbers challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: EvenNumbers2.java, EvenNumbers3.java, etc.
 *
 * Override target with: PRACTICE_TARGET=EvenNumbers2 ./gradlew test
 */
@DisplayName("EvenNumbers Challenge Tests")
class EvenNumbersTest {

    private EvenNumbers solution;

    @BeforeEach
    void setUp() throws Exception {
        // Automatically resolve to the latest implementation
        solution = TargetResolver.resolve("practice.evennumbers", "EvenNumbers");
    }

    @Test
    @DisplayName("TODO: Add test description")
    void testExample() {
        // TODO: Add your test cases here
        fail("Not implemented yet - add your test cases");
    }
}
