import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {
   private static String countOfAtoms(String formula) {
      Map<String, Integer> map = new TreeMap<>();
      Stack<Map<String, Integer>> stack = new Stack<>();
      char[] exp = formula.toCharArray();
      int i = 0, n = formula.length();

      while (i < n) {
         if (exp[i] == '(') {
            stack.push(map);
            map = new TreeMap<>();
            i++;
         } else if (exp[i] == ')') {
            int count = 0;
            i++;
            while (i < n && Character.isDigit(exp[i])) {
               count = count * 10 + exp[i] - '0';
               i++;
            }
            count = count == 0 ? 1 : count;

            if (!stack.isEmpty()) {
               Map<String, Integer> temp = map;
               map = stack.pop();

               for (String atom : temp.keySet()) {
                  map.put(atom, temp.get(atom) * count + map.getOrDefault(atom, 0));
               }
            }
         } else {
            int end = i + 1;
            while (end < n && Character.isLowerCase(exp[end])) {
               end++;
            }

            String atom = formula.substring(i, end);

            int count = 0;
            while (end < n && Character.isDigit(exp[end])) {
               count = count * 10 + (exp[end] - '0');
               end++;
            }
            count = count == 0 ? 1 : count;
            map.put(atom, map.getOrDefault(atom, 0) + count);
            i = end;
         }
      }

      StringBuilder sb = new StringBuilder();

      for (String atom : map.keySet()) {
         sb.append(atom);
         sb.append(map.get(atom) == 1 ? "" : map.get(atom));
      }
      return sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(countOfAtoms("Mg(OH)2"));
      System.out.println(countOfAtoms("H2O"));
      System.out.println(countOfAtoms("HO2"));
      System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
   }
}