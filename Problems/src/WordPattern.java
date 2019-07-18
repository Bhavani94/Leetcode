import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
   private static boolean wordPattern(String pattern, String str) {
      if(pattern == null || str == null || pattern.length() == 0 || str.length() == 0)
         return false;
      String[] words = str.split(" ");

      if(pattern.length() != words.length)
         return false;

      Map<Character, Integer> patternMap = new HashMap<>();
      Map<String, Integer> wordMap = new HashMap<>();
      for(int i = 0; i < pattern.length(); i++) {
         if(!Objects.equals(patternMap.put(pattern.charAt(i), i), wordMap.put(words[i], i)))
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(wordPattern("abba", "dog cat cat dog"));
      System.out.println(wordPattern("abba", "dog dog dog dog"));
      System.out.println(wordPattern("abc", "b c a"));
   }
}
