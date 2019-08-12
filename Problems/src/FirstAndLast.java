import java.util.Arrays;

public class FirstAndLast {
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static int[] searchRange1(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange1(new int[]{5,5,8,8,8,10}, 5)));
    }
}
