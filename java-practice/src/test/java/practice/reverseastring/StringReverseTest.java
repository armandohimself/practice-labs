package practice.reverseastring;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringReverseTest {
    StringReverse sr = new StringReverse();

    /**
     * The reverse of "abc" is "cba".
     */
    @Test
    public void StringReverseTest1(){
        String s = "abc";
        String target = "cba";
        assertEquals(target, sr.reverse(s));
    }

    /**
     * The reverse of "racecar" is "racecar".
     */
    @Test
    public void StringReverseTest2(){
        String s = "racecar";
        String target = "racecar";
        assertEquals(target, sr.reverse(s));
    }

    /**
     * The reverse of "f" is "f".
     */
    @Test
    public void StringReverseTest3(){
        String s = "f";
        String target = "f";
        assertEquals(target, sr.reverse(s));
    }

    /**
     * The reverse of "" is "".
     */
    @Test
    public void StringReverseTest4(){
        String s = "";
        String target = "";
        assertEquals(target, sr.reverse(s));
    }

    /**
     * The reverse of "pillow" is "wollip".
     */
    @Test
    public void StringReverseTest5(){
        String s = "pillow";
        String target = "wollip";
        assertEquals(target, sr.reverse(s));
    }
}