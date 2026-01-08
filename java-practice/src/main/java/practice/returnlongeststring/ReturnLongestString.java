package practice.returnlongeststring;


public class ReturnLongestString {
    /**
     * Return the longest String out of arr.
     * Remember that you can get the length of String with str.length().
     *
     * @param arr an array of Strings.
     * @return the longest String within arr. You can assume that there are no ties for the longest string.
     */
    public String longest(String[] arr){
        int index = 0;
        int stringLength = arr[index].length();
        String longestString = "";

        for(int right = 1; right < arr.length; right++) {
            if(stringLength < arr[right].length()) {
                index = right;
                stringLength = arr[right].length();
                longestString = arr[right];
            }
        }

        return longestString;
    }
}
