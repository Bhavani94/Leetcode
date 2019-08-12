import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Duplicate {
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
            if(!set.add(i))
                return true;
        return false;
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++)
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            } else
                map.put(nums[i], i);
        return false;
    }

    private static boolean containsNearbyDuplicate1(int[] nums, int k){
        //better solution
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate1(new int[]{1,2,3,1}, 3));
    }
}
