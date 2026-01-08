package practice.casting;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CastingPrimitiveTest {
    CastingPrimitive cp = new CastingPrimitive();

    /**
     * 4.3 casted to an int should become 4.
     */
    @Test
    public void castTest1(){
        double input = 4.3;
        int expected = 4;
        int actual = cp.castToInt(input);
        assertEquals(actual, expected);
    }

    /**
     * 9.999 casted to an int should become 9.
     */
    @Test
    public void castTest2(){
        double input = 9.999;
        int expected = 9;
        int actual = cp.castToInt(input);
        assertEquals(actual, expected);
    }
}
