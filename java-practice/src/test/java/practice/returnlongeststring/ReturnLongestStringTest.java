package practice.returnlongeststring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;




public class ReturnLongestStringTest {
    

    
    private ReturnLongestStringSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.returnlongeststring", "ReturnLongestString");
    }

/**
     * of the strings {"abc", "def", "hijk"}, "hijk" is the longest.
     */
    @Test
    public void ReturnLongestStringTest1(){
        String[] s = {"abc", "def", "hijk"};
        String target = "hijk";
        assertEquals(target, solution.longest(s));
    }

    /**
     * of the strings {"abc", "defsdgh", "hijkfdgafgafg"}, "hijkfdgafgafg" is the longest.
     */
    @Test
    public void ReturnLongestStringTest2(){
        String[] s = {"abc", "defsdgh", "hijkfdgafgafg"};
        String target = "hijkfdgafgafg";
        assertEquals(target, solution.longest(s));
    }
    /**
     * of the strings {"abc", "defsdgh", "hijk"}, "defsdgh" is the longest.
     */
    @Test
    public void ReturnLongestStringTest3(){
        String[] s = {"abc", "defsdgh", "hijk"};
        String target = "defsdgh";
        assertEquals(target, solution.longest(s));
    }
}
