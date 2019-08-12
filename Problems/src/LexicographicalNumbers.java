import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
   private static List<Integer> lexicalOrder(int n) {
      List<Integer> result = new ArrayList<>();
      formSeries(result, 1, n);
      return result;
   }

   private static void formSeries(List<Integer> result, int i, int n) {
      if(i > n)
         return;
      result.add(i);
      formSeries(result,i * 10, n);

      if(i % 10 != 9)
         formSeries(result, i + 1, n);
   }

   public static void main(String[] args) {
      System.out.println(lexicalOrder(13));
      System.out.println(lexicalOrder(2));
   }
}
