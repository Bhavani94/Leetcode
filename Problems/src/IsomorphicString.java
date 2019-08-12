import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
   private static boolean isIsomorphic(String s, String t) {
      if(s == null || t == null || s.length() != t.length())
         return false;
      Map<Character, Character> map = new HashMap<>();
      for(int i = 0; i < s.length(); i++) {
         char key = s.charAt(i), value = t.charAt(i);
         if(map.containsKey(key)) {
            if(value != map.get(key))
               return false;
         }else {
            if(map.containsValue(value))
               return false;
            map.put(key, value);
         }
      }
      return true;
   }
   private static boolean isIsomorphic1(String s, String t) {
      //same as above without hashmap
      if(s == null || t == null || s.length() != t.length())
         return false;
      int[] m1 = new int[256], m2 = new int[256];
      for(int i = 0; i < s.length(); i++) {
         if(m1[s.charAt(i)] != m2[t.charAt(i)])
            return false;
         m1[s.charAt(i)] = i + 1;
         m2[t.charAt(i)] = i + 1;
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(isIsomorphic("aa", "ab"));
      System.out.println(isIsomorphic1("aa", "ab"));
      System.out.println(isIsomorphic("ab", "aa"));
      System.out.println(isIsomorphic1("ab", "aa"));
      System.out.println(isIsomorphic("aac", "cca"));
      System.out.println(isIsomorphic1("aac", "cca"));
      System.out.println(isIsomorphic("paper", "tetle"));
      System.out.println(isIsomorphic1("paper", "title"));
   }
}
