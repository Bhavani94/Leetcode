public class MaxAreaOfRectangle {
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        int max = 0, left = 0, right = heights.length - 1, leftMax = 0, rightMax = 0;
        while(left != right) {
            max = Math.max(max, Math.min(heights[left], heights[right]) * (right - left + 1));
            if(heights[right] < heights[left])
                right--;
            else
                left++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }
}
