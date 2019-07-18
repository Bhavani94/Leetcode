public class CountOnes {
   private static int hammingWeight(int n) {
      int ones = 0;
      while (n != 0) {
         ones += n & 1;
         n = n >> 1;
      }
      return ones;
   }

   public static void main(String[] args) {
      System.out.println(hammingWeight(00000000000000000000000010000000));
   }
}
