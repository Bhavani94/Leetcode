public class TrappingWater {
    private static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > leftMax)
                    leftMax = height[left];
                else
                    ans += leftMax - height[left];
                left++;
            }
            else {
                if(height[right] > rightMax)
                    rightMax = height[right];
                else
                    ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,1,0,1,3}));
    }
}
