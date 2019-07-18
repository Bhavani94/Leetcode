public class BstFromArray {
   /*
   Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    */
   private static TreeNode sortedArrayToBST(int[] nums) {
      if(nums == null || nums.length == 0)
         return null;
      TreeNode root = sortedArrayToBSTHelper(nums, 0, nums.length - 1);
      return root;
   }

   private static TreeNode sortedArrayToBSTHelper(int[] nums, int min, int max) {
      if(min > max)
         return null;
      int mid = min + (max - min) / 2;
      TreeNode root = new TreeNode(nums[mid]);
      root.left = sortedArrayToBSTHelper(nums, min, mid - 1);
      root.right = sortedArrayToBSTHelper(nums, mid + 1, max);
      return root;
   }

   public static void main(String[] args) {
      TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});
      I_PostorderTraversal p = new I_PostorderTraversal();
      System.out.println(p.postorderTraversal(root));
   }
}
