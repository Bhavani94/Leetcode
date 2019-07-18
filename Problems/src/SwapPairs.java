public class SwapPairs {
   private static ListNode swapPairs(ListNode head) {
      if(head == null)
         return null;
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode curr = dummy;
      while(curr.next != null && curr.next.next != null) {
         ListNode first = curr.next;
         ListNode second = curr.next.next;
         first.next = second.next;
         second.next = first;
         curr.next = second;
         curr = curr.next.next;
      }
      return dummy.next;
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(3);
//      l1.next.next.next = new ListNode(4);
      ListNode ans = swapPairs(l1);
      while(ans != null) {
         System.out.print(ans.val + " -> ");
         ans = ans.next;
      }
   }
}
