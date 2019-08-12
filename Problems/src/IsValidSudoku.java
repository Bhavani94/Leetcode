public class IsValidSudoku {
   private static boolean isValidSudoku(char[][] board) {
      if (board == null || board.length != 9)
         return false;

      boolean[][] row_seen = new boolean[9][9], col_seen = new boolean[9][9];
      boolean[][][] small_seen = new boolean[3][3][9];
      for(int i = 0; i < 9; i++) {
         if(board[i].length != 9)
            return false;
         for(int j = 0; j < 9; j++) {
            char current = board[i][j];
            if(current == '.')
               continue;
            if(!Character.isDigit(current) || current == '0')
               return false;

            int digitIndex = current - '0' - 1;
            if(row_seen[i][digitIndex])
               return false;
            row_seen[i][digitIndex] = true;

            if(col_seen[j][digitIndex])
               return false;
            col_seen[j][digitIndex] = true;

            int x = i / 3, y = j / 3;
            if(small_seen[x][y][digitIndex])
               return false;
            small_seen[x][y][digitIndex] = true;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(isValidSudoku(new char[][]{
            {'8','3','.','.','7','.','.','.','.'},
           {'6','.','.','1','9','5','.','.','.'},
           {'.','9','8','.','.','.','.','6','.'},
           {'8','.','.','.','6','.','.','.','3'},
           {'4','.','.','8','.','3','.','.','1'},
           {'7','.','.','.','2','.','.','.','6'},
           {'.','6','.','.','.','.','2','8','.'},
           {'.','.','.','4','1','9','.','.','5'},
           {'.','.','.','.','8','.','.','7','9'}}));
   }
}
