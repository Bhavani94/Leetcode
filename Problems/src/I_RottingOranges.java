import java.util.LinkedList;
import java.util.Queue;

public class I_RottingOranges {
   private static int orangesRotting(int[][] grid) {
      if (grid == null || grid.length == 0)
         return 0;
      Queue<int[]> queue = new LinkedList<>();
      int row = grid.length, col = grid[0].length;
      int freshOranges = 0, count = 0;
      int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
      for (int i = 0; i < col; i++) {
         for (int j = 0; j < row; j++) {
            if (grid[i][j] == 1)
               freshOranges++;
            if (grid[i][j] == 2)
               queue.add(new int[]{i, j});
         }
      }

      if(freshOranges == 0)
         return 0;

      while(!queue.isEmpty()) {
         int size = queue.size();
         count++;
         for(int i = 0; i < size; i++) {
            int[] point = queue.poll();
            for(int[] d : dir) {
               int x = point[0] + d[0];
               int y = point[1] + d[1];

               if( x < 0 || y < 0 || x >= row || y >= col || grid[x][y] != 1)
                  continue;
               grid[x][y] = 2;
               freshOranges --;
               queue.add(new int[]{x,y});
            }
         }
      }

      return freshOranges == 0 ? count - 1: -1;
   }

   public static void main(String[] args) {
      System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
   }
}
