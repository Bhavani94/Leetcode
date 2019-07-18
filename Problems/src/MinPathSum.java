public class MinPathSum {
   private static int minPathSum(int[][] grid) {
      if(grid == null || grid.length == 0 || grid[0].length == 0)
         return 0;
      int m = grid.length, n = grid[0].length;
      int[][] dp = new int[m][n];
      for(int i = 0; i < m; i++) {
         for(int j = 0; j < n; j++) {
            if(i == 0 && j == 0)
               dp[i][j] = grid[i][j];
            else if(i == 0)
               dp[i][j] = grid[i][j] + dp[i][j - 1];
            else if(j == 0)
               dp[i][j] = grid[i][j] + dp[i - 1][j];
            else
               dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
         }
      }
      return dp[m - 1][n - 1];
   }

   public static void main(String[] args) {
      System.out.println(minPathSum(new int[][]{{1,3,1},
                                                {1,5,1},
                                                {4,2,1}}));
   }
}
