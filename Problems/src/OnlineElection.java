import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnlineElection {
   private Map<Integer, Integer> map = new HashMap<>();
   private int[] times;
   private OnlineElection(int[] persons, int[] times) {
      this.times = times;
      int[] count = new int[persons.length];
      int winner = -1;
      for(int i = 0; i < times.length; i++) {
         ++count[persons[i]];
         if(map.isEmpty() || count[persons[i]] > count[winner])
            winner = persons[i];
         map.put(times[i], winner);
      }
   }

   private int q(int t) {
      int index = Arrays.binarySearch(times, t);
      return map.get(times[index < 0 ? -index - 2 : index]);
   }

   public static void main(String[] args) {
      OnlineElection o = new OnlineElection(new int[]{0,1,1,0,0,1,0}, new int[]{0,5,10,15,20,25
            ,30});
      System.out.println(o.q(3));
      System.out.println(o.q(12));
   }
}
