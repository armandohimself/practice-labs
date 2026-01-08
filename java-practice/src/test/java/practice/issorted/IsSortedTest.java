package practice.issorted;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

public class IsSortedTest {
    
    private IsSortedSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.issorted", "IsSorted");
    }

    /**
     * The array {7, 5, 9, 0, 2} is not in sorted order, so checkSort should return false.
     */
    @Test
    public void isSortedTest1(){
        int[] input = {7, 5, 9, 0, 2};
        boolean expected = false;
        assertEquals(expected, solution.checkSort(input));
    }
    /**
     * The array {1, 2, 3, 4, 5} is in sorted order, so checkSort should return true.
     */
    @Test
    public void isSortedTest2(){
        int[] input = {1, 2, 3, 4, 5};
        boolean expected = true;
        assertEquals(expected, solution.checkSort(input));
    }
    /**
     * The array {2, 4, 6, 7} is in sorted order, so checkSort should return true.
     */
    @Test
    public void isSortedTest3(){
        int[] input = {2, 4, 6, 7};
        boolean expected = true;
        assertEquals(expected, solution.checkSort(input));
    }
}
