public class Islands {
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int sum = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    sum++;
                    visitIsland(grid, i, j);
                }
            }
        }
        return sum;
    }

    private static void visitIsland(char[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        visitIsland(grid, i - 1 , j);
        visitIsland(grid, i + 1 , j);
        visitIsland(grid, i , j + 1);
        visitIsland(grid, i , j - 1);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int max = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(maxArea(grid, i, j), max);
                }
            }
        }
        return max;
    }

    private static int maxArea(int[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        return 1 + maxArea(grid, i - 1 , j) + maxArea(grid, i + 1 , j) + maxArea(grid, i , j + 1) + maxArea(grid, i , j - 1);
    }


    public static int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int edges = 0, centers = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    edges++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        centers++;
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
                        centers++;
                }
            }
        }
        return 4 * edges - 2 * centers;
    }


    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{ {'1', '1', '1', '1', '0'},
                                                    {'1', '1', '0', '1', '0'},
                                                    {'1', '1', '0', '0', '0'},
                                                    {'0', '0', '0', '0', '0'} }));
        System.out.println(numIslands(new char[][]{ {'1', '1', '1', '1'},
                                                    {'0', '1', '0', '0'},
                                                    {'1', '1', '1', '1'} }));

        System.out.println(maxAreaOfIsland(new int[][]{ {1, 1, 1, 1},
                                                        {0, 0, 0, 0},
                                                        {1, 1, 1, 1} }));

        System.out.println(islandPerimeter(new int[][]{ {1, 1, 1, 1},
                                                        {0, 1, 0, 0},
                                                        {1, 1, 1, 1} }));
    }
}
