
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Problem: 15. 3Sum
 *
 * --- Solution ---
 *      Time Complexity: O(n^2)
 *      Space Complexity: O(1)  [excluding output]
 */
class SolutionLCP15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }

}

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(SolutionLCP15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
