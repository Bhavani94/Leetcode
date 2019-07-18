import java.util.ArrayList;
import java.util.List;

public class MajorityElelement {
    /*
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     */

    public static int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int count = 0, majority = nums[0];
        for (int i : nums) {
            if( i == majority) {
                count++;
            } else if(count == 0) {
                majority = i;
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    /*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     */
    public static List<Integer> majorityElementII(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        int count1 = 0 , count2 = 0, element1 = 0, element2 = 0;
        for(int i : nums) {
            if(i == element1) {
                count1++;
            } else if( i == element2) {
                count2++;
            } else if( count1 == 0) {
                element1 = i;
                count1++;
            } else if( count2 == 0) {
                element2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if(element1 == i)
                count1++;
            else if(element2 == i)
                count2++;
        }

        List<Integer> ans =  new ArrayList<>();
        if(count1 > nums.length/3)
            ans.add(element1);
        if(count2 > nums.length/3)
            ans.add(element2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{ 1, 2, 1, 2, 2}));
        System.out.println(majorityElementII(new int[]{ 1, 4, 3, 2, 2}));
        System.out.println(majorityElementII(new int[]{ 1, 3, 2, 2}));
    }
}
