
/**
 * LeetCode Problem: 1343. Number of Sub-arrays of Size K
 * and Average Greater than or Equal to Threshold
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP1343 {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {

        int n = arr.length;
        int target = k * threshold;

        if (target == 0) {
            return n - k + 1;
        }

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int totalSubarrays = 0;

        if (sum >= target) {
            totalSubarrays++;
        }

        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i];

            if (sum >= target) {
                totalSubarrays++;
            }
        }

        return totalSubarrays;
    }
}

public class NumberOfSubarraysOfSizeK {

    public static void main(String[] args) {
        System.out.println(SolutionLCP1343.numOfSubarrays(
                new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
    }
}
