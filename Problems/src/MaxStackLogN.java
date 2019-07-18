import java.util.Map;
import java.util.TreeMap;

public class MaxStackLogN {
   Map<Integer, DoubleNode> map;
   DoubleNode head;

   public MaxStackLogN() {
      map = new TreeMap<>();
      head = new DoubleNode(-1);
   }

   public void push(int x) {
      DoubleNode newNode = new DoubleNode(x);
      map.put(x, newNode);
      newNode.next = head.next;
      newNode.prev = head;
      head.prev = newNode;


   }

   public int pop() {
      return 0;
   }

   public int top() {
      return 0;
   }

   public int peekMax() {
      return 0;
   }

   public int popMax() {
      return 0;
   }

   private class DoubleNode {
      int val;
      DoubleNode prev, next;

      DoubleNode(int val) {
         this.val = val;
      }
   }
}
