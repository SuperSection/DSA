
/**
 * LeetCode Problem: 643. Maximum Average Subarray I
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP643 {

    public static double findMaxAverage(int[] nums, int k) {

        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = sum / k;

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxAvg = maxAvg > (sum / k) ? maxAvg : (sum / k);
        }

        return maxAvg;
    }
}

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        System.out.println(SolutionLCP643.findMaxAverage(
                new int[]{1, 12, -5, -6, 50, 3}, 4
        ));
    }
}
