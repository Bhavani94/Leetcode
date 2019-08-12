public class NonDecreasingArray {
   private static boolean checkPossibility(int[] nums) {
      int skipped = 0, prev = nums[0];

      for(int i = 1; i < nums.length; i++) {
         if(nums[i] < prev) {
            skipped++;
            if(skipped > 1)
               return false;
            if(i - 2 >= 0 && nums[i - 2] > nums[i])
               continue;
         }
         prev = nums[i];
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(checkPossibility(new int[]{3,4,2,3}));
      System.out.println(checkPossibility(new int[]{-1,4,2,3}));
      System.out.println(checkPossibility(new int[]{4,2,3}));
   }
}
