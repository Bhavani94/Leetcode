public class TrimBST {
   private static TreeNode trimBST(TreeNode root, int L, int R) {
      if(root == null)
         return null;

      if(root.val < L)
         return trimBST(root.right, L, R);
      if(root.val > R)
         return trimBST(root.left, L, R);

      root.left = trimBST(root.left, L, R);
      root.right = trimBST(root.right, L, R);
      return root;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.right = new TreeNode(7);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root = trimBST(root, 2, 3);
      System.out.println(I_PostorderTraversal.postorderTraversal(root));
   }
}
