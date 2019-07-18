import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindDuplicateFile {
   private static List<List<String>> findDuplicate(String[] paths) {
      List<List<String>> ans = new ArrayList<>();
      if(paths == null || paths.length == 0)
         return ans;

      Map<String, Set<String>> map = new HashMap<>();
      for(String path : paths) {
         String[] strs = path.split(" ");
         for(int i = 1; i < strs.length; i++) {
            int idx = strs[i].indexOf("(");
            String content = strs[i].substring(idx);
            String filename = strs[0] + "/" + strs[i].substring(0, idx);
            Set<String> filenames = map.getOrDefault(content, new HashSet<>());
            filenames.add(filename);
            map.put(content, filenames);
         }
      }
      for(String key : map.keySet()) {
         Set<String> values = map.get(key);
         if(values.size() > 1)
            ans.add(new ArrayList<>(values));
      }
      return ans;
   }

   public static void main(String[] args) {
      System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3" +
            ".txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
   }
}
