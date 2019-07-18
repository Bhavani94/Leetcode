import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
   private static int subarraySum(int[] nums, int k) {
      //eg      3 2 7 1 6 sum 10
      //presum  3 5 12 13 19
      // at any point we check if num to be subtracted exists in map
      int sum = 0, result = 0;
      Map<Integer, Integer> preSum = new HashMap<>();
      preSum.put(0, 1);

      for (int i = 0; i < nums.length; i++) {
         sum += nums[i];
         if (preSum.containsKey(sum - k)) {
            result += preSum.get(sum - k);
         }
         preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(subarraySum(new int[]{1,1,1}, 2));
   }
}
