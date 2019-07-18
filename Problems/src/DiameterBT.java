public class DiameterBT {
   static int diameter;
   private static int diameterOfBinaryTree(TreeNode root) {
      diameter = 0;
      getDiameter(root);
      return diameter;
   }

   private static int getDiameter(TreeNode root) {
      if(root == null)
         return 0;

      int left_height = getDiameter(root.left);
      int right_height = getDiameter(root.right);

      diameter = Math.max(left_height + right_height, diameter);
      return Math.max(left_height, right_height) + 1;

   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(-10);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.right = new TreeNode(15);
      root.right.left = new TreeNode(7);
      System.out.println(diameterOfBinaryTree(root));
   }
}
