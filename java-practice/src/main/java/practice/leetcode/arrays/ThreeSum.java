package practice.leetcode.arrays;

/**
 * 3Sum (LeetCode #15)
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *   Input: nums = [-1,0,1,2,-1,-4]
 *   Output: [[-1,-1,2],[-1,0,1]]
 *   Explanation:
 *   nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 *   nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 *   nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 *
 * Example 2:
 *   Input: nums = [0,1,1]
 *   Output: []
 *
 * Example 3:
 *   Input: nums = [0,0,0]
 *   Output: [[0,0,0]]
 */
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {

    /**
     * Finds all unique triplets that sum to zero.
     *
     * @param nums array of integers
     * @return list of triplets that sum to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // TODO: Implement your solution here
        return new ArrayList<>();
    }
}
