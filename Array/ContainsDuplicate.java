
import java.util.HashSet;

/**
 * LeetCode Problem: 217. Contains Duplicate
 */
class SolutionLCP217 {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(SolutionLCP217.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(SolutionLCP217.containsDuplicate(new int[]{1, 2, 4, 3, 5}));
    }
}
