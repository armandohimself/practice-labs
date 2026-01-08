package practice.fibonacci;


public class Fibonacci {
    /**
     * Return the nth number of fibonacci sequence.
     * The fibonacci sequence is calculated by adding the previous two numbers in the sequence to obtain the next
     * number. The first two numbers in the whole fibonacci sequence are always 0 and 1.
     * For instance, the sequence starts as:
     * 0 1 1 2 3 5 8 13 21
     * where the 4th number of the sequence would be 3, the 5th number would be 5, the 6th number would be 8, etc.
     *
     * You could either use a for loop to keep track of the current number of the fibonacci sequence as well as the two
     * numbers before it, or you could look up a recursive solution to experiment with recursion for the first time.
     *
     * @param n an iteration of the fibonacci sequence.
     * @return the nth number of fibonacci sequence.
     */
    public int fib(int n){
        System.out.println("Position we are looking for is: " + n);

        int next = 0;
        int firstNum = 0;
        int secondNum = 1;

        // Guard clause for base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        for(int i = 2; i <= n; i++) {
            System.out.println("\n ITERATION " + i + " \n");

            System.out.println("First=" + firstNum + " + Second=" + secondNum);

            // 0 1 1 2 3 5 8 13 21
            // F S C
            // First iteration of 0 is 0 (first) + 1 (second) = 1 (current)
            next = firstNum + secondNum;
            // 0 1 1 2 3 5 8 13 21
            //   F S C
            System.out.println(next);

            firstNum = secondNum;
            secondNum = next;

            System.out.println("First= " + firstNum);
            System.out.println("Second = " + secondNum);
        }

        return next;
    }
}
