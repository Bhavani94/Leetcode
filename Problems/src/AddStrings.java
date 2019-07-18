public class AddStrings {
   private static String addStrings(String num1, String num2) {
      if(num1 == null || num2 == null)
         return "";
      int carry = 0, i = num1.length() - 1, j = num2.length() - 1;;
      StringBuilder sum = new StringBuilder();
      char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
      for(; i >= 0 && j >= 0; i--, j--) {
         int add = Character.getNumericValue(n1[i]) + Character.getNumericValue(n2[j]) + carry;
         sum.append(add % 10);
         carry = add / 10;
      }

      while(i >= 0) {
         int add = Character.getNumericValue(n1[i]) + carry;
         sum.append(add % 10);
         carry = add / 10;
         i--;
      }

      while(j >= 0) {
         int add = Character.getNumericValue(n2[j]) + carry;
         sum.append(add % 10);
         carry = add / 10;
         j--;
      }

      if(carry > 0)
         sum.append(carry);
      return sum.reverse().toString();
   }

   public static void main(String[] args) {
      System.out.println(addStrings("123", "178"));
      System.out.println(addStrings("123", "78"));
      System.out.println(addStrings("999", "999"));
   }
}
