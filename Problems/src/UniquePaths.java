public class UniquePaths {
   private static int uniquePaths(int m, int n) {
      int[][] grid = new int[m][n];
      for(int i = 0 ; i < m; i++)
         grid[i][0] = 1;

      for(int i = 0 ; i < n; i++)
         grid[0][i] = 1;

      for(int i = 1; i < m; i++) {
         for(int j = 1; j < n ; j++) {
            grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
         }
      }
      return grid[m - 1][n - 1];
   }

   private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int m = obstacleGrid.length, n = obstacleGrid[0].length;

      for(int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if(obstacleGrid[i][j] == 1)
               obstacleGrid[i][j] = 0;
            else if(i == 0 && j == 0)
               obstacleGrid[i][j] = 1;
            else if(i == 0)
               obstacleGrid[i][j] = obstacleGrid[i][j - 1];
            else if(j == 0)
               obstacleGrid[i][j] = obstacleGrid[i - 1][j];
            else
               obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
         }
      }

      return obstacleGrid[m - 1][n - 1];
   }

   public static void main(String[] args) {
      System.out.println(uniquePaths(3, 4));
      System.out.println(uniquePathsWithObstacles(new int[][] {{0,0,0},
                                                               {0,1,0},
                                                               {0,0,0}}));
   }
}
