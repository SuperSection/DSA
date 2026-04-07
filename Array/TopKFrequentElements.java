
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LeetCode Problem: 347. Top K Frequent Elements
 */
class SolutionLCP347 {

    public static int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        // Create a Min-Heap based on value (frequency)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Iterate through map and maintain only k elements in the PQ
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll(); // Removes the element with the smallest frequency
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SolutionLCP347.topKFrequent(
                new int[]{1, 3, 4, 3, 4, 2, 3, 4, 5, 2, 4, 5, 5}, 3
        )));
    }
}
