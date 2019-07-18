import java.util.ArrayList;
import java.util.List;

public class PartitionLables {
    private static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        char[] chars = S.toCharArray();
        for(int i = 0; i < S.length(); i++) {
            last[chars[i] - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int end = 0, max = 0;
        for(int i = 0; i < S.length(); i++) {
            max = Math.max(max, last[chars[i] - 'a']);
            if( i == max) {
                ans.add(max - end + 1);
                end = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
