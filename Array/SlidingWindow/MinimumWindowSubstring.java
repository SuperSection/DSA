
/**
 * LeetCode Problem: 76. Minimum Window Substring
 *
 * --- Solution ---
 *      Time Complexity: O(m)
 *      Space Complexity: O(1)
 */
class SolutionLCP76 {

    public static String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128]; // ASCII safe

        // Store the required frequency of each letter from 't'
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int[] window = new int[128];  // Current window tracks the frequency of each letter

        int have = 0;   // Number of characters FULLY satisfied frequency requirement
        int needCount = 0;  // Total unique characters required

        // Count unique chars in t
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) {
                needCount++;
            }
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE; // Store Minimum Length of the Substring
        int startIndex = 0; // Store the starting index of the Minimum Window Substring

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;

            // Check if current character frequency matches the 'need'
            if (need[c] > 0 && window[c] == need[c]) {
                have++;
            }

            // Shrink the current window size from left, when 'have == needCount'
            while (have == needCount) {

                // Check whether the current window length is less than minimum substring length
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                // Remove the left character from the window
                window[leftChar]--;

                // Check if the removal of left character affect the 'have' required by 'need'
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(SolutionLCP76.minWindow(
                "ADOBECODEBANC", "ABC"
        ));
    }
}
