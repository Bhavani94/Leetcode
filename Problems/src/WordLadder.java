import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
   private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (beginWord.equals(endWord) || !wordList.contains(endWord))
         return 0;
      Set<String> wordSet = new HashSet<>(wordList);
      int d = 1;
      Set<String> visitedWords = new HashSet<>();
      visitedWords.add(beginWord);
      Set<String> permuteWords;

      while (!visitedWords.isEmpty()) {
         d++;
         permuteWords = new HashSet<>();
         for (String word : visitedWords) {
            for (int i = 0; i < word.length(); i++) {
               char[] ch = word.toCharArray();
               for (char c = 'a'; c <= 'z'; c++) {
                  ch[i] = c;
                  String str = new String(ch);
                  if (str.equals(endWord))
                     return d;
                  if (wordSet.contains(str)) {
                     permuteWords.add(str);
                     wordSet.remove(str);
                  }
               }
            }
         }
         visitedWords = permuteWords;
      }
      return -1;
   }


   public static void main(String[] args) {
      System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log",
            "cog")));
      System.out.println(ladderLength("abc", "cba", Arrays.asList("abc","azc","adc", "aba","aaa",
            "cba")));
   }

}
