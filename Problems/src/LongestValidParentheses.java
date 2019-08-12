import java.util.Stack;

public class LongestValidParentheses {
   private static int longestValidParentheses(String s) {
      if(s == null || s.length() == 0)
         return 0;

      Stack<Integer> stack = new Stack<>();
      stack.push(-1);
      int max = 0;
      char[] c = s.toCharArray();
      for(int i = 0; i < s.length(); i++) {
         if(c[i] == '(')
            stack.push(i);
         else {
            stack.pop();
            if (stack.isEmpty())
               stack.push(i);
            else
               max = Math.max(max, i - stack.peek());
         }
      }
      return max;
   }

   public static void main(String[] args) {
      System.out.println(longestValidParentheses("(()"));
      System.out.println(longestValidParentheses(")()())"));
      System.out.println(longestValidParentheses("()(()"));
   }
}
