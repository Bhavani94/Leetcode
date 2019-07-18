import java.util.Arrays;

public class PrisionCells {
   public static int[] prisonAfterNDays(int[] cells, int N) {
      if (cells == null || cells.length == 0)
         return null;

      int[] firstDay = new int[cells.length], nextDay = new int[cells.length];
      for(int day = 0; N-- > 0; day++) {
         for(int i = 1; i < cells.length - 1; i++) {
            nextDay[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
         }
         if(day == 0) {
            firstDay = nextDay.clone();
         }
         else if(Arrays.equals(firstDay, nextDay))
            N %= day;
         cells = nextDay.clone();
      }

      return cells;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7)));
   }
}
