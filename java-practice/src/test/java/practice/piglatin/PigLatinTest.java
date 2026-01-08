package practice.piglatin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

public class PigLatinTest {
    

    
    private PigLatinSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.piglatin", "PigLatin");
    }

/**
     * The pig latin form of "banana" is "ananabay".
     */
    @Test
    public void pigLatinTest1(){
        String input = "banana";
        String expected = "ananabay";
        String actual = solution.returnPigLatin(input);
        assertEquals(expected, actual);
    }

    /**
     * The pig latin form of "pear" is "earpay".
     */
    @Test
    public void pigLatinTest2(){
        String input = "pear";
        String expected = "earpay";
        String actual = solution.returnPigLatin(input);
        assertEquals(expected, actual);
    }

    /**
     * The pig latin form of "peach" is "eachpay".
     */
    @Test
    public void pigLatinTest3(){
        String input = "peach";
        String expected = "eachpay";
        String actual = solution.returnPigLatin(input);
        assertEquals(expected, actual);
    }
}
