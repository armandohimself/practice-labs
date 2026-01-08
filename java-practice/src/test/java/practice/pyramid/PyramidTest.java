package practice.pyramid;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PyramidTest {
    Pyramid p = new Pyramid();

    /**
     * a size 5 pyramid should return this:
     * *
     * **
     * ***
     * ****
     * *****
     */
    @Test
    public void pyramidTest1(){
        int input = 5;
        String expected = "*\n**\n***\n****\n*****";
        String actual = p.returnPyramid(input).trim();
        assertEquals(expected,actual);
    }

    /**
     * a size 2 pyramid should return this:
     * *
     * **
     */
    @Test
    public void pyramidTest2(){
        int input = 2;
        String expected = "*\n**";
        String actual = p.returnPyramid(input).trim();
        assertEquals(expected,actual);
    }
}
