import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT {
   private static String serialize(TreeNode root) {
      StringBuilder ans = new StringBuilder();
      serializeHelper(root, ans);
      return ans.toString();
   }

   private static void serializeHelper(TreeNode root, StringBuilder result) {
      if(root == null) {
         result.append("null").append(" ");
         return;
      }

      result.append(root.val).append(" ");
         serializeHelper(root.left, result);
         serializeHelper(root.right, result);
   }

   private static TreeNode deserialize(String data) {
      if (data.isEmpty())
         return null;
      Queue<String> queue = new LinkedList<>(Arrays.asList(data.trim().split(" ")));
      return deserializeHelper(queue);
   }

   private static TreeNode deserializeHelper(Queue<String> queue) {
      if (!queue.isEmpty() && queue.peek().equals("null")) {
         queue.remove();
         return null;
      }

      TreeNode root = new TreeNode(Integer.parseInt(queue.remove()));
      root.left = deserializeHelper(queue);
      root.right = deserializeHelper(queue);

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
