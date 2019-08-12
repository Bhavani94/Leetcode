public class MaxSubArray {
    private static int maxSubArray(int[] nums) {
        int tempMax = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            tempMax = Math.max(tempMax + nums[i], nums[i]);
            max = Math.max(tempMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
