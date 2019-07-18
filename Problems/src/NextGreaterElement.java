import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++)
            ans[i] = !map.containsKey(nums1[i]) ? -1 : map.get(nums1[i]);

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        for(int i=0; i<ans.length; i++)
            System.out.println(ans[i]);

    }
}
