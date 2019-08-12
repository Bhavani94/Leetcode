import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringConcatenationOfAllWords {
   private static List<Integer> findSubstring(String s, String[] words) {
      List<Integer> indexes = new ArrayList<>();
      if(s.length() == 0 || words.length == 0)
         return indexes;

      Map<String, Integer> count = new HashMap<>();
      for(String word : words)
         count.put(word, count.getOrDefault(word, 0) + 1);

      int wordLen = words[0].length(), arrayLen = words.length;
      int window = wordLen * arrayLen;
      if(s.length() < window)
         return indexes;

      for(int i = 0; i < s.length() - window + 1; i++) {
         Map<String, Integer> seen = new HashMap<>();
         int start = i, currentWindow = i + window + 1;

         while(start + wordLen < currentWindow) {
            String current = s.substring(start, start + wordLen);
            if(count.containsKey(current)) {
               seen.put(current, seen.getOrDefault(current, 0) + 1);
               if (seen.get(current) > count.getOrDefault(current, 0))
                  break;
            } else {
               break;
            }
            start+= wordLen;
         }
         if(count.equals(seen))
            indexes.add(i);
      }
      return indexes;
   }

   public static void main(String[] args) {
      System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
      System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
      System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
   }
}
