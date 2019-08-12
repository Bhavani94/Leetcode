import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
   private static List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();
      if(n == 0)
         return result;
      helper(result, "", 0, 0, n);
      return result;
   }

   private static void helper(List<String> result, String curr, int open, int close, int max) {
      if(curr.length() == 2 * max) {
         result.add(curr);
         return;
      }

      if(open < max)
         helper(result, curr + "(", open + 1, close, max);
      if(close < open)
         helper(result, curr + ")", open, close + 1, max);
   }

   public static void main(String[] args) {
      System.out.println(generateParenthesis(3));
   }
}
