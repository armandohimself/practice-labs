package practice.pyramid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

public class PyramidTest {
    

    
    private PyramidSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.pyramid", "Pyramid");
    }

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
        String actual = solution.returnPyramid(input).trim();
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
        String actual = solution.returnPyramid(input).trim();
        assertEquals(expected,actual);
    }
}
