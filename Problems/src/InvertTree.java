public class InvertTree {
   private static TreeNode invertTree(TreeNode root) {
      if(root == null)
         return null;
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      invertTree(root.left);
      invertTree(root.right);

      return root;
   }

   public static void main(String[] args) {
      TreeNode root2 = new TreeNode(5);
      root2.left = new TreeNode(3);
      root2.right = new TreeNode(3);
      root2.left.left = new TreeNode(4);
      root2.left.right = new TreeNode(6);
      root2.right.left = new TreeNode(6);
      root2.right.right = new TreeNode(4);
      System.out.println(I_PostorderTraversal.postorderTraversal(invertTree(root2)));
   }
}
