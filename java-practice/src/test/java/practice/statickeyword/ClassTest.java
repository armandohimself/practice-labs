package practice.statickeyword;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClassTest
{
    Runner r = new Runner();

    /**
     * After running changeClassVar("xyz"), the value of global_var should be "xyz".
     */
    @Test
    public void classTest1(){
        Class.global_var="abc";
        r.changeClassVar("xyz");
        assertEquals(Class.global_var, "xyz");

    }
}
