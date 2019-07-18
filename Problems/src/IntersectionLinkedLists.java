public class IntersectionLinkedLists {
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode tempA = headA, tempB = headB;
        while(tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }

        return tempA;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(10);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(8);
        l2.next.next.next = l1.next.next;
        ListNode ans = getIntersectionNode(l1, l2);
        System.out.println(ans.val);
    }
}
