package practice.otherstringmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

public class OtherStringMethodsTest {
    
    private OtherStringMethodsSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.otherstringmethods", "OtherStringMethods");
    }

    /**
     * the substring of "banana", starting at 0 inclusive and ending at 3 exclusive, is "ban".
     */
    @Test
    public void partOfStringTest1(){
        assertEquals(solution.partOfString("banana", 0, 3), "ban");
    }
    /**
     * the substring of "apple", starting at 1 inclusive and ending at 5 exclusive, is "pple".
     */
    @Test
    public void partOfStringTest2(){
        assertEquals(solution.partOfString("apple", 1, 5), "pple");
    }

    /**
     * Banana is after apple in the dictionary, so compareTo should return a value greater than 0.
     */
    @Test
    public void compareToTest1(){
        assertTrue(solution.compareLexigraphically("banana", "apple") > 0);
    }

    /**
     * Monkey is before penguin in the dictionary, so compareTo should return a value less than 0.
     */
    @Test
    public void compareToTest2(){
        assertTrue(solution.compareLexigraphically("monkey", "penguin") < 0);
    }

    /**
     * java is equivalent to java, so compareTo should return 0.
     */
    @Test
    public void compareToTest3(){
        assertTrue(solution.compareLexigraphically("java", "java") == 0);
    }

    /**
     * "banana apple pear" split around " " should return {"banana", "apple", "pear"}.
     */
    @Test
    public void splitStringTest1(){
        String input = "banana apple pear";
        String splitAround = " ";
        String[] expected = {"banana", "apple", "pear"};
        assertArrayEquals(solution.splitStringIntoMultipleStrings(input, splitAround), expected);
    }

    /**
     * "src.main.java" split around "." should return {"src", "main", "java"}.
     * the two backwards slashes prevent the period from being interpreted as a regex expression.
     */
    @Test
    public void splitStringTest2(){
        String input = "src.main.java";
        String splitAround = "\\.";
        String[] expected = {"src", "main", "java"};
        assertArrayEquals(solution.splitStringIntoMultipleStrings(input, splitAround), expected);
    }
}
