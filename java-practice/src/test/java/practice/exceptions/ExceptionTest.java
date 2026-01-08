package practice.exceptions;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    static Lab ec;
    @BeforeAll
    public static void setUp(){
        ec = new Lab();
    }

    /**
     * This test verifies that ec.mustThrow() throws an exception.
     */
    @Test
    public void exceptionMustThrowTest(){
        assertThrows(Exception.class, ()->ec.mustThrow());
    }
}
