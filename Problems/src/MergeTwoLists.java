public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode list = ans;
        while(l1 != null && l2 != null){
            if(l2.val>l1.val){
                list.next = l1;
                l1 = l1.next;
            }
            else{
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        if(l1 != null)
            list.next = l1;
        else
            list.next = l2;
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        ListNode ans = mergeTwoLists(l1,l2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
