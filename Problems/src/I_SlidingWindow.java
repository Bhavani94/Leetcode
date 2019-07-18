public class I_SlidingWindow {
    private static int[] maxSlidingWindow(int[] nums, int k) {
        // Best O(n) Worst O(nk), O(1) space
        if(nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int max = Integer.MIN_VALUE;
        int start = 0, end = k, len = nums.length, index = 0;
        int[] ans = new int[len - k + 1];
        for(int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        ans[index++] = max;
        while(end < len) {
            if(max == nums[start++]) {
                max = Integer.MIN_VALUE;
                for (int i = start; i < start + k; i++) {
                    max = Math.max(max, nums[i]);
                }
            }
            max = Math.max(max, nums[end++]);
            ans[index++] = max;
        }
        return ans;
    }

    private static int[] maxSlidingWindow1(int[] nums, int k) {
        // O(n) 2 pass, O(2n) space
        if(nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int len = nums.length;
        int[] left_max = new int[len];
        int[] right_max = new int[len];

        left_max[0] = nums[0];
        right_max[len - 1] = nums[len - 1];
        for(int i = 1; i < len; i++ ) {
            left_max[i] = ( i % k == 0) ? nums[i] : Math.max(left_max[i - 1], nums[i]);

            int right = len - 1 - i;
            right_max[right] = (right % k == 0) ? nums[right] : Math.max(right_max[right + 1],
                  nums[right]);
        }
        int[] slidingMax = new int[len - k + 1];
        for(int i = 0; i <= len - k; i ++) {
            slidingMax[i] = Math.max(right_max[i], left_max[i + k - 1]);
        }
        return slidingMax;
    }

    public static void main(String[] args) {
        int[] a = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for(int i : a)
            System.out.print(i + " ");
        System.out.println("");
        a = maxSlidingWindow1(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for(int i : a)
            System.out.print(i + " ");
        System.out.println("");
        a = maxSlidingWindow(new int[]{1,3,-1,-3}, 2);
        for(int i : a)
            System.out.print(i + " ");
        System.out.println("");
        a = maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for(int i : a)
            System.out.print(i + " ");
        System.out.println("");
    }
}
