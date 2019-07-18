import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {
    private static boolean checkSubarraySum(int[] nums, int k) {
        /*[23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0].
        We got remainder 5 at index 0 and at index 3. That means, in between these two indexes
        we must have added a number which is multiple of the k
         */
        if(nums == null)
            return false;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        int runningSum = 0;
        remainderMap.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if( k != 0)
                runningSum %= k;
            if(remainderMap.containsKey(runningSum)) {
                if (i - remainderMap.get(runningSum) > 1)
                    return true;
            } else
                remainderMap.put(runningSum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(checkSubarraySum(null, 6));
    }
}
