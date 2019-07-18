import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
   /*
   No duplicates in candidates, a coin can be used any number of times
    */
   private static List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      if(candidates == null || candidates.length == 0)
         return result;
      Arrays.sort(candidates);
      combinationHelper(candidates, target, new ArrayList<>(), result, 0);
      return result;
   }

   private static void combinationHelper(int[] candidates, int target, List<Integer> combination,
                                         List<List<Integer>> result, int start) {
      if(target < 0)
         return;

      if(target == 0) {
         result.add(new ArrayList<>(combination));
      }

      for(int i = start; i < candidates.length; i++) {
         combination.add(candidates[i]);
         combinationHelper(candidates, target - candidates[i], combination, result, i);
         combination.remove(combination.size() - 1);
      }
   }

   //Duplicate coins and use each coin exactly once in a combination
   private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      if(candidates == null || candidates.length == 0 || target == 0)
         return result;
      Arrays.sort(candidates);
      combinationSum2Helper(candidates, target, new ArrayList<>(), result, 0);
      return result;
   }

   private static void combinationSum2Helper(int[] candidates, int target,
                                             List<Integer> combination,
                                             List<List<Integer>> result,
                                             int start) {
      if(target < 0)
         return;

      if(target == 0)
         result.add(new ArrayList<>(combination));

      for(int i = start; i < candidates.length; i++) {
         if(i > start && candidates[i] == candidates[i - 1])
            continue;
         combination.add(candidates[i]);
         combinationSum2Helper(candidates, target - candidates[i], combination, result, i + 1);
         combination.remove(combination.size() - 1);
      }
   }

   public static void main(String[] args) {
      System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
      System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
   }
}
