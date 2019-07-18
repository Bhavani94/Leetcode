import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
   private static List<Integer> spiralOrder(int[][] matrix) {
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
         return new ArrayList<>();

      List<Integer> result = new ArrayList<>();
      int rowMax = matrix.length - 1, colMax = matrix[0].length - 1, rowMin = 0,  colMin = 0;
      while(rowMin <= rowMax && colMin <= colMax) {
         for(int i = colMin; i <= colMax; i++) {
            result.add(matrix[rowMin][i]);
         }
         rowMin++;

         for(int i = rowMin; i <= rowMax; i++) {
            result.add(matrix[i][colMax]);
         }
         colMax--;

         if(rowMin > rowMax || colMin > colMax) break;

         for(int i = colMax; i >= colMin; i--) {
            result.add(matrix[rowMax][i]);
         }
         rowMax--;

         for(int i = rowMax; i >= rowMin; i--) {
            result.add(matrix[i][colMin]);
         }
         colMin++;
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}}));
   }
}
