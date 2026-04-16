
/**
 * LeetCode Problem 11: Container With Most Water
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP11 {

    public static int maxArea(int[] height) {

        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int maxWaterAmount = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            int area = Math.min(height[left], height[right]) * (right - left);
            maxWaterAmount = Math.max(maxWaterAmount, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWaterAmount;
    }
}

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(SolutionLCP11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
