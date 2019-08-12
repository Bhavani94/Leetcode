import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
   static class UndirectedGraphNode {
      public int val;
      private List<UndirectedGraphNode> neighbors;

      private UndirectedGraphNode(int _val, List<UndirectedGraphNode> _neighbors) {
         val = _val;
         neighbors = _neighbors;
      }
   }

   private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      if(node == null)
         return null;
      Map<Integer, UndirectedGraphNode> map = new HashMap<>();
      return dfs(node, map);
   }

   private static UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer,
         UndirectedGraphNode> map) {
      if(node == null)
         return null;

      if(map.containsKey(node.val))
         return map.get(node.val);

      UndirectedGraphNode copy = new UndirectedGraphNode(node.val, new ArrayList<>());
      map.put(node.val, copy);
      for(UndirectedGraphNode next : node.neighbors) {
         copy.neighbors.add(dfs(next, map));
      }
      return copy;
   }

   public static void main(String[] args) {
      UndirectedGraphNode node1 = new UndirectedGraphNode(1, new ArrayList<>());
      UndirectedGraphNode node2 = new UndirectedGraphNode(2, new ArrayList<>());
      UndirectedGraphNode node3 = new UndirectedGraphNode(3, new ArrayList<>());
      UndirectedGraphNode node4 = new UndirectedGraphNode(4, new ArrayList<>());
      node1.neighbors.add(node2);
      node1.neighbors.add(node4);
      node2.neighbors.add(node1);
      node2.neighbors.add(node3);
      node3.neighbors.add(node2);
      node3.neighbors.add(node4);
      node4.neighbors.add(node1);
      node4.neighbors.add(node3);
      UndirectedGraphNode copy = cloneGraph(node1);
   }

}
