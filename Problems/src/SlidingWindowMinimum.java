import java.util.HashMap;
import java.util.Map;

public class SlidingWindowMinimum {
   private static String minWindow(String s, String t) {
      if(s == null || s.length() == 0)
         return null;

      int count = t.length();
      Map<Character, Integer> tMap = new HashMap<>();
      for(char c : t.toCharArray())
         tMap.put(c, tMap.getOrDefault(c, 0) + 1);

      int left = 0, right = 0, minWindowSize = Integer.MAX_VALUE, start = 0;
      char[] str = s.toCharArray();

      while(right < s.length()) {
         if(tMap.containsKey(str[right])) {
            tMap.put(str[right], tMap.get(str[right]) - 1); // below 0 implies it can be found
            // towards right of left pointer
            if(tMap.get(str[right]) >= 0) { // > since t could contain repeated chars
               count--;
            }
         }
         while (count == 0) {
            if(right - left < minWindowSize) {
               minWindowSize = right - left;
               start = left; // start used for getting final string
            }

            if (tMap.containsKey(str[left])) {
               tMap.put(str[left], tMap.get(str[left]) + 1);
               if(tMap.get(str[left]) > 0)
                  count++;
            }
            left++;
         }
         right++;
      }

      return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindowSize);
   }

   public static void main(String[] args) {
      System.out.println(minWindow("aqweaqwebc", "ab"));
   }
}
