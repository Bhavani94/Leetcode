public class MaxProductSubArray {
   private static int maxProduct(int[] nums) {
      if(nums == null || nums.length == 0)
         return 0;

      int max = nums[0], imax = 1, imin = 1;
      for(int i = 0; i < nums.length; i++) {
         if(nums[i] < 0) {
            int temp = imax;
            imax = imin;
            imin = temp;
         }
         imax = Math.max(nums[i], imax * nums[i]);
         imin = Math.min(nums[i], imin * nums[i]);

         max = Math.max(max, imax);
      }
      return max;
   }

   public static void main(String[] args) {
      System.out.println(maxProduct(new int[]{2,3,-2,4}));
      System.out.println(maxProduct(new int[]{-2,0,-1}));
   }
}
