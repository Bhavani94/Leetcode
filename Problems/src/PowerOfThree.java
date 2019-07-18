public class PowerOfThree {
   private static boolean isPowerOfThree(int n) {
      if(n == 0)
         return false;

      while(n % 3 == 0) {
         n /= 3;
      }

      return n == 1;
   }

   private static boolean isPowerOfThreeLogMethod(int n) {
      if(n == 0)
         return false;

      double y = Math.log10(n) / Math.log10(3);

      // check y is whole number
      return y % 1 == 0;
   }

   public static void main(String[] args) {
      System.out.println(isPowerOfThree(8));
      System.out.println(isPowerOfThree(9));
      System.out.println(isPowerOfThreeLogMethod(9));
      System.out.println(isPowerOfThreeLogMethod(16));

   }
}
