public class SumOfLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null)
            return 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(4);
        System.out.println(sumOfLeftLeaves(root));
    }
}
