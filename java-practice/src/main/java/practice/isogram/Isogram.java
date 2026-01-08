package practice.isogram;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Isogram {
    /**
     * An Isogram is a word where no letters are repeated. You may assume that there will only be lowercase
     * letters in the String.
     *
     * For instance, "cat", "isogram", "uncopyrightable" are isograms. "egg", "java", "programming" are not.
     * You could use a Set of characters or a Map of characters to int or boolean to solve this problem.
     * You could even solve it with an array of 26 booleans, and convert characters to an index of that array.
     * It's also possible to solve this with nested for loops.... but it's not as easy or efficient.
     *
     * @param str a String.
     * @return true if str is an isogram, false otherwise.
     */
    public boolean isIsogram(String str){
        // Convert string to char array 
        char[] charArray = str.toCharArray();

        // Create a Set 
        Set<Character> charSet = new HashSet<>();

        // Use the add() to detect duplicates during iteration
        for (char c : charArray) {
            // Assume the character is there
            if (charSet.contains(c)) {
                // immediately return false to break out - not isogram
                return false;
            }
            // Othrewise add and continue iteration
            charSet.add(c);
        }

        // Return true if we've passed through our filter just fine
        return true;
    }
}

/*
ALternative Solution

 * // Create a Map to store character counts
        Map<Character, Integer> charMap = new HashMap<>();

        // Iterate through each character in the string
        for (char c : str.toCharArray()) {
            // Check if the character already exists in the Map
            if (charMap.containsKey(c)) {
                return false; // Duplicate found
            }
            // Add the character to the Map
            charMap.put(c, 1);
        }

        // No duplicates found
        return true;
 */