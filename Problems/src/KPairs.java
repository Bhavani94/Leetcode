import java.util.HashMap;
import java.util.Map;

public class KPairs {
   /*
   ind the number of unique k-diff pairs in the array.
   Here a k-diff pair is defined as an integer pair (i, j), where i and j are both
   numbers in the array and their absolute difference is k.
    */
   private static int findPairs(int[] nums, int k) {
      if(nums == null || nums.length == 0 || k < 0)
         return 0;

      int count = 0;
      Map<Integer, Integer> map = new HashMap<>();
      for(int i : nums)
         map.put(i, map.getOrDefault(i, 0) + 1);

      for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
         if(k == 0) {
            if(entry.getValue() >= 2)
               count++;
         } else {
            if(map.containsKey(entry.getKey() + k))
               count++;
         }
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
      System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
   }
}
