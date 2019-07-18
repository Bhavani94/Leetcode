import java.util.Arrays;

public class MoveZeros {
    private static void moveZeroes(int[] nums) {
        for (int lastNonZero = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int temp = nums[lastNonZero];
                nums[lastNonZero++] = nums[cur];
                nums[cur] = temp;
            }
        }
    }

    private static void moveZeroes1(int[] nums) {
        //better
        int lastIndex = 0;
        for(int num : nums) {
            if(num != 0) {
                nums[lastIndex++] = num;
            }
        }

        while(lastIndex < nums.length) {
            nums[lastIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 4, 5, 0};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        moveZeroes1(a);
        System.out.println(Arrays.toString(a));
    }
}
