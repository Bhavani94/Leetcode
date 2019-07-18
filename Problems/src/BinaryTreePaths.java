import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
   private static List<String> binaryTreePaths(TreeNode root) {
      if(root == null)
         return new ArrayList<>();
      ArrayList<String> result = new ArrayList<>();
      binaryTreePathsHelper(root, "", result);
      return result;
   }

   private static void binaryTreePathsHelper(TreeNode root, String path,
                                             ArrayList<String> result) {
      if(root == null)
         return;

      if(root.left == null && root.right == null)
         result.add(path + root.val);

      binaryTreePathsHelper(root.left, path + root.val + "->" , result);
      binaryTreePathsHelper(root.right, path + root.val + "->" , result);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.left.left = new TreeNode(6);

      System.out.println(binaryTreePaths(root));
   }
}
