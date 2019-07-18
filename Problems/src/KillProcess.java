import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KillProcess {
   private static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
      if(pid == null || ppid == null)
         return null;
      List<Integer> ans = new ArrayList<>();
      ans.add(kill);
      Map<Integer, Set<Integer>> map = new HashMap<>();

      for(int i = 0; i < pid.size(); i++) {
         map.putIfAbsent(ppid.get(i), new HashSet<>());
         map.get(ppid.get(i)).add(pid.get(i));
      }

      Queue<Integer> temp = new LinkedList<>();
      temp.add(kill);
      while (!temp.isEmpty()) {
         Set<Integer> t = map.get(temp.poll());
         if(t != null) {
            ans.addAll(t);
         }
      }
      return ans;
   }

   public static void main(String[] args) {
      System.out.println(killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5));
   }
}
