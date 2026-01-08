package practice.fibonacci;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    static Fibonacci fib;
    @BeforeAll
    public static void setUp(){
        fib = new Fibonacci();
    }

    /**
     * The 1st number of the fibonacci sequence is 1.
     */
    @Test
    public void fibTest1(){
        int input = 1;
        int expected = 1;
        assertEquals(expected, fib.fib(input));
    }
    /**
     * The 3rd number of the fibonacci sequence is 2.
     */
    @Test
    public void fibTest2(){
        int input = 3;
        int expected = 2;
        assertEquals(expected, fib.fib(input));
    }
    /**
     * The 6th number of the fibonacci sequence is 8.
     */
    @Test
    public void fibTest3(){
        int input = 6;
        int expected = 8;
        assertEquals(expected, fib.fib(input));
    }
}
