import java.util.Arrays;

public class SortColours {
    public static void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[two++] = 2;
                nums[one++] = 1;
                nums[zero++] = 0;
            } else if(nums[i] == 1) {
                nums[two++] = 2;
                nums[one++] = 1;
            } else {
                nums[two++] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] ans = new int[]{2,1,0,1,1,2};
        sortColors(ans);
        System.out.println(Arrays.toString(ans));
    }
}
