import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, lastOccurance = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                lastOccurance = Math.max(map.get(s.charAt(j)), lastOccurance);
            }
            ans = Math.max(ans, j - lastOccurance + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            String temp1 = find(s, i , i);
            String temp2 = find(s, i, i+1);
            temp1 = temp1.length() > temp2.length() ? temp1 : temp2;
            longest = temp1.length() > longest.length() ? temp1 : longest;
        }
        return longest;
    }

    private static String find(String s, int start, int end){
        int l = start;
        while(start >= 0  && end < s.length() && s.charAt(start) == s.charAt(end)){
            l = start;
            start--; end++;
        }
        return s.substring(l, end);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdedgh"));
        //System.out.println(longestPalindrome("babad"));
    }
}
