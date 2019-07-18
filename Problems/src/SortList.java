public class SortList {
   private static ListNode sortList(ListNode head) {
      if(head == null || head.next == null)
         return head;

      ListNode prev = null, slow = head, fast = head;

      while(fast != null && fast.next != null) {
         prev = slow;
         slow = slow.next;
         fast = fast.next.next;
      }

      prev.next = null;

      ListNode l1 = sortList(head);
      ListNode l2 = sortList(slow);

      return merge(l1, l2);
   }

   private static ListNode merge(ListNode l1, ListNode l2) {
      ListNode p = new ListNode(-1), result = p;
      while(l1 != null && l2 != null) {
         if(l1.val < l2.val) {
            result.next = l1;
            l1 = l1.next;
         } else {
            result.next = l2;
            l2 = l2.next;
         }
         result = result.next;
      }

      while(l1 != null) {
         result.next = l1;
         l1 = l1.next;
         result = result.next;
      }

      while(l2 != null) {
         result.next = l2;
         l2 = l2.next;
         result = result.next;
      }

      return p.next;
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(2);
      l1.next = new ListNode(1);
      l1.next.next = new ListNode(5);
      l1.next.next.next = new ListNode(3);
      l1.next.next.next.next = new ListNode(10);
      l1.next.next.next.next.next = new ListNode(0);

      ListNode ans = sortList(l1);
      while(ans != null){
         System.out.print(ans.val + " -> ");
         ans = ans.next;
      }
   }
}
