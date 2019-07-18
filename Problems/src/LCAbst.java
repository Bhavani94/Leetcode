public class LCAbst {
   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null || q == null || p == null)
         return null;

      if((p.val < root.val && q.val < root.val))
         return lowestCommonAncestor(root.left, p, q);
      else if(p.val > root.val && q.val > root.val)
         return lowestCommonAncestor(root.right, p , q);
      else
         return root;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(1);
      root.right = new TreeNode(8);
      root.right.right = new TreeNode(10);
      root.right.left = new TreeNode(7);
      System.out.println(lowestCommonAncestor(root, root.left.left, root.right.right).val);
   }
}
