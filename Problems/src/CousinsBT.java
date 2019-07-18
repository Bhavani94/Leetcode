import java.util.LinkedList;
import java.util.Queue;

public class CousinsBT {
   private static boolean isCousins(TreeNode root, int x, int y) {
      if(root == null)
         return false;
      TreeNode xParent = null, yParent = null;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while(!queue.isEmpty()) {
         int size = queue.size();

         for(int i = 0; i < size; i++) {
            TreeNode node = queue.poll();

            if(node.left != null) {
               queue.add(node.left);
               if(node.left.val == x)
                  xParent = node;
               if(node.left.val == y)
                  yParent = node;
            }

            if(node.right != null) {
               queue.add(node.right);
               if(node.right.val == x)
                  xParent = node;
               if(node.right.val == y)
                  yParent = node;
            }

            if(yParent != null && xParent != null)
               break;
         }

         if(xParent != null && yParent != null)
            return xParent != yParent;
         if(xParent != null || yParent != null)
            return false;
      }
      return false;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);
      root.right.right = new TreeNode(4);
      root.left.left = new TreeNode(2);
      System.out.println(isCousins(root, 2, 4));
      System.out.println(isCousins(root, 3, 7));
   }
}
