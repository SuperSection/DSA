
import java.util.HashSet;

/**
 * LeetCode Problem: 128. Longest Consecutive Sequence
 */
class SolutionLCP128 {

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longestCount = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int currCount = 0;

                while (set.contains(curr)) {
                    curr++;
                    currCount++;
                }

                longestCount = currCount > longestCount ? currCount : longestCount;
            }
        }

        return longestCount;
    }
}

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(SolutionLCP128.longestConsecutive(
                new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}
        ));
    }
}
