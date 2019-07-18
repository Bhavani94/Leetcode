public class LinkedListNthNode {
   public static ListNode removeNthFromEnd(ListNode head, int n) {
      if(head == null)
         return null;

      ListNode temp = new ListNode(-1);
      temp.next = head;
      ListNode fast = temp, slow = temp;
      while(n-- >= 0 && fast != null) {
         fast = fast.next;
      }

      while(fast != null) {
         fast = fast.next;
         slow = slow.next;
      }
      slow.next = slow.next.next;

      return temp.next;
   }

   public static void main(String[] args) {
      ListNode node = new ListNode(1);
      node.next = new ListNode(2);
      node.next.next = new ListNode(3);
      node.next.next.next = new ListNode(4);
      node.next.next.next.next = new ListNode(5);
      ListNode ans = removeNthFromEnd(node, 5);
      while(ans != null) {
         System.out.print(ans.val + "->");
         ans = ans.next;
      }
   }
}
