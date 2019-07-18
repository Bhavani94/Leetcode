public class ValidBST {
   private static boolean isValidBST(TreeNode root) {
      return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   private static boolean isValidBst(TreeNode root, int minVal, int maxVal){
      if(root == null)
         return true;
      if(root.val >= maxVal || root.val <= minVal)
         return false;
      return isValidBst(root.left, minVal, root.val) && isValidBst(root.right, root.val, maxVal);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.right = new TreeNode(7);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      System.out.println(isValidBST(root));

      TreeNode root1 = new TreeNode(5);
      root1.right = new TreeNode(5);
      System.out.println(isValidBST(root1));
   }
}
