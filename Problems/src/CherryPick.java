public class CherryPick {
   private static int cherryPickup(int[][] grid) {
      int n = grid.length;
      Integer[][][][] dp = new Integer[n][n][n][n];
      return Math.max(0, cherryPickHelper(grid, n, 0, 0, 0, 0, dp));
   }

   private static int cherryPickHelper(int[][] grid, int n, int r1, int c1, int r2, int c2,
                                       Integer[][][][] dp) {
      if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
         return Integer.MIN_VALUE;

      if(dp[r1][c1][r2][c2] != null)
         return dp[r1][c1][r2][c2];

      if(r1 == n - 1 && c1 == n - 1)
         return grid[r1][c1];

      if(r2 == n - 1 && c2 == n - 1)
         return grid[r2][c2];

      int cherries;
      if(r1 == r2 && c1 == c2)
         cherries = grid[r1][c1];
      else
         cherries = grid[r1][c1] + grid[r2][c2];

      // down, down
      // down, right
      // right, down
      // right, right
      cherries += Math.max(cherryPickHelper(grid, n, r1 + 1, c1, r2 + 1, c2, dp),
            Math.max(cherryPickHelper(grid, n, r1 + 1, c1, r2, c2 + 1, dp),
                  Math.max(cherryPickHelper(grid, n, r1, c1 + 1, r2 + 1, c2, dp),
                        cherryPickHelper(grid, n, r1, c1 + 1, r2, c2 + 1, dp))));
      dp[r1][c1][r2][c2] = cherries;

      return dp[r1][c1][r2][c2];
   }

   public static void main(String[] args) {
      System.out.println(cherryPickup(new int[][]{{0, 1, -1},
            {1, 0, -1},
            {1, 1,  1}}));
   }
}
