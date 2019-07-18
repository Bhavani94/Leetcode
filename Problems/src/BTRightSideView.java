import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {
   private static List<Integer> rightSideView(TreeNode root) {
      // level order traversal + add only right most element
      if(root == null)
         return new ArrayList<>();

      Queue<TreeNode> queue = new LinkedList<>();
      List<Integer> result = new ArrayList<>();
      queue.add(root);

      while(!queue.isEmpty()) {
         int size = queue.size();
         for(int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if(i == size - 1)
               result.add(node.val);
            if(node.left != null)
               queue.add(node.left);
            if(node.right != null)
               queue.add(node.right);
         }
      }
      return result;
   }

   private static List<Integer> rightSideViewRecursive(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      rightSideViewHelper(root, result, 0);
      return result;
   }

   private static void rightSideViewHelper(TreeNode root, List<Integer> result, int level) {
      if(root == null)
         return;

      if(level == result.size())
         result.add(root.val);

      rightSideViewHelper(root.right, result, level + 1);
      rightSideViewHelper(root.left, result, level + 1);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);
//      root.left.right = new TreeNode(4);
      root.left.left = new TreeNode(2);
      System.out.println(rightSideView(root));
      System.out.println(rightSideViewRecursive(root));
   }
}
