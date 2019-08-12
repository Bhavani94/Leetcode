public class CoinChange {
   private static int coinChange(int[] coins, int amount) {
      // dp
      if(amount == 0)
         return 0;

      int[] minCoins = new int[amount + 1];
      for(int sum = 1; sum <= amount; sum++) {
         minCoins[sum] = Integer.MAX_VALUE;
         for(int coin : coins) {
            if(coin <= sum && minCoins[sum - coin] != Integer.MAX_VALUE) {
               minCoins[sum] = Math.min(minCoins[sum], 1 + minCoins[sum - coin]);
            }
         }
      }
      return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
   }

   private static int coinChangeBackTracking(int[] coins, int amount) {
      if (amount < 1)
         return 0;
      return coinChangeHelper(coins, amount, new int[amount]);

   }

   private static int coinChangeHelper(int[] coins, int amount, int[] count) {
      if(amount < 0)
         return -1;
      if(amount == 0)
         return 0;

      if(count[amount - 1] != 0)
         return count[amount - 1];

      int min = Integer.MAX_VALUE;

      for(int coin : coins) {
         int rem = coinChangeHelper(coins, amount - coin, count);
         if(rem >= 0 && rem < min) {
            min = 1 + rem;
         }
      }

      count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
      return count[amount - 1];
   }

   public static void main(String[] args) {
      System.out.println(coinChangeBackTracking(new int[]{1 ,2}, 2));
      System.out.println(coinChange(new int[]{1 ,2, 5, 6}, 11));
      System.out.println(coinChangeBackTracking(new int[]{1 ,2, 5, 6}, 11));
   }
}
