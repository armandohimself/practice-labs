package practice.uncheckedexception;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CauseUncheckedExceptionTest {
    static Lab cue;
    @BeforeAll
    public static void setUp(){
        cue = new Lab();
    }

    /**
     * Test case leverages a try/catch: the correct behavior of throwCustomException should cause the try block to
     * immediately stop due to the exception, and switch to executing the catch block.
     *
     * If either we run throwCustomException without causing an exception, or if an exception is thrown that is not
     * an instance of CustomException, the test will fail.
     */
    @Test
    public void uncheckedExceptionTest(){
        try{
            cue.throwUncheckedException();
            fail();
        }catch(Exception e){
            assertTrue(e instanceof RuntimeException);
        }
    }
}
