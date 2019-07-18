import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplacePattern {
   private static List<String> findAndReplacePattern(String[] words, String pattern) {
      if(words == null || words.length == 0 || pattern == null || pattern.length() == 0)
         return new ArrayList<>();
      List<String> result = new ArrayList<>();
      List<Integer> pat = getPattern(pattern);

      for(String word : words ) {
         List<Integer> tempPat = getPattern(word);
         if(tempPat.equals(pat))
            result.add(word);
      }
      return result;
   }

   private static List<Integer> getPattern(String word) {
      Map<Character, Integer> map = new HashMap<>();
      List<Integer> pattern = new ArrayList<>();
      for(char c : word.toCharArray()) {
         map.putIfAbsent(c, map.size());
         pattern.add(map.get(c));
      }
      return pattern;
   }

   public static void main(String[] args) {
      System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}
      , "abb"));
   }
}
