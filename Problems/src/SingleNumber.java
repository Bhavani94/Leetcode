public class SingleNumber {
    /*
    Given a sorted array consisting of only integers where every element appears exactly twice except
    for one element which appears exactly once. Find this single element that appears only once.
     */
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (start + end) / 2;
            if(mid % 2 == 1)
                mid --;

            if(nums[mid] == nums[mid + 1])
                start = mid + 2;

            else
                end = mid;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{ 0, 1, 1, 2, 2, 5, 5, 6, 6}));
    }
}
