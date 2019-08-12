public class Divide {
   private static int divide(int dividend, int divisor) {
      if(divisor == 0)
         return Integer.MAX_VALUE;
      long result = divideLong(dividend, divisor);
      return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
   }

   private static long divideLong(long dividend, long divisor) {
      boolean negative = dividend < 0 != divisor < 0;

      if(dividend < 0)
         dividend = -dividend;
      if(divisor < 0)
         divisor = -divisor;

      if (dividend < divisor)
         return 0;

      long sum = divisor, divideTimes = 1;

      while((sum + sum) <= dividend) {
         sum += sum;
         divideTimes += divideTimes;
      }

      return negative ? -(divideTimes + divideLong(dividend - sum, divisor)) :
            (divideTimes + divideLong(dividend - sum, divisor));
   }

   public static void main(String[] args) {
      System.out.println(divide(25, 5));
      System.out.println(divide(10, 5));
   }
}
