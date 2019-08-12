import java.util.Arrays;

public class MaximalSquares {
   private static int maximalSquare(char[][] matrix) {
      if(matrix == null || matrix.length == 0)
         return 0;

      int m = matrix.length, n = matrix[0].length;
      int[][] count = new int[m + 1][n + 1];
      int result = 0;
      for(int i = 1; i <= m; i++){
         for(int j = 1; j <= n; j++) {
            if(matrix[i - 1][j - 1] == '1') {
               count[i][j] = Math.min(Math.min(count[i - 1][j], count[i][j - 1]),
                     count[i - 1][j - 1]) + 1;
               result = Math.max(result, count[i][j]);
            }
         }
      }

      for(int i = 0; i < m + 1; i++)
         System.out.println(Arrays.toString(count[i]));
      return result * result;
   }

   public static void main(String[] args) {
      System.out.println(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'},
         {'1', '0', '1', '1', '1'},
         {'1', '1', '1', '1', '1'},
         {'1', '0', '0', '1', '0'}}));
   }
}
