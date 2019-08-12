public class PerfectNumber {
   /*
   Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
    */
   private static boolean checkPerfectNumber(int num) {
      if(num == 1)
         return false;
      int sum = 1, n;
      for(n = 2; n <= Math.sqrt(num); n++) {
         if(num % n == 0)
            sum += n + num / n;
      }
      return sum == num;
   }

   public static void main(String[] args) {
      System.out.println(checkPerfectNumber(28));
      System.out.println(checkPerfectNumber(24));
   }
}
