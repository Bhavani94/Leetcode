import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
   private static List<Integer> findAnagrams(String s, String t) {
      List<Integer> result = new LinkedList<>();
      if (t.length() > s.length())
         return result;

      Map<Character, Integer> map = new HashMap<>();
      for (char c : t.toCharArray()) {
         map.put(c, map.getOrDefault(c, 0) + 1);
      }

      // all chars in t should be used
      int remainingChars = map.size();
      int begin = 0, end = 0;

      while (end < s.length()) {
         char c = s.charAt(end);
         if (map.containsKey(c)) {
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0)
               remainingChars--;
         }
         end++;

         while (remainingChars == 0) { //all characters in t covered
            char tempc = s.charAt(begin);
            if (map.containsKey(tempc)) {
               map.put(tempc, map.get(tempc) + 1);
               if (map.get(tempc) > 0) {
                  remainingChars++;
               }
            }
            if (end - begin == t.length()) {
               result.add(begin);
            }
            begin++;
         }

      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(findAnagrams("ababa", "ab"));
      System.out.println(findAnagrams("cbaebabacd", "abc"));
   }
}
