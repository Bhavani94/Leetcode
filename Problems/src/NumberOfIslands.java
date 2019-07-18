import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    static int[][] g;
    private static int numIslands(int[][] grid) {
        g = grid;
        int islands = 0;
        final Set<String> set = new HashSet<>();
        for(int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    islands += find(i, j, "o", sb);
                    set.add(sb.toString());
                }
            }
        }
        System.out.println(set);
        return set.size();
//        return islands;
    }

    private static int find(int row, int col, String dir, StringBuilder sb) {
        if(row < 0 || row == g.length || col < 0 || col == g[0].length || g[row][col] == 0)
            return 0;
        g[row][col] = 0;
        sb.append(dir);
        find(row + 1, col, "d", sb);
        find(row - 1, col, "u", sb);
        find(row, col + 1, "r", sb);
        find(row, col - 1, "l", sb);
        sb.append("b");
        return 1;
    }

    public static void main(String[] args) {
        int[][] g = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,1,1}
        };
        System.out.println(numIslands(g));
    }
}
