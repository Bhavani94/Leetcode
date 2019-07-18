import java.util.*;

public class I_PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private static void postorderHelper(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null)
                postorderHelper(root.left, result);
            if (root.right != null)
                postorderHelper(root.right, result);
            result.add(root.val);
        }
    }

    private static List<Integer> postorderTraversalIterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        System.out.println(postorderTraversal(root));
    }
}
