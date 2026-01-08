package practice.helloworld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for HelloWorld challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: HelloWorld2.java, HelloWorld3.java, etc.
 *
 * Override target with: PRACTICE_TARGET=HelloWorld2 ./gradlew test
 */
@DisplayName("HelloWorld Challenge Tests")
class HelloWorldTest {

    private HelloWorldSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        // Automatically resolve to the latest implementation
        solution = TargetResolver.resolve("practice.helloworld", "HelloWorld");
    }

    @Test
    @DisplayName("Method sayHello() must return 'Hello, world!'")
    public void helloTest() {
        String expected = "Hello, world!";
        String actual = solution.sayHello().trim();
        assertEquals(expected, actual);
    }
}
