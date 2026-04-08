
import java.util.HashMap;

/**
 * LeetCode Problem: 3. Longest Substring Without Repeating Characters
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(n)
 */
class SolutionLCP3 {

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int maxLength = 0;

        // Two Pointer approach
        int left = 0, right = 0;

        // You could use a HashSet
        // BUT it would be slower while moving the 'left' pointer
        HashMap<Character, Integer> charMap = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            // Maintain a Sliding Window of unique characters
            if (charMap.containsKey(c)) {
                left = Math.max(left, charMap.get(c) + 1);
            }

            charMap.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(SolutionLCP3.lengthOfLongestSubstring(
                "abatman"
        ));
    }
}
