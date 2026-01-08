package practice.subarray;

import java.util.Arrays;

public class SubArray {
    /**
     * Return only a part of an array. For instance, given the array {1,2,3,4,5}, a sub array with start 1 and end 4
     * would result in {2,3,4}, because the starting index is inclusive, but the ending index is exclusive.
     *
     * You will need to create a new array whose size is only the amount of elements requested between the start and
     * end index, and then write a for loop which copies values from nums over to this new resulting array.
     *
     * @param nums an array of ints.
     * @param start the starting index, inclusive.
     * @param end the ending index, exclusive.
     * @return a sub-array of nums containing the values between start and end.
     */
    public int[] sub(int[] nums, int start, int end){

        System.out.println("Array we started with is " + Arrays.toString(nums));

        // Fastest implementation 
        //int[] subArray = Arrays.copyOfRange(nums, start, end);
        //return Arrays.copyOfRange(nums, start, end);
        // But let's say we only knew .copyOf()

        int[] subArray = Arrays.copyOf(nums, end - start);
        System.out.println("Copied array is " + Arrays.toString(subArray));
        int counter = 0;

        for(int i = start; i < end; i++) {
            subArray[counter] = nums[i];
            counter++;
            System.out.println(Arrays.toString(subArray));
        }

        return subArray;
    }
}
