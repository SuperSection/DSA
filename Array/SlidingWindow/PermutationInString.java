
import java.util.Arrays;

/**
 * LeetCode Problem: 567. Permutation in String
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP567 {

    public static boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length(), n2 = s2.length();

        if (n1 > n2) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        for (int i = n1; i < n2; i++) {

            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - n1) - 'a']--;

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(SolutionLCP567.checkInclusion("ab", "eidbaooo"));
    }
}
