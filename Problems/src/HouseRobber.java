public class HouseRobber {
   public static int rob(int[] nums) {
      if(nums == null || nums.length == 0)
         return 0;
      int f1 = 0, f2 = 0;
      for(int i : nums) {
         int temp = f1;
         f1 = Math.max(i + f2, f1);
         f2 = temp;
      }
      return f1;
   }

   public static void main(String[] args) {
      System.out.println(rob(new int[]{1,2,3,1}));
   }
}
