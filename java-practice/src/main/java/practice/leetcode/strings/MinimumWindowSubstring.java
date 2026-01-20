package practice.leetcode.strings;

/**
 * Minimum Window Substring (LeetCode #76)
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring
 * of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * Example 1:
 *   Input: s = "ADOBECODEBANC", t = "ABC"
 *   Output: "BANC"
 *   Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 *   Input: s = "a", t = "a"
 *   Output: "a"
 *   Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 *   Input: s = "a", t = "aa"
 *   Output: ""
 *   Explanation: Both 'a's from t must be included in the window.
 */
public class MinimumWindowSubstring {

    /**
     * Finds the minimum window substring containing all characters from t.
     *
     * @param s source string
     * @param t target string
     * @return minimum window substring
     */
    public String minWindow(String s, String t) {
        // TODO: Implement your solution here (consider sliding window)
        return "";
    }
}
