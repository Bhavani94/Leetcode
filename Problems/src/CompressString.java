public class CompressString {
   private static int compress(char[] chars) {
      if(chars == null || chars.length == 0)
         return 0;
      int updatingIndex = 0, count = 1;
      for(int i = 1; i <= chars.length; i++) {
         if(i < chars.length && chars[i - 1] == chars[i]) {
            count++;
         } else {
            chars[updatingIndex++] = chars[i - 1];
            if(count != 1) {
               // if count is 2 digit
               for(char c : String.valueOf(count).toCharArray())
                  chars[updatingIndex++] = c;
            }
            count = 1;
         }
      }
      return updatingIndex;
   }

   public static void main(String[] args) {
      System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
   }
}
