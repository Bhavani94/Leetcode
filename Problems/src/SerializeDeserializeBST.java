import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST {
   private static String serialize(TreeNode root) {
      StringBuilder ans = new StringBuilder();
      serializeHelper(root, ans);
      return ans.toString();
   }

   private static void serializeHelper(TreeNode root, StringBuilder result) {
      if(root == null)
         return;

      result.append(root.val).append(" ");
      if(root.left != null)
         serializeHelper(root.left, result);
      if(root.right != null)
         serializeHelper(root.right, result);
   }

   private static TreeNode deserialize(String data) {
      if (data.isEmpty())
         return null;
      Queue<String> queue = new LinkedList<>(Arrays.asList(data.trim().split(" ")));
      return deserializeHelper(queue, Integer.MAX_VALUE, Integer.MIN_VALUE);
   }

   private static TreeNode deserializeHelper(Queue<String> queue, int max, int min) {
      if (queue.isEmpty())
         return null;
      int val = Integer.parseInt(queue.peek());
      if(val > max || val < min)
         return null;
      queue.poll();
      TreeNode root = new TreeNode(val);
      root.left = deserializeHelper(queue, val, min);
      root.right = deserializeHelper(queue, max, val);
      return root;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(40);
      root.left = new TreeNode(20);
      root.left.left = new TreeNode(10);
      root.left.right = new TreeNode(30);
      root.left.right.right = new TreeNode(35);

      root.right = new TreeNode(60);
      root.right.left = new TreeNode(50);
      root.right.right = new TreeNode(70);

      String serializedTree = serialize(root);
      System.out.println(serializedTree);

      TreeNode deserializedTree = deserialize(serializedTree);
      System.out.println(serialize(deserializedTree));

      serializedTree = serialize(null);
      System.out.println(serializedTree);

      deserializedTree = deserialize(serializedTree);
      System.out.println(serialize(deserializedTree));
   }
}
