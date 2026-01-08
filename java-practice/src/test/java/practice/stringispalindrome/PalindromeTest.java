package practice.stringispalindrome;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PalindromeTest {
    public static Palindrome p;
    @BeforeAll
    public static void setUp(){
        p = new Palindrome();
    }

    /**
     * "abcba" is a palindrome, so return true.
     */
    @Test
    public void palindromeTest1(){
        String input = "abcba";
        boolean expected = true;
        assertEquals(expected, p.pal(input));
    }

    /**
     * "abcde" is not a palindrome, so return false.
     */
    @Test
    public void palindromeTest2(){
        String input = "abcde";
        boolean expected = false;
        assertEquals(expected, p.pal(input));
    }

    /**
     * "123454321" is a palindrome, so return true.
     */
    @Test
    public void palindromeTest3(){
        String input = "123454321";
        boolean expected = true;
        assertEquals(expected, p.pal(input));
    }
}
