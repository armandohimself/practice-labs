package practice.leetcode.arrays;

/**
 * Product of Array Except Self (LeetCode #238)
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the
 * product of all the elements of nums except nums[i].
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 *   Input: nums = [1,2,3,4]
 *   Output: [24,12,8,6]
 *
 * Example 2:
 *   Input: nums = [-1,1,0,-3,3]
 *   Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    /**
     * Returns an array where each element is the product of all other elements.
     *
     * @param nums input array
     * @return product array
     */
    public int[] productExceptSelf(int[] nums) {
        // TODO: Implement your solution here
        return new int[nums.length];
    }
}
