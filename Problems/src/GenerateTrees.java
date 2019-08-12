import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
   private static List<TreeNode> generateTrees(int n) {
      if(n == 0)
         return new ArrayList<>();
      return generateSubTrees(1, n);
   }

   private static List<TreeNode> generateSubTrees(int start, int end) {
      List<TreeNode> result = new ArrayList<>();
      if(start > end) {
         result.add(null);
         return result;
      }

      for(int i = start; i <= end; i++) {
         List<TreeNode> leftList = generateSubTrees(start, i - 1);
         List<TreeNode> rightList = generateSubTrees(i + 1, end);

         for(TreeNode left : leftList) {
            for(TreeNode right : rightList) {
               TreeNode root = new TreeNode(i);
               root.left = left;
               root.right = right;
               result.add(root);
            }
         }
      }
      return result;
   }

   public static void main(String[] args) {
      List<TreeNode> list = generateTrees(3);
      for(TreeNode root : list)
         System.out.print(I_PostorderTraversal.postorderTraversal(root));
   }
}
