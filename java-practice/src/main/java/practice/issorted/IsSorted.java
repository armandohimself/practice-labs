package practice.issorted;

public class IsSorted {
    /**
     * Return true if arr is sorted, smallest to largest, false otherwise.
     * For example, {1,2,3,4} is storted but {1,2,4,3} is unsorted
     *
     * @param arr an int array
     * @return true if arr is sorted (all the numbers are in order). false if arr is not sorted.
     */
    public boolean checkSort(int[] arr){
        // Guard Clause - Empty
        // if(arr.isEmpty()) return false;

        // Left will compare to right
        int left = arr[0];

        // Iteratre starting at index 1
        for(int right = 1; right < arr.length; right++) {
            // e.g., if 3 > 1 return false
            if(left > arr[right]) return false;
            // update left
            left = right;
        }

        // Array was sorted
        return true;
    }
}
