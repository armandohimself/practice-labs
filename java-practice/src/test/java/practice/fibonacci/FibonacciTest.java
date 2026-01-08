package practice.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.BeforeClass;

public class FibonacciTest {
    
    private FibonacciSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.fibonacci", "Fibonacci");
    }

static 
    @BeforeClass
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
        assertEquals(fib.fib(input), expected);
    }
    /**
     * The 3rd number of the fibonacci sequence is 2.
     */
    @Test
    public void fibTest2(){
        int input = 3;
        int expected = 2;
        assertEquals(fib.fib(input), expected);
    }
    /**
     * The 6th number of the fibonacci sequence is 8.
     */
    @Test
    public void fibTest3(){
        int input = 6;
        int expected = 8;
        assertEquals(fib.fib(input), expected);
    }
}
