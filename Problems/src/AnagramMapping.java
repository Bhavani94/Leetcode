import java.util.*;

public class AnagramMapping {
    private static int[] anagramMappings(int[] A, int[] B) {
        int[] ans = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<B.length; i++)
            map.put(B[i], i);
        for (int i=0; i<A.length; i++)
            ans[i] = map.get(A[i]);
        return ans;
    }

    private static boolean isAnagram(String s, String t) {
        StringBuilder sb = new StringBuilder(t);
        for(char c : s.toCharArray()){
            int ind = sb.indexOf(Character.toString(c));
            if(ind == -1)
                return false;
            sb.deleteCharAt(ind);
        }
        return sb.length() == 0;
    }

    private static boolean isAnagram1(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (table[t.charAt(i) - 'a']-- < 0) {
                return false;
            }
        }
        return true;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        int[] val = new int[26];
        for(String s : strs){
            Arrays.fill(val, 0);
            for(char c: s.toCharArray())
                val[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for(int i : val){
                sb.append('#');
                sb.append(i);
            }
            String key = sb.toString();
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50,
              12, 32, 46, 28})));

        System.out.println(isAnagram1("tar", "rat"));

        System.out.println(groupAnagrams(new String[]{"cat", "tac", "rat", "tar"}));
    }
}
