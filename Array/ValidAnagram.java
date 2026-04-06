
/**
 * LeetCode Problem: 242. Valid Anagram
 */
class Solution {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }

        for (int count : alphabets) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(Solution.isAnagram("race", "care"));
        System.out.println(Solution.isAnagram("cat", "tab"));
    }
}
