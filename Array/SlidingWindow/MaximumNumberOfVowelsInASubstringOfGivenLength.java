
/**
 * LeetCode Problem: 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP1456 {

    public static int maxVowels(String s, int k) {
        int vowelCount = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char r = s.charAt(i);

            if (r == 'a' || r == 'e' || r == 'i' || r == 'o' || r == 'u') {
                vowelCount++;
            }

            if (i >= k) {
                char l = s.charAt(i - k);
                if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') {
                    vowelCount--;
                }
            }

            if (i >= k - 1) {
                max = max > vowelCount ? max : vowelCount;
            }
        }

        return max;
    }
}

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        System.out.println(SolutionLCP1456.maxVowels("leetcode", 3));
    }
}
