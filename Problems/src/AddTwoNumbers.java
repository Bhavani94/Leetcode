public class AddTwoNumbers {
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode p = l1, q = l2, curr = ans;
        int carry = 0;
        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if(carry > 0)
            curr.next = new ListNode(carry);
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers res = new AddTwoNumbers();
        ListNode ans = res.addTwoNumbers(l1, l2);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
