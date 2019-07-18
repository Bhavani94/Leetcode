public class ReverseList {
    private static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nex;
        while(curr != null){
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
    return prev;
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;

        for(int i = 0; i < m - 1; i++)
            pre = pre.next;

        ListNode start = pre.next, next = start.next;

        for(int i = m; i < n; i++) {
            start.next = next.next;
            next.next = pre.next; // pre.next since we always want to append to start
            pre.next = next;
            next = start.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(5);
        ListNode ans = reverseList(l1);
        while(ans != null){
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
        System.out.println("");

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode ans1 = reverseBetween(l1, 2, 4);
        while(ans1 != null){
            System.out.print(ans1.val + " -> ");
            ans1 = ans1.next;
        }
    }
}
