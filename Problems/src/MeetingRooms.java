import java.util.Arrays;

public class MeetingRooms {
   private static int minMeetingRooms(int[][] intervals) {
      if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
         return 0;

      int count = 0, n = intervals.length;
      int[] start = new int[n], end = new int[n];
      for(int i = 0; i < n; i++) {
         start[i] = intervals[i][0];
         end[i] = intervals[i][1];
      }

      Arrays.sort(start);
      Arrays.sort(end);

      int endInd = 0;
      for(int i = 0; i < n; i++) {
         // this meeting started before another meeting ended
         if(start[i] < end[endInd])
            count++;
         else
            endInd++;
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(minMeetingRooms(new int[][]{{1,5},{8,9},{8,9}}));
      System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
      System.out.println(minMeetingRooms(new int[][]{{6,15},{13,20},{6,17}}));
      System.out.println(minMeetingRooms(new int[][]{{2,15},{36,45},{9,29},{16,23},{4,9}}));
   }
}
