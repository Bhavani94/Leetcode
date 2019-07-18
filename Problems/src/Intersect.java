import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {
   private static int[] intersect(int[] nums1, int[] nums2) {
      if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
         return new int[0];
      Map<Integer, Integer> map = new HashMap<>();
      for(int i : nums1)
         map.put(i, map.getOrDefault(i, 0) + 1);
      List<Integer> result = new ArrayList<>();

      for(int i : nums2) {
         if(map.containsKey(i) && map.get(i) > 0) {
            result.add(i);
            map.put(i, map.get(i) - 1);
         }
      }

      int[] ans = new int[result.size()];
      int j = 0;
      for(int i : result)
         ans[j++] = i;
      return ans;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(intersect(new int[]{1,2,1}, new int[]{2,2})));
      System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));
   }
}
