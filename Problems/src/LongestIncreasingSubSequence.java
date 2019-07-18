import java.util.Arrays;

public class LongestIncreasingSubSequence {
   private static int lengthOfLIS(int[] nums) {
      if(nums == null || nums.length == 0)
         return 0;
      int[] maxLen = new int[nums.length];
      int result = 1;
      Arrays.fill(maxLen, 1);

      for(int i = 1; i < nums.length; i++) {
         for(int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
               maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
            }
         }
         result = Math.max(result, maxLen[i]);
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
   }
}
