
/**
 * LeetCode Problem: 125. Valid Palindrome
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP125 {

    public static boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(SolutionLCP125.isPalindrome("7car - got. OG rac!7$"));
    }
}
