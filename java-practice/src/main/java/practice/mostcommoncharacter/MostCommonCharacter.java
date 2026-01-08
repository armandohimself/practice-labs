package practice.mostcommoncharacter;

import java.util.Map;
import java.util.HashMap;

public class MostCommonCharacter {
    /**
     * Find the most common character in str.
     * You could use a HashMap that maps a Character key to an Int value to represent how many times a Character has
     * been spotted.
     * @param str A String.
     * @return the most common character within str.
     */
    public char recurringChar(String str) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (charMap.containsKey(c)) {
                int frequency = charMap.get(c);
                charMap.put(c, ++frequency);
            } else {
                charMap.put(c, 1);
            }
        }

        char mostFrequentCharacter = ' ';
        int maxValue = Integer.MIN_VALUE;


        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                mostFrequentCharacter = entry.getKey();
            }
        }

        return mostFrequentCharacter;
    }
}
