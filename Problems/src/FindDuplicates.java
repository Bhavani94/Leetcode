import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i< nums.length; i++) {
            int a = Math.abs(nums[i]) - 1;
            if(nums[a] < 0)
                ans.add(a+1);
            nums[a] = -nums[a];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDuplicates(new int[]{1,1}));
        System.out.println(findDuplicates(new int[]{1,1,2,2}));
        System.out.println(findDuplicates(new int[]{}));
        System.out.println(findDuplicates(new int[]{10,2,5,10,9,1,1,4,3,7}));
    }
}
