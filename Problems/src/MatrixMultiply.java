import java.util.Arrays;

public class MatrixMultiply {
   private static int[][] multiply(int[][] A, int[][] B) {
      if(A == null || B == null || A.length == 0 || B.length == 0)
         return null;

      int m = A.length, nA = A[0].length, nB = B[0].length;
      int[][] C = new int[m][nB];
      // multiplication not possible
      if(nA != B.length)
         return null;

      for(int i = 0; i < m; i++) {
         for(int j = 0; j < nA; j++) {
            // update all indexes that use A[i][]
            if(A[i][j] != 0) {
               for(int bj = 0; bj < nB; bj++) {
                  if(B[j][bj] != 0) {
                     C[i][bj] += A[i][j] * B[j][bj];
                  }
               }
            }
         }
      }
      return C;

   }

   public static void main(String[] args) {
      int[][] A = new int[][]{{ 1, 0, 0}, {-1, 0, 3}};
      int[][] B = new int[][]{{ 7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
      int[][] C = multiply(A, B);
      for(int i = 0; i < C.length; i++) {
         System.out.println(Arrays.toString(C[i]));
      }
   }
}
