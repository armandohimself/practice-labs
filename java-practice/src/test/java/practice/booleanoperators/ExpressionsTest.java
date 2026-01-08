package practice.booleanoperators;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExpressionsTest {
    static Lab e;
    @BeforeAll
    public static void setUp(){
        e = new Lab();
    }

    /**
     * If input is true, then returnBoolean(input) should return true.
     */
    @Test
    public void returnBooleanTest1(){
        boolean input = true;
        boolean actual = e.returnBoolean(input);
        assertTrue(actual);
    }

    /**
     * If input is false, then returnBoolean(input) should return false.
     */
    @Test
    public void returnBooleanTest2(){
        boolean input = false;
        boolean actual = e.returnBoolean(input);
        assertFalse(actual);
    }

    /**
     * If input is true, then returnNot(input) should return false.
     */
    @Test
    public void returnNotTest1(){
        boolean input = true;
        boolean actual = e.returnNot(input);
        assertFalse(actual);
    }
    /**
     * If input is false, then returnNot(input) should return true.
     */
    @Test
    public void returnNotTest2(){
        boolean input = false;
        boolean actual = e.returnNot(input);
        assertTrue(actual);
    }
    /**
     * If input1 is true and input2 is true, then returnAnd(input1, input2) should return true.
     */
    @Test
    public void returnAndTest1(){
        boolean input1 = true;
        boolean input2 = true;
        boolean expected = true;
        boolean actual = e.returnAnd(input1, input2);
        assertEquals(actual, expected);
    }
    /**
     * If input1 is false and input2 is true, then returnAnd(input1, input2) should return false.
     */
    @Test
    public void returnAndTest2(){
        boolean input1 = false;
        boolean input2 = true;
        boolean expected = false;
        boolean actual = e.returnAnd(input1, input2);
        assertEquals(actual, expected);
    }
    /**
     * If input1 is false and input2 is false, then returnAnd(input1, input2) should return false.
     */
    @Test
    public void returnAndTest3(){
        boolean input1 = false;
        boolean input2 = false;
        boolean expected = false;
        boolean actual = e.returnAnd(input1, input2);
        assertEquals(actual, expected);
    }
    /**
     * If input1 is false and input2 is true, then returnAnd(input1, input2) should return false.
     */
    @Test
    public void returnAndTest4(){
        boolean input1 = false;
        boolean input2 = true;
        boolean expected = false;
        boolean actual = e.returnAnd(input1, input2);
        assertEquals(actual, expected);
    }
    /**
     * If input1 is true and input2 is true, then returnOr(input1, input2) should return true.
     */
    @Test
    public void returnOrTest1(){
        boolean input1 = true;
        boolean input2 = true;
        boolean expected = true;
        boolean actual = e.returnOr(input1, input2);
        assertEquals(actual, expected);
    }
    /**
     * If input1 is true and input2 is false, then returnOr(input1, input2) should return true.
     */
    @Test
    public void returnOrTest2(){
        boolean input1 = true;
        boolean input2 = false;
        boolean expected = true;
        boolean actual = e.returnOr(input1, input2);
        assertEquals(actual, expected);
    }
    /**
     * If input1 is false and input2 is true, then returnOr(input1, input2) should return true.
     */
    @Test
    public void returnOrTest3(){
        boolean input1 = false;
        boolean input2 = true;
        boolean expected = true;
        boolean actual = e.returnOr(input1, input2);
        assertEquals(actual, expected);
    }
    /**
     * If input1 is false and input2 is false, then returnOr(input1, input2) should return false.
     */
    @Test
    public void returnOrTest4(){
        boolean input1 = false;
        boolean input2 = false;
        boolean expected = false;
        boolean actual = e.returnOr(input1, input2);
        assertEquals(actual, expected);
    }


}
