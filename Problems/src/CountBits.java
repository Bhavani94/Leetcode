import java.util.Arrays;

public class CountBits {
   /*
   Given a non negative integer number num.
   For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in
   their binary representation and return them as an array.
    */
   private static int[] countBits(int num) {
      int[] f = new int[num + 1];
      for (int i = 1; i <= num; i++)
         f[i] = f[i >> 1] + (i & 1);
      return f;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(countBits(8)));
   }
}
