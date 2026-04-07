
import java.util.Arrays;

/**
 * LeetCode Problem: 238. Product of Array Except Self
 */
class SolutionLCP238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int prefix = 1, postfix = 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= postfix;
            postfix *= nums[i];
        }

        return ans;
    }
}

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(SolutionLCP238.productExceptSelf(nums)));
    }

}
