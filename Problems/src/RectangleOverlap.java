public class RectangleOverlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2] ||
                 rec1[1] >= rec2[3] ||
                 rec1[2] <= rec2[0] ||
                 rec1[3] <= rec2[1]);
    }

    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
        System.out.println(isRectangleOverlap(new int[]{5,15,8,18}, new int[]{0,3,7,9}));
    }
}
