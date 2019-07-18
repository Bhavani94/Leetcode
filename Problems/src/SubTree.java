public class SubTree {
   public static boolean isSubtree(TreeNode s, TreeNode t) {
      if(s == null)
         return false;
      if(sameTree(s, t))
         return true;

      return isSubtree(s.left, t) || isSubtree(s.right, t);
   }

   public static boolean sameTree(TreeNode s, TreeNode t) {
      if(s == null && t == null)
         return true;
      if(s == null || t == null || s.val != t.val)
         return false;
      return sameTree(s.left, t.left) && sameTree(s.right, t.right);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.right = new TreeNode(1);
      root.right.right = new TreeNode(1);
      root.right.right.right = new TreeNode(1);
      root.right.right.right.right = new TreeNode(1);
      root.right.right.right.right.right = new TreeNode(1);
      root.right.right.right.right.right.left = new TreeNode(2);
//      root.left.right = new TreeNode(4);
//      root.left.left = new TreeNode(2);

      TreeNode root1 = new TreeNode(1);
//      root1.left = new TreeNode(2);
      root1.right = new TreeNode(1);
      root1.right.left = new TreeNode(2);

      System.out.println(isSubtree(root, root1));
   }
}
