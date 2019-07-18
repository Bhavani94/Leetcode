import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SerializeDeserializeNArrayTree {
   private static String serialize(Node root) {
      if (root == null)
         return "";

      StringBuilder result = new StringBuilder();
      serializeHelper(root, result);
      return result.toString().trim();
   }

   private static void serializeHelper(Node root, StringBuilder result) {
      if (root == null)
         return;

      result.append(root.val).append(" ");
      if(root.children != null && !root.children.isEmpty()) {
         result.append("[").append(" ");
         for(Node c : root.children)
            serializeHelper(c, result);
         result.append("]").append(" ");
      }
   }

   // Decodes your encoded data to tree.
   private static Node deserialize(String data) {
      if(data == null || data.length() == 0)
         return null;
      String[] strs = data.split(" ");
      Stack<Node> stack = new Stack<>();
      Node root = new Node(Integer.parseInt(strs[0]), new ArrayList<Node>());
      Node current = root;
      for(int i = 1; i < strs.length; i++) {
         if(strs[i].equals("["))
            stack.push(current);
         else if (strs[i].equals("]")) {
            stack.pop();
         } else {
            current = new Node(Integer.parseInt(strs[i]), new ArrayList<>());
            stack.peek().children.add(current);
         }
      }
      return root;
   }

   private static class Node {
      private int val;
      private List<Node> children;

      public Node() {
      }

      private Node(int _val, List<Node> _children) {
         val = _val;
         children = _children;
      }
   }

   public static void main(String[] args) {
      Node root = new Node(
            1,  Arrays.asList(new Node(3, Arrays.asList(new Node(5, null), new Node(6, null))),
            new Node(2, null),
            new Node(4, null)));
      String data = serialize(root);
      System.out.println(data);
      Node node = deserialize(data);
      System.out.println(serialize(node));
   }
}