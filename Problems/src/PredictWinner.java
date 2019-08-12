import java.util.Arrays;

public class PredictWinner {
   private static boolean predictTheWinner(int[] nums) {
      if (nums == null) {
         return true;
      }
      int n = nums.length;
      if ((n & 1) == 0) {
         return true;
      }
      int[] dp = new int[n];
      for (int i = n - 1; i >= 0; i--) {
         for (int j = i; j < n; j++) {
            if (i == j) {
               dp[i] = nums[i];
            } else {
               dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
         }
         System.out.println(Arrays.toString(dp));
      }
      return dp[n - 1] >= 0;
   }

   public static void main(String[] args) {
      System.out.println(predictTheWinner(new int[]{1, 5, 8, 7, 8}));
      System.out.println(predictTheWinner(new int[]{8, 5, 1, 7, 8}));
   }
}
