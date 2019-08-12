import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++)
            ans[i] = map.getOrDefault(nums1[i], -1);

        return ans;
    }

    private static int nextGreaterElement(int n) {
        if(n == 0)
            return -1;
        char[] number = (n + "").toCharArray();
        int len = number.length, i;

        //1. find backwards
        for(i = len - 1; i > 0; i--) {
            if(number[i - 1] < number[i])
                break;
        }

        if(i == 0)
            return -1;

        //2. first, second
        int low = i - 1, next = i;

        //3. find the next greater than first, backward and swap
        for(i = len - 1; i >= 0; i--) {
            if(number[i] > number[low]) {
                char temp = number[i];
                number[i] = number[low];
                number[low] = temp;
                break;
            }
        }

        //4. reverse after second
        reverse(number, next);

        //5. convert back
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;

    }

    private static void reverse(char[] number, int start) {
        int end = number.length - 1;
        while (start < end) {
            char t = number[end];
            number[end] = number[start];
            number[start] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] ans = nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        System.out.println(Arrays.toString(ans));

        System.out.println(nextGreaterElement(132));
        System.out.println(nextGreaterElement(123));
        System.out.println(nextGreaterElement(321));

    }
}
