import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
   private static List<List<Integer>> levelOrder(TreeNode root) {
      if(root == null)
         return new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      List<List<Integer>> result = new ArrayList<>();

      queue.add(root);
      while(!queue.isEmpty()) {
         int size = queue.size();
         List<Integer> level = new ArrayList<>();
         for(int i = 0; i < size; i++) {
            TreeNode t = queue.poll();
            level.add(t.val);
            if(t.left != null)
               queue.add(t.left);
            if(t.right != null)
               queue.add(t.right);
         }

         result.add(level);
      }
      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);
      root.left.right = new TreeNode(4);
      root.left.left = new TreeNode(2);
      System.out.println(levelOrder(root));
   }
}
