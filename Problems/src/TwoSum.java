import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair))
                return new int[] { map.get(pair), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    private static int[] twoSumII(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)
            return null;
        int start = 0, end = numbers.length - 1;

        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target)
                return new int[]{start + 1, end + 1};
            if(sum < target)
                start++;
            else
                end--;
        }
        return new int[0];
    }

    private static int twoSumLessThanK(int[] A, int K) {
        if(A == null || A.length == 0)
            return -1;

        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        int sum, max = -1;

        while(i < j) {
            sum = A[i] + A[j];
            if(sum < K) {
                max = Math.max(max, sum);
                i++;
            } else if(sum > K)
                j--;
            else
                i++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));

        System.out.println(Arrays.toString(twoSumII(new int[]{2,7,11,15}, 9)));

        System.out.println(twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8}, 60));
    }
}
