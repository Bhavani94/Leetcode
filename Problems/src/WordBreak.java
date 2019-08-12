import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
   private static boolean wordBreak(String s, Set<String> dict) {
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

   private static List<String> wordBreakII(String s, List<String> wordDict) {
      List<String> result = new ArrayList<>();
      if(s == null || s.length() == 0)
         return result;
      Set<String> set = new HashSet<>(wordDict);
      Map<String, List<String>> map = new HashMap<>();
      result = wordBreakIIHelper(s, set, map);
      return result;
   }

   private static List<String> wordBreakIIHelper(String s, Set<String> set,
                                         Map<String, List<String>> map) {
      List<String> res = new ArrayList<>();
      if(s == null || s.length() == 0)
         return res;
      if(map.containsKey(s))
         return map.get(s);
      if(set.contains(s))
         res.add(s);

      for(int i = 1; i < s.length(); i++) {
         String end = s.substring(i);
         if(set.contains(end)){
            List<String> temp = wordBreakIIHelper(s.substring(0, i), set, map);
            if(temp.size() != 0)
               for(int j = 0; j < temp.size(); j++)
                  res.add(temp.get(j) + " " + end);
         }
      }
      map.put(s, res);
      System.out.println(map);
      return res;
   }

   public static void main(String[] args) {
      HashSet<String> dict = new HashSet<>();
      dict.add("apple"); dict.add("pen");
      System.out.println(wordBreak("applepenapple", dict));

      List<String> wordDict = new ArrayList<>();
      wordDict.add("cats");
      wordDict.add("cat");
      wordDict.add("and");
      wordDict.add("sand");
      wordDict.add("dog");
      System.out.println(wordBreakII("catsanddog", wordDict));
   }
}
