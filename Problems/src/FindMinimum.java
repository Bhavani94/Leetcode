public class FindMinimum {

   // find min in rotated sorted array
   private static int findMin(int[] nums) {
      if(nums == null || nums.length == 0)
         return 0;
      int start = 0, end = nums.length - 1;
      if(nums[0] < nums[end])
         return nums[0];

      while(start < end) {
         int mid = (start + end) / 2;
         if(mid > 0 && nums[mid - 1] > nums[mid])
            return nums[mid];
         //also works with if(nums[mid] > nums[end])
         if(nums[start] <= nums[mid] && nums[mid] > nums[end])
            start = mid + 1;
         else
            end = mid - 1;
      }
      return nums[start];
   }

   public static void main(String[] args) {
      System.out.println(findMin(new int[]{4,5,6,1,2,3}));
      System.out.println(findMin(new int[]{4,5,1,2,3}));
      System.out.println(findMin(new int[]{2, 1}));
   }
}
