import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {
   private static Map<String, String> numberLetterMap = new HashMap<>();

   static {
      numberLetterMap.put("2", "abc");
      numberLetterMap.put("3", "def");
      numberLetterMap.put("4", "ghi");
      numberLetterMap.put("5", "jkl");
      numberLetterMap.put("6", "mno");
      numberLetterMap.put("7", "pqrs");
      numberLetterMap.put("8", "tuv");
      numberLetterMap.put("9", "wxyz");
   }

   private static List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();

      if(digits == null || digits.length() == 0 || (digits.length() == 1 && digits.charAt(0)==
            '1'))
         return result;

      letterCombinationsHelper(result, "", digits);
      return result;
   }

   private static void letterCombinationsHelper(List<String> result, String combination,
                                                String digits) {
      if(digits.length() == 0) {
         result.add(combination);
         return;
      }

      String digit = digits.substring(0, 1);
      String letters = numberLetterMap.get(digit);
      for(char c : letters.toCharArray()) {
         letterCombinationsHelper(result, combination + c, digits.substring(1));
      }
   }

   public static void main(String[] args) {
      System.out.println(letterCombinations("23"));
   }

}
