package main.java.practice.largestsum;

import java.util.List;

/**
 * Interface for LargestSum challenge implementations.
 * All attempts (LargestSum, LargestSum2, etc.) should implement this.
 */
public interface LargestSumSolution {
    /**
     * Calculate the sum of the two largest integers.
     *
     * @param nums List of integers (can be null or empty)
     * @return Sum of two largest integers, or 0 if insufficient data
     */
    int bigSum(List<Integer> nums);
}
