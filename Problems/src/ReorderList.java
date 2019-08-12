public class ReorderList {
   private static void reorderList(ListNode head) {
      if(head == null || head.next == null)
         return;

      ListNode fast = head, slow = head;
      while(fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }

      ListNode head2 = reverse(slow.next);
      slow.next = null;

      ListNode next1, next2;
      while(head != null && head2 != null) {
         next1 = head.next;
         next2 = head2.next;
         head.next = head2;
         head2.next = next1;
         head2 = next2;
         head = next1;
      }

   }

   private static ListNode reverse(ListNode head) {
      if(head == null || head.next == null)
         return head;

      ListNode curr = head, prev = null, next;
      while(curr != null) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }
      return prev;
   }

   public static void main(String[] args) {
      ListNode node = new ListNode(1);
      node.next = new ListNode(2);
      node.next.next = new ListNode(3);
      node.next.next.next = new ListNode(4);
      node.next.next.next.next = new ListNode(5);
      reorderList(node);
      while(node != null) {
         System.out.print(node.val + "->");
         node = node.next;
      }
   }
}
