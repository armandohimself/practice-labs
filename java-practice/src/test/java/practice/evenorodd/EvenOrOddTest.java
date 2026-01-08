package practice.evenorodd;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EvenOrOddTest {
    static Lab eoo;
    @BeforeAll
    public static void setUp(){
        eoo = new Lab();
    }

    /**
     * Because 4 is even, eoo.decide(4) should return "Even".
     */
    @Test
    public void evenTest1(){
        assertEquals("Even", eoo.decide(4));
    }
    /**
     * Because 0 is even, eoo.decide(4) should return "Even".
     */
    @Test
    public void evenTest2(){
        assertEquals("Even", eoo.decide(0));
    }
    /**
     * Because 12 is even, eoo.decide(4) should return "Even".
     */
    @Test
    public void evenTest3(){
        assertEquals("Even", eoo.decide(12));
    }
    /**
     * Because 3 is odd, eoo.decide(3) should return "Odd".
     */
    @Test
    public void oddTest1(){
        assertEquals("Odd", eoo.decide(3));
    }
    /**
     * Because -5 is odd, eoo.decide(3) should return "Odd".
     */
    @Test
    public void oddTest2(){
        assertEquals("Odd", eoo.decide(-5));
    }
}
