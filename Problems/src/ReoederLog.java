import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReoederLog {
   public static String[] reorderLogFiles(String[] logs) {
      if(logs == null || logs.length == 0)
         return new String[0];

      PriorityQueue<String> pq = new PriorityQueue<String>((s1, s2) -> {
         String[] split1 = s1.split(" ", 2);
         String[] split2 = s2.split(" ", 2);
         int comp = split2[1].compareTo(split1[1]);
         if(comp != 0)
            return comp;
         else
            return split2[0].compareTo(split1[0]);
      });

      LinkedList<String> ans = new LinkedList<>();
      for(String log : logs) {
         String[] temp = log.split(" ", 2);
         if(Character.isDigit(temp[1].charAt(0)))
            ans.add(log);
         else
            pq.add(log);
      }

      while(!pq.isEmpty())
         ans.addFirst(pq.poll());

      return ans.stream().toArray(n -> new String[n]);
   }

   public static void main(String[] args) {
      List<String> input = new ArrayList<>();
      input.add("mi2 jog mid pet");
      input.add("wz3 34 54 398");
      input.add("a1 alps cow bar");
      input.add("a1 alps cow car");
      input.add("x4 45 21 7");
      System.out.println(Arrays.toString(reorderLogFiles(input.stream().toArray(n -> new String[n]))));
      System.out.println(Arrays.toString(reorderLogFiles(input.stream().toArray(n -> new String[n]))));
   }
}
