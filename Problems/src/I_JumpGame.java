public class I_JumpGame {
   private static boolean canJump(int[] nums) {
      if(nums == null || nums.length == 0)
         return false;
      int maxCanReach = 0;
      for(int i = 0; i < nums.length; i++) {
         if(i > maxCanReach)
            return false;
         maxCanReach = Math.max(i + nums[i], maxCanReach);
      }
      return true;
   }

   private static int jumpII(int[] A) {
      int jumps = 0, curEnd = 0, curFarthest = 0;
      for (int i = 0; i < A.length - 1; i++) {
         curFarthest = Math.max(curFarthest, i + A[i]);
         if (i == curEnd) {
            jumps++;
            curEnd = curFarthest;
         }
      }
      return jumps;
   }

   public static void main(String[] args) {
      System.out.println(canJump(new int[]{3,2,1,0,4}));
      System.out.println(canJump(new int[]{2,3,1,1,4}));
      System.out.println(jumpII(new int[]{2,4,1,1,4}));
   }
}
