public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null || p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelp(root, root);
    }

    public static boolean isSymmetricHelp(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null || p.val != q.val)
            return false;

        return isSymmetricHelp(p.left, q.right) && isSymmetricHelp(q.left, p.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.right = new TreeNode(4);
        root1.left.left = new TreeNode(2);
        System.out.println(isSameTree(root, root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(4);
        System.out.println(isSymmetric(root2));
    }
}
