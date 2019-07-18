import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
   private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<List<Integer>> result = new ArrayList<>();

      if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0)
         return result;

      // sort pq by sum. each record has (nums1, nums2, indexOfnums2)
      PriorityQueue<List<Integer>> pq =
            new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));

      // nums2[0] with all elements of nums1
      for(int i : nums1) {
         pq.offer(Arrays.asList(i, nums2[0], 0));
      }

      while(k-- > 0 && !pq.isEmpty()) {
         // top always has smallest sum
         List<Integer> current = pq.poll();
         result.add(Arrays.asList(current.get(0), current.get(1)));
         int index = current.get(2);
         // if next index in num2 is possible add it pq and try again.
         if(index == nums2.length - 1)
            continue;

         pq.offer(Arrays.asList(current.get(0), nums2[index + 1], index + 1));
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
   }
}
