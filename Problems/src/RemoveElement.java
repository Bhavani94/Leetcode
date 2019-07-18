public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        while (i < len){
            if(nums[i] == val){
                nums[i] = nums[len-1];
                len--;
            } else
                i++;
        }
        return len;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode pre = ans;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(5);
        ListNode ans = removeElements(l1,2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
        System.out.println(removeElement(new int[]{3,2,2,3}, 4));
    }
}
