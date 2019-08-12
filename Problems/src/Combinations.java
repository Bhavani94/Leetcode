import java.util.ArrayList;
import java.util.List;

public class Combinations {
   private static List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> result = new ArrayList<>();
      if(n == 0 || k == 0)
         return result;
      combineHelper(n, k , result, new ArrayList<>(), 1);
      return result;
   }

   private static void combineHelper(int n, int k, List<List<Integer>> result,
                                     List<Integer> combination, int start) {
      if(k == 0) {
         result.add(new ArrayList<>(combination));
      } else {
         for (int i = start; i <= n; i++){
            combination.add(i);
            combineHelper(n, k - 1, result, combination, i + 1);
            combination.remove(combination.size() - 1);
         }
      }
   }

   public static void main(String[] args) {
      System.out.println(combine(4, 2));
   }
}
