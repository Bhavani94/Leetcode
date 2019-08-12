public class Bipartite {
   private static boolean isBipartite(int[][] graph) {
      if(graph == null || graph.length == 0)
         return false;
      int n = graph.length;
      int[] colors = new int[n];

      for(int i = 0; i < n; i++) {
         if(colors[i] == 0 && !canColor(graph, colors, 1, i))
            return false;
      }
      return true;
   }

   private static boolean canColor(int[][] graph, int[] colors, int color, int node) {
      if(colors[node] != 0)
         return colors[node] == color;

      colors[node] = color;
      for(int next : graph[node]) {
         if(!canColor(graph, colors, -color, next))
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(isBipartite(new int[][]{{1,3}, {0,2}, {1,3}, {0,2}}));
      System.out.println(isBipartite(new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}}));
   }
}
