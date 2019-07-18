import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
   private static List<Integer> getRow(int rowIndex) {
      List<Integer> list = new ArrayList<>();
      if(rowIndex < 0)
         return list;

      while(rowIndex-- >= 0) {
      list.add(0, 1);
         for(int i = 1; i < list.size() - 1; i++) {
            list.set(i,list.get(i + 1) + list.get(i));
         }
      }

      return list;
   }

   private static List<List<Integer>> generate(int numRows) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      if(numRows < 0)
         return result;

      while(numRows-- >= 0) {
         list.add(0, 1);
         for(int i = 1; i < list.size() - 1; i++) {
            list.set(i,list.get(i + 1) + list.get(i));
         }
         result.add(new ArrayList<>(list));
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(getRow(3));
      System.out.println(getRow(1));
      System.out.println(getRow(0));
      System.out.println(generate(3));
   }
}
