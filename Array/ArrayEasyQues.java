
import java.util.Arrays;

/**
 * LeetCode Problem: 1929. Concatenation of Array
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(n)
 */
class SolutionLCP1929 {

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
}

/**
 * LeetCode Problem: 1470. Shuffle the Array
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(n)
 */
class SolutionLCP1470 {

    public static int[] shuffle(int[] nums, int n) {
        int[] output = new int[2 * n];
        int x = 0, y = n;
        int i = 0;

        while (x < n && y < nums.length) {
            output[i] = nums[x];
            i++;
            x++;
            output[i] = nums[y];
            i++;
            y++;
        }

        return output;
    }
}

/**
 * LeetCode Problem: 485. Max Consecutive Ones
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int track = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                track++;
            } else {
                track = 0;
            }
            if (track > maxOnes) {
                maxOnes = track;
            }
        }

        return maxOnes;
    }
}

/**
 * LeetCode Problem: 645. Set Mismatch
 * 
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(n)
 */
class SolutionLCP645 {

    public static int[] findErrorNums(int[] nums) {

        boolean[] seen = new boolean[nums.length + 1];
        int duplicate = -1;

        for (int num : nums) {
            if (seen[num]) {
                duplicate = num;
            }
            seen[num] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!seen[i]) {
                return new int[]{duplicate, i};
            }
        }

        return new int[]{-1, -1};
    }
}

public class ArrayEasyQues {

    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 3, 4, 7};

        System.out.println(Arrays.toString(SolutionLCP1929.getConcatenation(nums)));
        System.out.println(Arrays.toString(SolutionLCP1470.shuffle(nums, 3)));
        System.out.println(SolutionLCP485.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));

        System.out.println(Arrays.toString(SolutionLCP645.findErrorNums(new int[]{2, 2})));
    }
}
