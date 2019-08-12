public class MinAbsoluteDiffBST {
   static int min = Integer.MAX_VALUE, val = -1;
   private static int getMinimumDifference(TreeNode root) {
      // inorder gives sorted array
      if(root != null) {
         if(root.left != null)
            getMinimumDifference(root.left);
         if(val >= 0)
            min = Math.min(min, root.val - val);
         val = root.val;
         if(root.right != null)
            getMinimumDifference(root.right);
      }
      return min;
   }


   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);
      root.left.right = new TreeNode(4);
      root.left.left = new TreeNode(2);
      System.out.println(getMinimumDifference(root));
   }
}
