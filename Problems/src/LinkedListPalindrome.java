public class LinkedListPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while( slow != null) {
            if(fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(12);
        System.out.println(isPalindrome(node));
    }
}
