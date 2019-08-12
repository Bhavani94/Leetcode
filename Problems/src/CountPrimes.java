public class CountPrimes {
   private static int countPrimes(int n) {
      int count = 0;
      for (int i = 2; i < n; i++) {
         boolean prime = true;
         for (int j = 2; j <= i / 2; j++) {
            if (i % j == 0) {
               prime = false;
               break;
            }
         }
         if (prime) count++;
      }
      return count;
   }

   private static int countPrimes1(int n) {
      int count = 0;
      boolean[] notPrime = new boolean[n];
      for (int i = 2; i < n; i++) {
         if (!notPrime[i]) {
            count++;
            for (int j = 2; i * j < n; j++)
               notPrime[i * j] = true;
         }
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(countPrimes(15));
      System.out.println(countPrimes1(15));
   }
}
