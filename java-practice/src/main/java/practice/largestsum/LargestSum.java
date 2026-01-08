package practice.largestsum;


import java.util.List;

public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list. A number can't be added
     * to itself, unless there are duplicates.
     *
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Given the list {5, 4, 2, 5, 0}, the largest sum is 10 (5+5)
        // Given the list {0, 4, 2, 5, 0}, the largest sum is 9 (4+5)

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest; // Shift the largest to the second largest 
                largest = num;  // our new largest is the num we just found
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }
        return largest + secondLargest;
    }
}