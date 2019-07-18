public class SearchInRotatedSortedArrayII {
   private static boolean search(int[] nums, int target) {
      if(nums == null || nums.length == 0)
         return false;
      int start = 0, end = nums.length - 1;

      while(start <= end) {
         int mid = (start + end) / 2;

         if(nums[mid] == target)
            return true;

         if(nums[start] < nums[mid]) {
            if(target >= nums[start] && target < nums[mid]) {
               end = mid;
            } else
               start = mid + 1;
         }
         else if(nums[start] > nums[mid]) {
            if(target > nums[mid] && target <= nums[end])
               start = mid + 1;
            else
               end = mid;
         } else {
            start++;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(search(new int[]{1, 3, 1, 1, 1}, 3));
   }
}
