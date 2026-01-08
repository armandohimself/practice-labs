package practice.returnlongeststring;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReturnLongestStringTest {
    ReturnLongestString rls = new ReturnLongestString();

    /**
     * of the strings {"abc", "def", "hijk"}, "hijk" is the longest.
     */
    @Test
    public void ReturnLongestStringTest1(){
        String[] s = {"abc", "def", "hijk"};
        String target = "hijk";
        assertEquals(target, rls.longest(s));
    }

    /**
     * of the strings {"abc", "defsdgh", "hijkfdgafgafg"}, "hijkfdgafgafg" is the longest.
     */
    @Test
    public void ReturnLongestStringTest2(){
        String[] s = {"abc", "defsdgh", "hijkfdgafgafg"};
        String target = "hijkfdgafgafg";
        assertEquals(target, rls.longest(s));
    }
    /**
     * of the strings {"abc", "defsdgh", "hijk"}, "defsdgh" is the longest.
     */
    @Test
    public void ReturnLongestStringTest3(){
        String[] s = {"abc", "defsdgh", "hijk"};
        String target = "defsdgh";
        assertEquals(target, rls.longest(s));
    }
}
