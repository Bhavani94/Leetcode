public class MaxArea {
    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0, j=height.length-1; i < j;){
            area = Math.max((Math.min(height[i], height[j]) * (j-i)), area);
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{6}));
    }
}
