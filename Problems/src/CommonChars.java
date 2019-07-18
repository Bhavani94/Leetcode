import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonChars {
   private static List<String> commonChars(String[] words) {
      if(words == null || words.length == 0)
         return new ArrayList<>();
      List<String> result = new ArrayList<>();
      Map<Character, Integer> map = new HashMap<>();
      for(char c : words[0].toCharArray())
         map.put(c, map.getOrDefault(c, 0) + 1);

      for(int i = 1; i < words.length; i++) {
         Map<Character, Integer> tempMap = new HashMap<>();

         for(char c : words[i].toCharArray()) {
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
         }

         for(char key : map.keySet()) {
            int min = Math.min(tempMap.getOrDefault(key, 0), map.get(key));
            map.put(key, min);
         }
      }

      for(char key : map.keySet()) {
         for(int k = 0; k < map.get(key); k++)
            result.add(key + "");
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(commonChars(new String[]{"bella","label","roller"}));
   }
}
