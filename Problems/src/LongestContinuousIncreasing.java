public class LongestContinuousIncreasing {
   private static int findLengthOfLCIS(int[] nums) {
      if(nums == null || nums.length == 0)
         return 0;

      int longest = 1, max = 1, prev = nums[0];
      for(int i = 1; i< nums.length; i++) {
         if(nums[i] > prev) {
            longest++;
            max = Math.max(longest, max);
         } else
            longest = 1;
         prev = nums[i];
      }
      return max;
   }

   public static void main(String[] args) {
      System.out.println(findLengthOfLCIS(new int[]{1,3,5,4,7}));
   }
}
