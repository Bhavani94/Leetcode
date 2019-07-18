import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
   private static boolean canCross(int[] stones) {
      if(stones == null || stones.length == 0)
         return true;

      Map<Integer, Set<Integer>> map = new HashMap<>();
      for(int stone : stones) {
         map.put(stone, new HashSet<>());
      }
      map.get(stones[0]).add(1);
      int goal = stones[stones.length - 1];
      for(int stone : stones) {
         Set<Integer> steps = map.get(stone);
         for(int step : steps) {
            int reach = stone + step;
            if( reach == goal)
               return true;

            if(map.containsKey(reach)) {
               map.get(reach).add(step);
               if(step - 1 > 0)
                  map.get(reach).add(step - 1);
               map.get(reach).add(step + 1);
            }
         }
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
   }

}
