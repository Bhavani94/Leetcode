import java.util.ArrayList;
import java.util.List;

public class BoundaryBT {
   static List<Integer> result = new ArrayList<>();
   private static List<Integer> boundaryOfBinaryTree(TreeNode root) {
      if(root == null)
         return null;

      result.add(root.val);
      leftBoundary(root.left);
      leaves(root.left);
      leaves(root.right);
      rightBoundary(root.right);

      return result;
   }

   private static void leftBoundary(TreeNode root) {
      if(root == null || (root.left == null && root.right == null))
         return;
      result.add(root.val);
      if(root.left == null)
         leftBoundary(root.right);
      else
         leftBoundary(root.left);
   }

   private static void rightBoundary(TreeNode root) {
      if(root == null || (root.left == null && root.right == null))
         return;
      if(root.right == null)
         rightBoundary(root.left);
      else
         rightBoundary(root.right);
      result.add(root.val);
   }

   private static void leaves(TreeNode root) {
      if(root == null )
         return;
      if(root.left == null && root.right == null) {
         result.add(root.val);
         return;
      }

      leaves(root.left);
      leaves(root.right);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.left.left = new TreeNode(6);

      System.out.println(boundaryOfBinaryTree(root));
   }
}
