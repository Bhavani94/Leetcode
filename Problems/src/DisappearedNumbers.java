import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        if(nums.length == 1 && nums[0] == 1)
            return new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if(a == nums.length)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 1 ;i < nums.length; i++) {
            if(nums[i] > 0) {
                ans.add(i);
            }
        }
        if(nums[0] > 0) {
            ans.add(nums.length);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers(new int[]{1,1}));
        System.out.println(findDisappearedNumbers(new int[]{1,1,2,2}));
        System.out.println(findDisappearedNumbers(new int[]{}));
    }
}
