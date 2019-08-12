import java.util.Arrays;

public class ArrayPair {
    /*
    Given an array of 2n integers, your task is to group these integers
    into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes
    sum of min(ai, bi) for all i from 1 to n as large as possible.
     */
    private static int arrayPairSum(int[] nums) {
        //O(n)
        int[] n = new int[20001];
        Arrays.fill(n,0);
        for(int i : nums)
            n[i + 10000]++;
        int sum = 0;
        boolean flag = true;
        for(int i = 0; i < n.length; i++) {
            if (n[i]-- > 0) {
                if (flag)
                    sum += (i - 10000);
                flag = !flag;
            }
            if (n[i] > 0)
                i--;
        }
        return sum;
    }

    private static int arrayPairSum1(int[] nums) {
        //nlogn
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{6214, -2290, 2833, -7908}));
        System.out.println(arrayPairSum1(new int[]{6214, -2290, 2833, -7908}));
    }
}
