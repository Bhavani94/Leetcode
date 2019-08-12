public class RangeBitwiseAND {
   // Find the bitwise AND of all numbers in this range, inclusive
   private static int rangeBitwiseAnd(int m, int n) {
      int i = 0; // how many digits were not same
      while(m != n) {
         m = m >> 1;
         n = n >> 1;
         i++;
      }
      return m << i;
   }

   public static void main(String[] args) {
      System.out.println(rangeBitwiseAnd(5, 7));
   }
}
