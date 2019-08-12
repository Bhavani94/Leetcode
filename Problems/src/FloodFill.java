import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
   public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      if(image == null || image.length == 0)
         return null;
      if(image[sr][sc] == newColor)
         return image;

      int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      int currColor = image[sr][sc];
      int row = image.length, col = image[0].length;
      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[]{sr, sc});
      while (!queue.isEmpty()) {
         int[] curr = queue.poll();
         if (image[curr[0]][curr[1]] == currColor) {
            image[curr[0]][curr[1]]  = newColor;
            for (int[] d : dir) {
               int x = curr[0] + d[0];
               int y = curr[1] + d[1];
               if (x < 0 || y < 0 || x >= row || y >= col || image[x][y] != currColor)
                  continue;
               else {
                  queue.add(new int[]{x, y});
               }
            }
         }
      }
      return image;
   }

   public static int[][] floodFillRecursive(int[][] image, int sr, int sc, int newColor) {
      if(image == null || image.length == 0)
         return null;
      if(image[sr][sc] == newColor)
         return image;
      floodFillHelper(image, sr, sc, image[sr][sc], newColor);
      return image;
   }

   private static void floodFillHelper(int[][] image, int sr, int sc, int color, int newColor) {
      if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color)
         return;
      image[sr][sc] = newColor;
      floodFillHelper(image, sr + 1, sc ,color, newColor);
      floodFillHelper(image, sr - 1, sc ,color, newColor);
      floodFillHelper(image, sr, sc + 1 ,color, newColor);
      floodFillHelper(image, sr, sc - 1,color, newColor);
   }

   public static void main(String[] args) {
      int[][] ans = floodFill(new int[][]{ {1,1,1,}, {1,1,0}, {1,0,1}}, 1 ,1, 2);
      for(int i = 0; i < ans.length; i++) {
         System.out.println(Arrays.toString(ans[i]));
      }

      ans = floodFillRecursive(new int[][]{ {1,1,1,}, {1,1,0}, {1,0,1}}, 1 ,1, 2);
      for(int i = 0; i < ans.length; i++) {
         System.out.println(Arrays.toString(ans[i]));
      }
   }
}
