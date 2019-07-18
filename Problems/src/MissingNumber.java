import java.util.Arrays;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * (nums.length) /2;
        int s = 0;
        for (int i : nums)
            s += i;
        return sum - s;
    }

    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }

    public static int[] twoMissingNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        if(nums.length == 0)
            return ans;
        int k = 0;
        if(nums[0] != 0)
            ans[k++] = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] != 1)
                if(k == 0 || nums[i] - ans[k-1] != 1)
                    ans[k++] = nums[i-1] + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        int[] a = twoMissingNumbers(new int[]{0,1,3,5,6,7});
        for(int i : a)
            System.out.print(i + " ");
    }
}
