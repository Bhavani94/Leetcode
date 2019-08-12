import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeArray {
    /*
    degree of this array is defined as the maximum frequency of any one of its elements.
    find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
     */
    private static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            if(!left.containsKey(nums[i]))
                left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int degree = Collections.max(count.values());
        int ans = nums.length;
        for(int i : count.keySet()){
            if(count.get(i) == degree)
                ans = Math.min(ans, right.get(i) - left.get(i) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 3, 3, 1}));
    }
}
