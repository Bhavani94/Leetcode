import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
   private static List<Integer> selfDividingNumbers(int left, int right) {
      List<Integer> result = new ArrayList<>();
      for(int i = left; i <= right; i++) {
         if(isSelfDividing(i))
            result.add(i);
      }
      return result;
   }

   private static boolean isSelfDividing(int num) {
      if(num == 0)
         return false;
      int n = num;
      while(num > 0) {
         int digit = num % 10;
         if(digit == 0 || n % digit != 0)
            return false;
         num /= 10;
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(selfDividingNumbers(5, 15));
      System.out.println(selfDividingNumbers(1, 22));
   }
}
