import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PathsFromSourceToTarget {
   private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      if(graph == null || graph.length == 0 || graph[0].length == 0)
         return null;
      List<List<Integer>> result = new ArrayList<>();
      allPathsSourceTargetHelper(graph, new ArrayList<>(), result, 0);
      return result;
   }

   private static void allPathsSourceTargetHelper(int[][] graph, List<Integer> list,
                                                  List<List<Integer>> result, int index) {
      list.add(index);
      if(index == graph.length - 1) {
         result.add(new ArrayList<>(list));
      } else {
         for(int element : graph[index]) {
            allPathsSourceTargetHelper(graph, list, result, element);
            list.remove(list.size() - 1);
         }
      }
   }

   private static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
      Map<Integer, List<Integer>> graph = new HashMap<>();

      for (int[] edge : edges) {
         final List<Integer> adjList = graph.getOrDefault(edge[0], new ArrayList<>());
         adjList.add(edge[1]);
         graph.put(edge[0], adjList);
      }
      return leadsToDestinationHelper(graph, new HashSet<>(), source, destination);
   }

   private static boolean leadsToDestinationHelper(Map<Integer, List<Integer>> graph,
                                            Set<Integer> visited, int current, int dest) {
      if (!graph.containsKey(current))
         return current == dest;

      if (visited.contains(current)) {
         return false;
      }

      visited.add(current);

      for(int node : graph.get(current)) {
         if (!leadsToDestinationHelper(graph, visited, node, dest)) {
            return false;
         }
      }
      visited.remove(current);
      return true;
   }


   public static void main(String[] args) {
      System.out.println(allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}}));

      System.out.println(leadsToDestination(3, new int[][]{{0,1},{0,3}, {1, 2}, {2, 1}}, 0, 3));
      System.out.println(leadsToDestination(4, new int[][]{{0,1},{0,2}, {1,3},{2,3}}, 0, 3));
      System.out.println(leadsToDestination(3, new int[][]{{0,1},{0,2}}, 0, 1));
      System.out.println(leadsToDestination(4, new int[][]{{0,1},{0,2}, {1,3},{2,3}, {1,2}}, 0,
            3));
   }
}
