package practice.pyramid;


public class Pyramid {
    /**
     * TODO: Return a string that is a pyramid of size n, made of asterisks and no spaces.
     *
     *     for example:
     *
     *     size 3:
     *     *
     *     **
     *     ***
     *
     *     size 5:
     *     *
     *     **
     *     ***
     *     ****
     *     *****
     *
     * The newline character can be written as \n .
     * The tests will not be affected by a newline character at the beginning or end of the entire pyramid.
     *
     * Here's a hint: you could use a for loop inside of a for loop for this problem. The outer for loop
     * can determine the current 'row', and the inner for loop can print an asterisk an N amount of times based on the
     * current 'row'.
     *
     * @param n the size of the pyramid.
     * @return a string representation of the pyramid.
     */
    public String returnPyramid(int n){
        StringBuilder pyramidString = new StringBuilder("");
        int starAppendCounter = 0;

        for(int row = 0; row <= n; row++) {
            // Initial start (might change for first row)
            if (row == 0) starAppendCounter++;

            if (row == starAppendCounter) {
                for(int starsToAppend = 1; starsToAppend <= starAppendCounter; starsToAppend++) {
                    pyramidString.append("*");
                }

                // Guard Clause (to Stop)
                if (starAppendCounter == n) break;
                
                pyramidString.append("\n");
                starAppendCounter++;
            }
        }

        return pyramidString.toString();
    }
}
