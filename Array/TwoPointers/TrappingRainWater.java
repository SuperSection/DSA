
/**
 * LeetCode Problem: 42. Trapping Rain Water
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP42 {

    public static int trap(int[] height) {

        if (height.length == 1) {
            return 0;
        }

        int trappedWater = 0;
        int left = 0, right = height.length - 1;
        int leftMaxHeight = height[left], rightMaxHeight = height[right];

        while (left < right) {

            if (height[left] < height[right]) {

                leftMaxHeight = Math.max(leftMaxHeight, height[left]);

                if (leftMaxHeight - height[left] > 0) {
                    trappedWater += leftMaxHeight - height[left];
                }

                left++;
            } else {
                rightMaxHeight = Math.max(rightMaxHeight, height[right]);

                if (rightMaxHeight - height[right] > 0) {
                    trappedWater += rightMaxHeight - height[right];
                }

                right--;
            }
        }

        return trappedWater;
    }
}

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(SolutionLCP42.trap(
                new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
        ));
    }
}
