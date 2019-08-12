import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
   private static int[][] insert(int[][] intervals, int[] newInterval) {
      if(intervals == null || intervals.length == 0)
         return new int[][]{newInterval};

      List<int[]> list = new ArrayList<>();
      for(int i = 0; i < intervals.length; i++) {
         // non-overlap current starts later
         if(newInterval == null || intervals[i][1] < newInterval[0])
            list.add(intervals[i]);
         // non-overlap current interval completed
         else if(intervals[i][0] > newInterval[1]) {
            list.add(newInterval);
            newInterval = null;
            list.add(intervals[i]);
         } else {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
         }
      }

      if(newInterval != null)
         list.add(newInterval);

      int[][] result = new int[list.size()][2];
      for(int i = 0; i < list.size(); i++) {
         result[i] = new int[]{list.get(i)[0], list.get(i)[1]};
      }
      return result;
   }

   public static void main(String[] args) {
      int[][] intervals = insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
      for(int i = 0; i < intervals.length; i++)
         System.out.print(Arrays.toString(intervals[i]));

      System.out.println(" ");
      intervals = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
      for(int i = 0; i < intervals.length; i++)
         System.out.print(Arrays.toString(intervals[i]));

   }
}
