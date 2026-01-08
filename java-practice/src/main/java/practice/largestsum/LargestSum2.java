package practice.largestsum;

import java.util.List;

/**
 * LargestSum2 Challenge - Alternative implementation
 *
 * Find the sum of the two largest integers in a list.
 *
 * Example:
 *   [0, 4, 2, 5, 0] -> 9 (4 + 5)
 *   [5, 4, 2, 5, 0] -> 10 (5 + 5)
 *
 * Requirements:
 *   - Return 0 for null or empty lists
 *   - Return the single element for single-element lists
 *   - Handle negative numbers
 *   - Duplicates are allowed (can sum the same value twice if it appears twice)
 */
public class LargestSum2 implements LargestSumSolution {

    /**
     * Calculate the sum of the two largest integers.
     *
     * @param nums List of integers (can be null or empty)
     * @return Sum of two largest integers, or 0 if insufficient data
     */
    public int bigSum(List<Integer> nums) {
        // Second attempt implementation (same logic for testing)

        if (nums == null || nums.isEmpty()) {
            return 0;
        }

        if (nums.size() == 1) {
            return nums.get(0);
        }

        // Find two largest numbers
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        return largest + secondLargest;
    }
}
