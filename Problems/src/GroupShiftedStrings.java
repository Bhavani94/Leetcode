import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
   /*
   Given a list of strings which contains only lowercase alphabets,
   group all strings that belong to the same shifting sequence.
   "abc" -> "bcd" -> ... -> "xyz"
    */

   private static List<List<String>> groupStrings(String[] strings) {
      if(strings == null || strings.length == 0)
         return new ArrayList<>();

      Map<String, List<String>> map = new HashMap<>();
      for(String str : strings) {
         String key = getKey(str);
         List<String> values = map.getOrDefault(key, new ArrayList<>());
         values.add(str);
         map.put(key, values);
      }
      return new ArrayList<>(map.values());
   }

   private static String getKey(String s) {
      char[] c = s.toCharArray();
      String key = "";
      for(int i = 1; i < c.length; i++) {
         int diff = c[i - 1] - c[i];
         diff = diff > 0 ? diff : diff + 26;
         key += diff + "*";
      }
      return key;
   }

   public static void main(String[] args) {
      System.out.println(groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
   }
}
