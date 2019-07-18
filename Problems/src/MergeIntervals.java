import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    private static class Intervals {
        int start;
        int end;

        public Intervals(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<Intervals> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Intervals(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).end >= list.get(i + 1).start) {
                list.get(i).end = Math.max(list.get(i).end, list.get(i + 1).end);
                list.remove(i + 1);
                i--;
            }
        }

        int r = 0;
        int k = 0;
        int[][] ans = new int[list.size()][2];
        for (Intervals j : list) {
            r = 0;
            ans[k][r++] = j.start;
            ans[k++][r] = j.end;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ans = merge(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}});
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println("");
        }
    }
}
