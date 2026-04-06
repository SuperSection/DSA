
import java.util.HashMap;

/**
 * LeetCode Problem: 219. Contains Duplicate II
 */
class Solution {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }

            map.put(nums[i], i);
        }
        return false;
    }
}

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(Solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(Solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
