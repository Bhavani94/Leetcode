import java.util.Stack;

public class DecodeString {
   private static String decodeString(String s) {
      if(s == null || s.length() == 0)
         return "";
      Stack<StringBuilder> resStack  = new Stack<>();
      Stack<Integer> countStack = new Stack<>();
      StringBuilder sb = new StringBuilder();
      int i = 0;
      while(i < s.length()) {
         if(Character.isDigit(s.charAt(i))) {
            int count = 0;
            while(Character.isDigit(s.charAt(i))) {
               count = count * 10 + (s.charAt(i) - '0');
               i++;
            }
            countStack.push(count);
         } else if(s.charAt(i) == '[') {
            resStack.push(sb);
            sb = new StringBuilder();
            i++;
         } else if(s.charAt(i) == ']') {
            StringBuilder temp = resStack.pop();
            int count = countStack.pop();
            while(count-- > 0) {
               temp.append(sb);
            }
            sb = temp;
            i++;
         } else
            sb.append(s.charAt(i++));

      }
      return sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(decodeString("2[abc]3[cd]ef"));
   }
}
