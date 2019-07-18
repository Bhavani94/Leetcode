import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LCA {
   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null || p == null || q == null)
         return null;

      if(p == q)
         return p;

      Map<TreeNode, TreeNode> parent = new HashMap<>();
      Deque<TreeNode> queue = new LinkedList<>();
      queue.push(root);
      parent.put(root, null);

      while(!parent.containsKey(p) || !parent.containsKey(q)) {
         TreeNode node = queue.pop();
         if(node.left != null) {
            parent.put(node.left, node);
            queue.push(node.left);
         }

         if(node.right != null) {
            parent.put(node.right, node);
            queue.push(node.right);
         }
      }

      Set<TreeNode> ancestors = new HashSet<>();
      while(p != null) {
         ancestors.add(p);
         p = parent.get(p);
      }

      while(!ancestors.contains(q)) {
         q = parent.get(q);
      }

      return q;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);
      root.left.right = new TreeNode(4);
      root.left.left = new TreeNode(2);
      System.out.println(lowestCommonAncestor(root, root.left, root.left.right).val);
   }
}
