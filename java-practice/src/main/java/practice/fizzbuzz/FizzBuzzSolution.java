package practice.fizzbuzz;

/**
 * Interface for FizzBuzz challenge implementations.
 * All attempts (FizzBuzz, FizzBuzz2, etc.) should implement this.
 */
public interface FizzBuzzSolution {
    /**
     * Return "Fizz" if n is divisible by 3, "Buzz" if divisible by 5, 
     * "FizzBuzz" if divisible by both, or empty string otherwise.
     *
     * @param n the number to check
     * @return "Fizz", "Buzz", "FizzBuzz", or ""
     */
    String FizzBuzzGen(int n);
}
