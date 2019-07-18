import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int sum = 0 - nums[i], low = i + 1, high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }

    private static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;
        int result = nums[0] + nums[1] + nums[nums.length - 1];;
        Arrays.sort(nums);

        for(int i = 0; i< nums.length; i++) {
            int low = i + 1, high = nums.length - 1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    return target;
                } else if(sum > target)
                    high--;
                else
                    low++;

                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
