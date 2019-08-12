import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
   private static boolean canFinish(int numCourses, int[][] prerequisites) {
      if(numCourses == 0 || prerequisites.length == 0)
         return true;

      int[] indegree = new int[numCourses];
      for(int i = 0; i < prerequisites.length; i++) {
         indegree[prerequisites[i][0]]++;
      }

      Queue<Integer> queue = new LinkedList<>();
      for(int i = 0; i < numCourses; i++) {
         if(indegree[i] == 0)
            queue.add(i);
      }

      int canFinishCount = queue.size();
      while(!queue.isEmpty()) {
         int course = queue.poll();
         for(int[] edge : prerequisites) {
            if(edge[1] == course) {
               indegree[edge[0]]--;
               if (indegree[edge[0]] == 0) {
                  canFinishCount++;
                  queue.add(edge[0]);
               }
            }
         }
      }
      return canFinishCount == numCourses;
   }

   private static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
      List<Integer>[] graph = new ArrayList[numCourses];
      for (int i = 0; i < numCourses; i++)
         graph[i] = new ArrayList<>();

      boolean[] visited = new boolean[numCourses];
      for (int i = 0; i < prerequisites.length; i++) {
         graph[prerequisites[i][1]].add(prerequisites[i][0]);
      }

      for (int i = 0; i < numCourses; i++) {
         if (!dfs(graph, visited, i))
            return false;
      }
      return true;
   }

   private static boolean dfs(List<Integer>[] graph, boolean[] visited, int course) {
      if (visited[course])
         return false;

      visited[course] = true;

      for (int neighbor : graph[course]) {
         if (!dfs(graph, visited, neighbor))
            return false;
      }
      visited[course] = false;
      return true;
   }

   public static void main(String[] args) {
      System.out.println(canFinish(3, new int[][]{{1,0},{0,1}}));
      System.out.println(canFinishDFS(3, new int[][]{{1,0},{1,2}}));
   }
}
