public class MaxPathSum {
    static int max = Integer.MIN_VALUE;
    private static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    private static int maxPathSumHelper(TreeNode root) {
        if(root == null)
            return 0;

        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);

        max = Math.max(max, leftSum + rightSum + root.val);

        return Math.max(0, Math.max(leftSum, rightSum) + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}
