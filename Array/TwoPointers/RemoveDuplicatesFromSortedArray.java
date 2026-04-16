
/**
 * LeetCode Problem: 26. Remove Duplicates from Sorted Array
 *
 * --- Solution ---
 *      Time Complexity: O(n)
 *      Space Complexity: O(1)
 */
class SolutionLCP26 {

    public static int removeDuplicates(int[] nums) {

        int insertIndex = 1;

        for (int i = 1; i < nums.length; i++) {

            // we skip to next index if we see a duplicate element
            if (nums[i - 1] != nums[i]) {

                // Storing the unique element at insertIndex
                // and increamenting the insertIndex by 1
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }

        return insertIndex;
    }
}

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // Input array
        int[] expectedNums = new int[]{0, 1, 2, 3, 4}; // The expected answer with correct length

        int k = SolutionLCP26.removeDuplicates(nums); // Calls your implementation
        assert k == expectedNums.length;

        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
