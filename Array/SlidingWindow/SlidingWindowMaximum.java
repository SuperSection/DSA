
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode Problem: 239. Sliding Window Maximum
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(k)
 */
class SolutionLCP239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 1) {
            return nums;
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        // We could use LinkedList, BUT that has more memory overhead
        // ArrayDeque is likely to be faster than LinkedList when used as a queue.
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices whose corresponding values are less than nums[i]
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add the current index to the deque
            dq.offerLast(i);

            // Remove out-of-window indices
            if (dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // Add 'max' element of the current window to the result array
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SolutionLCP239.maxSlidingWindow(
                new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3
        )));
    }
}
