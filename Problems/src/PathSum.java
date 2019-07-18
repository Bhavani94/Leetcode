import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        sum -= root.val;
        if(root.left == null && root.right == null)
            return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        pathSumIIHelper(root, path, sum, result);
        return result;
    }

    private static void pathSumIIHelper(TreeNode root, List<Integer> list, int sum, List<List<Integer>> result){
        if(root == null)
            return;

        list.add(root.val);
        sum -= root.val;

        if(root.left == null && root.right == null && sum == 0) {
            result.add(list);
            return;
        }

        pathSumIIHelper(root.left, new ArrayList<>(list), sum, result);
        pathSumIIHelper(root.right, new ArrayList<>(list), sum, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        System.out.println(hasPathSum(root, 15));

        System.out.println(pathSumII(root, 15));
    }
}
