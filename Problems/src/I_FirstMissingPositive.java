public class I_FirstMissingPositive {
    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int count = 0;

        // check if 1 is present
        for(int i : nums) {
            if( i == 1) {
                count++;
                break;
            }
        }

        // if 1 is not present
        if(count == 0)
            return 1;

        // if 1 is present and size of array is 1
        if(n == 1)
            return 2;

        // missing smallest positive will line between 1 to n + 1
        // replace numbers outside this range with 1.
        // At this time we have already checked if 1 is present.
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > n || nums[i] < 1) {
                nums[i] = 1;
            }
        }

        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (a == n)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
