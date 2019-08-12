public class DecodeWays {
   private static int numDecodings(String s) {
      if(s == null || s.length() == 0)
         return 0;

      int n = s.length();
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = s.charAt(0) != '0' ? 1 : 0;
      for(int i = 2; i <= n; i++) {
         int oneNumber = Integer.valueOf(s.substring(i - 1, i));
         int twoNumber = Integer.valueOf(s.substring(i - 2, i));

         if(oneNumber >= 1 && oneNumber <= 9)
            dp[i] += dp[i - 1];

         if(twoNumber >= 10 && twoNumber <= 26)
            dp[i] += dp[i - 2];
      }
      return dp[n];
   }

   public static void main(String[] args) {
      System.out.println(numDecodings("226"));
   }
}
