package practice.indexof;


//

public class IndexOf {
    /**
     * Find the position of a number in an array.
     * For example, the position of 7 in {0,1,7,3,4} is 2.
     *
     * @param arr an int array.
     * @param n a possible value of arr.
     * @return the first index (position) of n in arr. if n does not exist in arr, return -1.
     */
    public int getIndex(int[] arr, int n){
        int indexPosition = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == n) return indexPosition = i;
        }

        return indexPosition;

        // Relearned that indexOf is not part of the Collection framework but can be used in the List framework
        /*
         * Could convert Array to List
         * int index = Arrays.asList(arr).indexOf(n);
         */
    }
}
