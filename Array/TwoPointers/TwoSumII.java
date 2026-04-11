
import java.util.Arrays;

/**
 * LeetCode Problem: 167. Two Sum II - Input Array Is Sorted
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP167 {

    public static int[] twoSum(int[] numbers, int target) {

        if (numbers.length == 2) {
            return new int[]{1, 2};
        }

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{};
    }
}

public class TwoSumII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SolutionLCP167.twoSum(
                new int[]{2, 7, 11, 15}, 9
        )));
    }
}
