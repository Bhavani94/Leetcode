public class LongestIncreasingPathInMatrix {
   static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
   private static int longestIncreasingPath(int[][] matrix) {
      if(matrix == null || matrix.length == 0)
         return 0;

      int[][] distance = new int[matrix.length][matrix[0].length];
      int maxPathLen = 0;
      for(int i = 0; i < matrix.length; i++) {
         for(int j = 0; j < matrix[0].length; j++) {
            int pathLen  = getPathLen(matrix, i, j, distance);
            maxPathLen = Math.max(maxPathLen, pathLen);
         }
      }
      return maxPathLen;
   }

   private static int getPathLen(int[][] matrix, int row, int col, int[][] distance) {
      if(distance[row][col] != 0)
         return distance[row][col];

      int max = 1;
      for(int[] dir : dirs) {
         int x = row + dir[0];
         int y = col + dir[1];

         if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[row][col])
            continue;

         int len = 1 + getPathLen(matrix, x, y, distance);
         max = Math.max(max, len);
      }
      distance[row][col] = max;
      return max;
   }

   public static void main(String[] args) {
      System.out.println(longestIncreasingPath(new int[][]{
            {9,9,4},
            {6,6,8},
            {2,1,1}
      }));
   }
}
