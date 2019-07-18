public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int s = 0;
        for(int i : nums)
            sum += i;
        for(int i = 0; i< nums.length; i++){
            if(sum == s + nums[i])
                return i;
            s += nums[i];
            sum -= nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex p = new PivotIndex();
        System.out.println(p.pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
    }
}
