import java.util.HashSet;
import java.util.Set;

public class WordBreak {
   public static boolean wordBreak(String s, Set<String> dict) {
      if(s == null || s.length() == 0)
         return false;
      int n = s.length();
      boolean[] dp = new boolean[n];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j <= i; j++) {
            String sub = s.substring(j, i + 1);
            if(dict.contains(sub) && (j == 0 || dp[j - 1])) {
               dp[i] = true;
               break;
            }
         }
      }
      return dp[n - 1];
   }

   public static void main(String[] args) {
      HashSet<String> dict = new HashSet<>();
      dict.add("apple"); dict.add("pen");
      System.out.println(wordBreak("applepenapple", dict));
   }
}
