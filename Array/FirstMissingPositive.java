
/**
 * LeetCode Problem: 41. First Missing Positive
 *
 * --- Condition ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 *
 * If we use HashMap, the Space Complexity would be O(n)
 */
class SolutionLCP41 {

    public static int firstMissingPositive(int[] nums) {

        // The answer will always lie between: 1 to n+1
        // where, n = nums.length
        int n = nums.length;
        boolean containsOne = false;

        // Step 1: Check if 1 exists
        for (int num : nums) {
            if (num == 1) {
                containsOne = true;
                break;
            }
        }

        if (!containsOne) {
            return 1;
        }

        // Step 2: Replace invalid numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // Step 3: Mark presence
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);

            if (index == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }

        // Step 4: Find missing
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }
}

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(SolutionLCP41.firstMissingPositive(
                new int[]{3, 4, -1, 1}
        ));
    }
}
