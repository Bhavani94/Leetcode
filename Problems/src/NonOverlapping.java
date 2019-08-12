import java.util.Arrays;
import java.util.PriorityQueue;

public class NonOverlapping {
   /*
   Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
    */
   private static int eraseOverlapIntervals(int[][] intervals) {
      // O(nlogn) O(n) space
      if(intervals == null || intervals.length == 0)
         return 0;

      PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
      for (int i = 0; i < intervals.length; i++)
         pq.add(intervals[i]);

      int count = 1, end = pq.poll()[1];
      while(!pq.isEmpty()) {
         int[] t = pq.poll();
//         System.out.println(t[0] + ", " + t[1]);
         if(t[0] >= end) {
            end = t[1];
            count++;
         }
      }
      return intervals.length - count;
   }

   private static int eraseOverlapIntervals1(int[][] intervals) {
      // O(nlogn) O(1) space
      if (intervals == null || intervals.length == 0)
         return 0;

      Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
      int count = 1, end = intervals[0][1];
      for (int i = 0; i < intervals.length; i++) {
         System.out.println(intervals[i][0] + ", " + intervals[i][1]);
         if (intervals[i][0] >= end) {
            end = intervals[i][1];
            count++;
         }
      }
      return intervals.length - count;
   }

   public static void main(String[] args) {
//      System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}}));
      System.out.println(eraseOverlapIntervals1(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}}));
   }
}
