public class MergeTrees {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);

        TreeNode t = mergeTrees(root, root);
        I_PostorderTraversal p = new I_PostorderTraversal();
        System.out.println(p.postorderTraversal(t));

    }
}
