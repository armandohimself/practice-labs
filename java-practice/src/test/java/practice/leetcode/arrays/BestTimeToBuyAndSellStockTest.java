package practice.leetcode.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Best Time to Buy and Sell Stock Tests")
class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.leetcode.arrays", "BestTimeToBuyAndSellStock");
    }

    @Test
    @DisplayName("Example 1: [7,1,5,3,6,4] should return 5")
    void testExample1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, solution.maxProfit(prices));
    }

    @Test
    @DisplayName("Example 2: [7,6,4,3,1] should return 0")
    void testExample2() {
        int[] prices = {7, 6, 4, 3, 1};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    @DisplayName("Single price should return 0")
    void testSinglePrice() {
        int[] prices = {5};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    @DisplayName("Two prices ascending should return difference")
    void testTwoPricesAscending() {
        int[] prices = {1, 5};
        assertEquals(4, solution.maxProfit(prices));
    }

    @Test
    @DisplayName("Two prices descending should return 0")
    void testTwoPricesDescending() {
        int[] prices = {5, 1};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    @DisplayName("All same prices should return 0")
    void testAllSamePrices() {
        int[] prices = {3, 3, 3, 3};
        assertEquals(0, solution.maxProfit(prices));
    }
}
