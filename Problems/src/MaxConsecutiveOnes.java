public class MaxConsecutiveOnes {
    /*
    Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        if( nums == null || nums.length == 0 )
            return -1;
        int max = 0, count1 = 0, count0 = 0;
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] == 1) {
                count1++;
            } else {
                count0 = count1 + 1;
                count1 = 0;
            }
            max = Math.max(max, count1 + count0);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{ 1, 1, 0, 1, 1, 1, 0, 0, 1}));
    }
}
