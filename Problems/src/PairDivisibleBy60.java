import java.util.HashMap;
import java.util.Map;

public class PairDivisibleBy60 {
   private static int numPairsDivisibleBy60(int[] time) {
      if(time == null || time.length == 0)
         return 0;
      int count = 0;
      Map<Integer, Integer> map = new HashMap<>();
      System.out.println("time    rem      (60 - rem) % 60");
      for(int i = 0; i < time.length; i++) {
         int rem = time[i] % 60;
         System.out.println(time[i] + " " + rem + " " + (60 - rem) % 60);
         count += map.getOrDefault((60 - rem) % 60, 0);
         map.put(rem, map.getOrDefault(rem, 0) + 1);
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,140}));
      System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
   }
}
