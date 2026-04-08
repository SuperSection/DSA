
/**
 * LeetCode Problem: 424. Longest Repeating Character Replacement
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP424 {

    public static int characterReplacement(String s, int k) {
        // VALID CONDITION: window_size - max_frequency <= k

        int longestSubstring = 0;

        int left = 0, right = 0, maxFreq = 0;
        int[] freq = new int[26];

        while (right < s.length()) {
            int c = s.charAt(right) - 'A';

            freq[c]++;
            maxFreq = Math.max(maxFreq, freq[c]);

            int windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            longestSubstring = Math.max(longestSubstring, right - left + 1);

            right++;
        }

        return longestSubstring;
    }
}

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(SolutionLCP424.characterReplacement("PXQXRXS", 2));
    }
}
