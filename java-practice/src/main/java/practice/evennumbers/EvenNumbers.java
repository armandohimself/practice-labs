package practice.evennumbers;

/**
 * EvenNumbers Challenge
 *
 * Find the number of even values in the array that are present before the first occurrence of X.
 *
 * Example:
 *   Input: A = [1, 4, 2, 6, 3], N = 5, X = 6
 *   Output: 2 (numbers 4 and 2 are even and come before 6)
 */
public class EvenNumbers {

    /**
     * Counts the number of even values in the array before the first occurrence of X.
     *
     * @param A the array of integers
     * @param N the size of the array
     * @param X the value to find (always present in the array)
     * @return the count of even numbers before the first occurrence of X
     */
    public int evenNumbers(int[] A, int N, int X) {

        //! Implement your solution below
        int count = 0;

        for (int a: A) {
            System.out.println("Current number: " + a + " Current X: " + X);

            // Guard rails - assume first index has stop value
            if (a == X) {
                break;
            }

            // Otherwise find the even number
            if (a % 2 == 0) {
                // Then increment the frequency counter
                count++;
            }
        }

        return count;
    }
}
