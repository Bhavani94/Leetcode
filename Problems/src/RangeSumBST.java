public class RangeSumBST {
   private static int rangeSumBST(TreeNode root, int L, int R) {
      if(root == null)
         return 0;

      if(root.val > R)
         return rangeSumBST(root.left, L, R);
      if(root.val < L)
         return rangeSumBST(root.right, L, R);
      return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);
      root.left.right = new TreeNode(4);
      root.left.left = new TreeNode(2);
      System.out.println(rangeSumBST(root, 3, 5));
   }
}
