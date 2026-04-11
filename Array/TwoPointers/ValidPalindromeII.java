
/**
 * LeetCode Problem: 680. Valid Palindrome II
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP680 {

    public static boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // try skipping either left or right
                return isPalindrome(s, left + 1, right)
                        || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(SolutionLCP680.validPalindrome("acdkca"));
    }
}
