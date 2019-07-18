public class SearchMatrix {
   /*
   Integers in each row are sorted in ascending from left to right.
   Integers in each column are sorted in ascending from top to bottom.
    */

   private static boolean searchMatrix(int[][] matrix, int target) {
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
         return false;

      int m = matrix.length, n = matrix[0].length, i = m - 1, j = 0;
      while(i >= 0 && j < n) {
         if(matrix[i][j] == target)
            return true;
         else if(matrix[i][j] > target)
            i--;
         else
            j++;
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(searchMatrix(new int[][]{{1,  5,  9},
            {10, 11, 13},
            {12, 13, 15}}, 11));
   }
}
