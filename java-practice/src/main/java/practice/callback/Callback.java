package practice.callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Callback Challenge
 *
 * Implement methods that use callbacks to process data. Callbacks are functions
 * passed as arguments to other functions, allowing for flexible and reusable code.
 *
 * This challenge demonstrates the callback pattern using Java functional interfaces.
 */
public class Callback {

    /**
     * Functional interface for processing integers
     */
    @FunctionalInterface
    public interface IntProcessor {
        int process(int value);
    }

    /**
     * Functional interface for filtering integers
     */
    @FunctionalInterface
    public interface IntFilter {
        boolean test(int value);
    }

    /**
     * Functional interface for consuming/handling results
     */
    @FunctionalInterface
    public interface ResultHandler {
        void handle(String message, int result);
    }

    /**
     * Applies a callback function to each element in the array and returns the modified array.
     *
     * Example:
     *   Input: numbers = [1, 2, 3], processor = (x -> x * 2)
     *   Output: [2, 4, 6]
     *
     * @param numbers the array of integers to process
     * @param processor the callback function to apply to each element
     * @return a new array with processed values
     */
    public int[] map(int[] numbers, IntProcessor processor) {
        // TODO: Implement map function using the callback
        return new int[0];
    }

    /**
     * Filters an array based on a callback predicate function.
     *
     * Example:
     *   Input: numbers = [1, 2, 3, 4, 5], filter = (x -> x % 2 == 0)
     *   Output: [2, 4]
     *
     * @param numbers the array of integers to filter
     * @param filter the callback function to test each element
     * @return a new array containing only elements that pass the filter
     */
    public int[] filter(int[] numbers, IntFilter filter) {
        // TODO: Implement filter function using the callback
        return new int[0];
    }

    /**
     * Performs a calculation and invokes a callback with the result.
     *
     * Example:
     *   Input: a = 5, b = 10, handler = (msg, res) -> System.out.println(msg + res)
     *   Action: Calls handler.handle("Sum is: ", 15)
     *
     * @param a first number
     * @param b second number
     * @param operation the operation name ("add", "multiply", "subtract")
     * @param handler callback to handle the result
     */
    public void calculate(int a, int b, String operation, ResultHandler handler) {
        // TODO: Implement calculate function that performs operation and calls handler
    }

    /**
     * Chains multiple processor callbacks together and applies them in sequence.
     *
     * Example:
     *   Input: value = 5, processors = [x -> x * 2, x -> x + 3, x -> x * x]
     *   Process: 5 * 2 = 10, 10 + 3 = 13, 13 * 13 = 169
     *   Output: 169
     *
     * @param value the initial value
     * @param processors array of callback functions to apply in order
     * @return the final processed value
     */
    public int chain(int value, IntProcessor[] processors) {
        // TODO: Implement function that chains callbacks
        return 0;
    }
}
