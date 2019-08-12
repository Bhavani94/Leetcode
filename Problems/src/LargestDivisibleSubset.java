import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
   private static List<Integer> largestDivisibleSubset(int[] nums) {
      List<Integer> result = new ArrayList<>();
      if(nums == null || nums.length == 0)
         return result;

      if(nums.length == 1) {
         result.add(nums[0]);
         return result;
      }
      Arrays.sort(nums);
      int[] dp = new int[nums.length], parent = new int[nums.length];
      Arrays.fill(dp, 1);
      Arrays.fill(parent, -1);

      //dp stores the largest path for element
      // for each dp store its parent
      int largest = 0, largestAt = 0;
      for(int i = 1; i < nums.length; i++) {
         for(int j = 0; j < i; j ++) {
            if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
               dp[i] = dp[j] + 1;
               parent[i] = j;
            }
            if(dp[i] > largest) {
               largestAt = i;
               largest = dp[i];
            }
         }
      }

      for(int i = 0; i < largest; i++) {
            result.add(0, nums[largestAt]);
            largestAt = parent[largestAt];
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(largestDivisibleSubset(new int[]{1,2,4,8,9,72}));
      System.out.println(largestDivisibleSubset(new int[]{2,3,8,9,27}));
   }
}
