import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
   private static List<List<Integer>> largeGroupPositions(String s) {
      List<List<Integer>> result = new ArrayList<>();
      if(s == null || s.length() < 3)
         return result;

      int n = s.length(), start;
      for(int i = 0; i < n - 1; i++) {
         start = i;
         while(i < n - 1 && s.charAt(i) == s.charAt(i + 1))
            i++;
         if(i + 1 - start >= 3)
            result.add(Arrays.asList(start, i));
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(largeGroupPositions("abbxxxxzzy"));
      System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
   }
}
