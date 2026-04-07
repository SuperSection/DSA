
import java.util.HashMap;

/**
 * LeetCode Problem: 953. Verifying an Alien Dictionary
 */
class SolutionLCP953 {

    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            int curr = 0;

            while (curr < words[i].length() && curr < words[i + 1].length()) {
                int first = orderMap.get(words[i].charAt(curr));
                int second = orderMap.get(words[i + 1].charAt(curr));

                if (first > second) {
                    return false;
                }
                if (first < second) {
                    break;
                }
                curr++;
            }

            if (curr == words[i + 1].length() && words[i].length() > words[i + 1].length()) {
                return false;
            }
        }

        return true;
    }
}

public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        System.out.println(SolutionLCP953.isAlienSorted(
                new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"
        ));
    }
}
