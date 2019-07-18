public class FlipImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i< A.length; i++)
            reverse(A[i]);
        return A;
    }

    private static void reverse(int[] a){
        int start = 0, end = a.length - 1;
        while(start <= end){
            int t = a[start] ^ 1;
            a[start++] = a[end] ^ 1;
            a[end--] = t;
        }
    }

    public static void main(String[] args) {
        int[][] a = flipAndInvertImage(new int[][]{{1,1,0}, {1,0,1}, {0,0,0}});
        for (int i = 0; i< a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
