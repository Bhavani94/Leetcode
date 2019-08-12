import java.util.Stack;

public class BasicCalculator {
   private static int calculateII(String s) {
      if(s == null || s.length() == 0)
         return 0;

      char sign = '+';
      int num = 0;
      Stack<Integer> stack = new Stack<>();
      for(int i = 0; i < s.length(); i++) {
         if(Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
         }

         if((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length() - 1) {
            if(sign == '-')
               stack.push(-num);
            else if (sign == '+')
               stack.push(num);
            else if (sign == '*')
               stack.push(stack.pop() * num);
            else if (sign == '/')
               stack.push(stack.pop() / num);

            sign = s.charAt(i);
            num = 0;
         }
      }

      int ans = 0;
      for(int i : stack)
         ans += i;

      return ans;
   }

   private static int calculate(String s) {
      if(s == null || s.length() == 0)
         return 0;

      int num = 0, result = 0, sign = 1;
      Stack<Integer> stack = new Stack<>();
      for(int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         if(Character.isDigit(c)) {
            num = num * 10 + (c - '0');
         } else if(c == '-') {
            result += sign * num;
            sign  = -1;
            num = 0;
         } else if (c == '+') {
            result += sign * num;
            num = 0;
            sign = 1;
         } else if (c == '(') {
            stack.push(result);
            stack.push(sign);
            sign = 1;
            result = 0;
         } else if (c == ')') {
            result += sign * num;
            num = 0;
            result *= stack.pop();
            result += stack.pop();
         }
      }

      if(num != 0)
         result += sign * num;
      return result;

   }

   public static void main(String[] args) {
      System.out.println(calculateII("3+2*2"));
      System.out.println(calculate("3+2+2"));
      System.out.println(calculate("(3+2)+2"));
      System.out.println(calculate("3+2-(2 + 2)"));
   }
}
