package practice.maxminusmin;


import java.util.List;
import java.util.ListIterator;

public class MaxMinusMin {
    /**
     * Return the difference between the highest and lowest values of the List.
     * This will require you to know some of the List interface methods.
     *
     * @param nums an List<Integer> containing varying nums.
     * @return the max value of nums minus the min value of nums.
     */
    public int difference(List<Integer> nums) {
        int max = nums.get(0);
        int min = nums.get(0);

        // Example using for advance loop
        // for (Integer number : nums) {
        //     if(number < min) min = number; 
        //     if (number > max) max = number;
        // }


        // Example of using an iterator list 
        ListIterator<Integer> numberedList = nums.listIterator();
        // Return a created iterator list stored in numberList

        while(numberedList.hasNext()) {
            int number = numberedList.next();
            if(number < min) min = number;
            if (number > max) max = number;
        }

        return (max - min);
    }
}
