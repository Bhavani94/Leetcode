public class SearchBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val? root.left:root.right;
        }
        return root;
    }

    public int closestValue(TreeNode root, double target) {
        int val = root.val;
        while (root != null){
            val = Math.abs(root.val - target) < Math.abs(val - target) ? root.val : val;
            root = root.val > target ? root.left : root.right;
        }
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(searchBST(root, 1));
    }
}
