public class MaxDepth {
    private static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int l_height = maxDepth(root.left);
        int r_height = maxDepth(root.right);

        return Math.max(l_height, r_height) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(maxDepth(root));
    }
}
