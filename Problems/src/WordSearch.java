public class WordSearch {
   /*
   The word can be constructed from letters of sequentially adjacent cell,
   where "adjacent" cells are those horizontally or vertically neighboring.
   The same letter cell may not be used more than once.
    */
   private static boolean exist(char[][] board, String word) {
      if(board == null || board.length == 0 || board[0].length == 0)
         return false;

      for(int i = 0; i < board.length; i++) {
         for(int j = 0; j < board[i].length; j++)
            if(existHelper(board, word, i, j, 0))
               return true;
      }
      return false;
   }

   private static boolean existHelper(char[][] board, String word, int i, int j, int index) {
      if(index == word.length())
         return true;

      if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(index))
         return false;

      board[i][j] = '*';
//      board[i][j] ^= 256;
      boolean result = existHelper(board, word, i + 1, j, index + 1) ||
            existHelper(board, word, i , j + 1, index + 1) ||
            existHelper(board, word, i - 1, j, index + 1) ||
            existHelper(board, word, i, j - 1, index + 1);

      board[i][j] = word.charAt(index);
//      board[i][j] ^= 256;
      return result;
   }

   public static void main(String[] args) {
      char[][] board = new char[][]{{'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}};
      System.out.println(exist(board, "ABCCED"));
      System.out.println(exist(board, "SEE"));
      System.out.println(exist(board, "ABCB"));
   }
}
