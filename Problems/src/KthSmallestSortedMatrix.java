public class KthSmallestSortedMatrix {
   private static int kthSmallest(int[][] matrix, int k) {
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k == 0)
         return 0;

      int n = matrix.length;
      int lo = matrix[0][0], hi = matrix[n - 1][n - 1];

      while(lo <= hi) {
         int mid = lo + (hi - lo) / 2;
         int count = getLessEqual(matrix, mid);
         if(count < k)
            lo = mid + 1;
         else
            hi = mid - 1;
      }

      return lo;
   }

   private static int getLessEqual(int[][]matrix, int val) {
      int n = matrix.length, i = n - 1, j = 0, res = 0;
      while(i >= 0 && j < n) {
         if(matrix[i][j] > val)
            i--;
         else {
            j++;
            // all elements to top are smaller than val
            res += i + 1;
         }
      }
      return res;
   }

   public static void main(String[] args) {
      System.out.println(kthSmallest(new int[][]{{1,  5,  9},
                                                 {10, 11, 13},
                                                 {12, 13, 15}}, 8));
   }
}
