public class FirstAndLast {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int a = expand(nums, target);
        if( a == nums.length || nums[a] != target)
            return ans;
        ans[0] = a;
        ans[1] = expandend(nums, target);
        return ans;
    }

    public static int expand(int[] nums, int target){
        int start  = 0;
        int end = nums.length;
        while(start < end){
            int mid = (end + start) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public static int expandend(int []nums, int target){
        int start  = 0;
        int end = nums.length;
        while(start < end){
            int mid = (end + start) / 2;
            if(nums[mid] > target)
                end = mid;
            else if(nums[mid] <= target)
                start = mid + 1;
        }
        return start - 1;
    }


    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }

        return start;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
    public static void main(String[] args) {
        int[] ans = searchRange(new int[]{5,5,8,8,8,10}, 5);
        for (int i : ans)
            System.out.println(i);
    }
}
