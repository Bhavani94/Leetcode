public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1)
            return len;
        int j = 0;
        for(int i=1; i<len; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];

            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,3,3,5,6,6}));
    }
}
