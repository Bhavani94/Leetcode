public class StringToInteger {
   private static int myAtoi(String str) {
      if (str == null || str.length() == 0)
         return 0;
      int n = str.length(), base = 0;
      ;
      boolean startFlag = false;
      int sign = 1;
      for (int index = 0; index < n; index++) {
         char c = str.charAt(index);
         // skip white spaces
         if (!startFlag && c == ' ')
            continue;

         // find sign
         if (!startFlag && (c == '-' || c == '+')) {
            startFlag = true;
            sign = c == '-' ? -1 : 1;
            continue;
         }

         startFlag = true;

         // cant process characters
         if (!Character.isDigit(c))
            break;

         // check integer overflow
         if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && c - '0' > 7))
            return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

         base = base * 10 + (c - '0');
      }

      return base * sign;
   }

   public static void main(String[] args) {
      System.out.println(myAtoi("    -42 abc"));
      System.out.println(myAtoi("    "));
      System.out.println(myAtoi("-+1"));
   }
}
