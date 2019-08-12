import java.util.*;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0)
            return "";

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String ans = "";
        String[] words = paragraph.split(" ");

        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            int value;
            for(char c : word.toCharArray()) {
                if(!Character.isLetter(c)) {
                    break;
                }
                sb.append(Character.toLowerCase(c));
            }
            String wrd = sb.toString();
            if(sb.length() > 0 && !bannedSet.contains(wrd)) {
                map.put(wrd, map.getOrDefault(wrd, 0) + 1);
                value = map.get(wrd);
                if(value > max) {
                    max = value;
                    ans = wrd;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit." ,
                                           new String[]{"hit"}));
        System.out.println(mostCommonWord("Bob" ,
                new String[]{""}));
    }
}
