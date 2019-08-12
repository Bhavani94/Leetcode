import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {
   private static class Cell {
      int row;
      int col;
      int height;

      Cell(int row, int col, int height) {
         this.row = row;
         this.col = col;
         this.height = height;
      }
   }
   private static int trapRainWater(int[][] heightMap) {
      if(heightMap == null || heightMap.length == 0)
         return 0;
      PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
         @Override
         public int compare(Cell o1, Cell o2) {
            return o1.height - o2.height;
         }
      });

      int m = heightMap.length, n = heightMap[0].length;
      boolean[][] visited = new boolean[m][n];

      // Initially, add all the Cells which are on borders to the queue.
      for(int i = 0; i < m; i++) {
         visited[i][0] = true;
         visited[i][n - 1] = true;
         pq.offer(new Cell(i, 0, heightMap[i][0]));
         pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
      }

      for(int i = 0; i < n; i++) {
         visited[0][i] = true;
         visited[m - 1][i] = true;
         pq.offer(new Cell(0, i, heightMap[0][i]));
         pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
      }

      int res = 0;
      int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
      // from the borders, pick the shortest cell visited and check its neighbors:
      // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
      // add all its neighbors to the queue.
      while(!pq.isEmpty()) {
         Cell cell = pq.poll();
         for(int[] dir : dirs) {
            int x = cell.row + dir[0];
            int y = cell.col + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y])
               continue;
            visited[x][y] = true;
            res += Math.max(0, cell.height - heightMap[x][y]);
            pq.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
         }
      }
      return res;
   }

   public static void main(String[] args) {
      System.out.println(trapRainWater(new int[][]{
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}}));
   }
}
