import java.util.Arrays;

public class GameOfLife {
   private static int die = 2, live = 3;
   private static void gameOfLife(int[][] board) {
      int m = board.length, n = board[0].length;
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            int countNeighbour = getCount(board, i, j);
            if(board[i][j] == 0 && countNeighbour == 3)
               board[i][j] = live;
            else if(board[i][j] == 1 && (countNeighbour < 2 || countNeighbour > 3))
               board[i][j] = die;
         }
      }

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if(board[i][j] == die)
               board[i][j] = 0;
            else if(board[i][j] == live)
               board[i][j] = 1;
         }
      }

   }

   private static int getCount(int[][] board, int i, int j) {
      int count = 0;
      int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1,
            1}};

      for(int[] dir : dirs) {
         int x = i + dir[0];
         int y = j + dir[1];
         if( x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            continue;
         // live or was alive since computing in place
         if(board[x][y] == 1 || board[x][y] == die)
            count++;
      }
      return count;
   }

   public static void main(String[] args) {
      int[][] board = new int[][]{{0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}};
      gameOfLife(board);
      for (int i = 0; i < board.length; i++)
         System.out.println(Arrays.toString(board[i]));
   }
}
