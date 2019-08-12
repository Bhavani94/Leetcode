import java.util.Arrays;

public class SingleNumber {
    /*
    Given a sorted array consisting of only integers where every element appears exactly twice except
    for one element which appears exactly once. Find this single element that appears only once.
     */
    private static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (start + end) / 2;
            //since all numbers appear 2 times
            if(mid % 2 == 1)
                mid --;

            if(nums[mid] == nums[mid + 1])
                start = mid + 2;

            else
                end = mid;
        }
        return nums[start];
    }

    /*
    Given an array of numbers nums, in which exactly two elements appear only
    once and all the other elements appear exactly twice.
    Find the two elements that appear only once.
     */
    private static int[] singleNumber(int[] nums) {
        int diff = 0;
        // all elements repeated twice except 2; diff has XOR of the 2. others cancel out each
        // other
        for(int num : nums)
            diff ^= num;

        // get last set bit
        diff &= -diff;

        int[] ans = new int[2];
        // group them by diff
        for(int num : nums) {
            if((diff & num) == 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{ 0, 1, 1, 2, 2, 5, 5, 6, 6}));
        System.out.println(Arrays.toString(singleNumber(new int[]{1,2,1,3,2,5})));

    }
}
