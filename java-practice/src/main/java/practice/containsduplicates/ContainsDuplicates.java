package practice.containsduplicates;

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicates {
    /**
     * Determine if an array of items contains any duplicate values. You should use a Set for this: remember that
     * Sets can not have duplicate values, but you may check if a value is already contained using the .contains method.
     * @param nums an array of ints.
     * @return true if nums contains any duplicate values, false if it does not.
     */
    public boolean containsDuplicate(int[] nums){
        Set<Integer> intSet = new HashSet<>();

        // Works fine but we can end earlier
        // for(int num : nums) {
        //     intSet.add(num);
        // }

        // if length == size -> true no duplicates
        // otherwise diff length/size -> found duplicate
        //return nums.length != intSet.size();

        // Better implementation to end early instead of O(n) complexity
        for (int num : nums) {
            // Guard Clause - End early if duplicate found
            if (intSet.contains(num)) return true;
            intSet.add(num);
        }

        return false;
    }
}
