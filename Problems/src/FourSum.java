import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
   private static List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> result = new ArrayList<>();
      if(nums == null || nums.length < 4)
         return result;

      Arrays.sort(nums);
      int n = nums.length;
      for(int i = 0; i < n - 3; i++) {
         if(i > 0 && nums[i] == nums[i - 1])
            continue;

         for(int j = i + 1; j < n - 2; j++) {
            if(j > i + 1 && nums[j] == nums[j - 1])
               continue;

            int targerSum = target - nums[i] - nums[j];
            int minSum = nums[j + 1] + nums[ j + 2];
            int maxSum = nums[n - 1] + nums[ n - 2];

            if(targerSum < minSum || targerSum > maxSum)
               continue;

            int start = j + 1, end = n - 1;
            while(start < end) {
               int twoSum = nums[start] + nums[end];
               if(twoSum < targerSum) {
                  while(start < end && nums[start] == nums[start + 1])
                     start++;

                  start++;
               } else if(twoSum > targerSum) {
                  while(start < end && nums[end] == nums[end - 1])
                     end--;

                  end--;
               }else {
                  result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start],
                        nums[end])));

                  while(start < end && nums[start] == nums[start + 1])
                     start++;
                  while(start < end && nums[end] == nums[end - 1])
                     end--;

                  start++;
               }
            }
         }
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
   }
}
